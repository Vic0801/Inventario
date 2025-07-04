package ec.sasf.inventario.service;

import com.fasterxml.jackson.databind.EnumNamingStrategies;
import ec.sasf.inventario.exception.BadRequestException;
import ec.sasf.inventario.exception.NotFoundException;
import ec.sasf.inventario.persistence.entity.EstadoEnum;
import ec.sasf.inventario.persistence.entity.MovimientoEntity;
import ec.sasf.inventario.persistence.entity.ProductoEntity;
import ec.sasf.inventario.persistence.repository.MovimientoRepository;
import ec.sasf.inventario.persistence.repository.MovimientoRepository;
import ec.sasf.inventario.persistence.repository.ProductoRepository;
import ec.sasf.inventario.service.dto.MovimientoDto;
import ec.sasf.inventario.service.mapper.MovimientoMapper;
import ec.sasf.inventario.service.mapper.MovimientoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private MovimientoRepository movimientoRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private MovimientoMapper movimientoMapper;

    public MovimientoEntity registrarMovimiento(MovimientoDto movimientoDto){
        //verificar que exista el producto
        ProductoEntity producto = productoRepository.findById(movimientoDto.getProductoId())
                .orElseThrow(()-> new NotFoundException("Producto no existe"));

        String tipo = movimientoDto.getTipoMovimiento().toLowerCase();

        int stockActual;

        if(tipo.equals("entrada")){
             stockActual= producto.getStock() + movimientoDto.getCantidad();
        }else if (tipo.equals("salida")) {
            //Validar stock
            if (producto.getStock() < movimientoDto.getCantidad()) {
                throw new BadRequestException("Solo hay " + producto.getStock() + " en stock");
            }
            //actualizar stock
             stockActual= producto.getStock() - movimientoDto.getCantidad();
        }else{
            throw new BadRequestException( "Tipo de movimiento no válido. Debe ser 'entrada' o 'salida'");
        }

        // Actualizar el stock y guardar cambios
        producto.setStock(stockActual);
        productoRepository.save(producto);

        MovimientoEntity movimientoEntity = movimientoMapper.movimientoToEntity(movimientoDto);
        movimientoEntity.setEstado(EstadoEnum.ACTIVO);

        return movimientoRepository.save(movimientoEntity);
    }

    public List<MovimientoEntity> listarMovimientosId(Long id){
        //validar que exista el producto
        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Producto no existe"));
        return movimientoRepository.findByProductoId(id);
    }
}

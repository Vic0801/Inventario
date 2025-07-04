package ec.sasf.inventario.service;

import ec.sasf.inventario.exception.NotFoundException;
import ec.sasf.inventario.persistence.entity.EstadoEnum;
import ec.sasf.inventario.persistence.entity.ProductoEntity;
import ec.sasf.inventario.persistence.entity.ProveedorEntity;
import ec.sasf.inventario.persistence.repository.ProductoRepository;
import ec.sasf.inventario.persistence.repository.ProductoRepository;
import ec.sasf.inventario.persistence.repository.ProveedorRepository;
import ec.sasf.inventario.service.dto.ProductoDto;
import ec.sasf.inventario.service.mapper.ProductoMapper;
import ec.sasf.inventario.service.mapper.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private ProveedorRepository proveedorRepository;


    public ProductoEntity registrarProducto(ProductoDto productoDto){

       //validar que exista el proveedor
        ProveedorEntity proveedor = proveedorRepository.findById(productoDto.getProveedorId())
                .orElseThrow(()->new NotFoundException("Proveedor no existe"));

        ProductoEntity productoEntity = productoMapper.productoToEntity(productoDto);
        productoEntity.setEstado(EstadoEnum.ACTIVO);
        return productoRepository.save(productoEntity);
    }

    public List<ProductoEntity> listarProductos(){
        return productoRepository.findAll();
    }

    public ProductoEntity actualizarPrecio(ProductoDto dto, Long id){
        //validar que exista el producto
        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(()-> new NotFoundException ("Producto no existe"));
        //Consultar esta parte
         producto.setPrecio(dto.getPrecio());
        return productoRepository.save(producto);



    }
}

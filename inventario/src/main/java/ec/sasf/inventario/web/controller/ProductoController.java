package ec.sasf.inventario.web.controller;

import ec.sasf.inventario.persistence.entity.MovimientoEntity;
import ec.sasf.inventario.persistence.entity.ProductoEntity;
import ec.sasf.inventario.service.MovimientoService;
import ec.sasf.inventario.service.ProductoService;
import ec.sasf.inventario.service.dto.ApiResponse;
import ec.sasf.inventario.service.dto.MovimientoDto;
import ec.sasf.inventario.service.dto.ProductoDto;
import ec.sasf.inventario.service.mapper.MovimientoMapper;
import ec.sasf.inventario.service.mapper.ProductoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;
    @Autowired
    private MovimientoService movimientoService;
    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private MovimientoMapper movimientoMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<ProductoDto>> crearProductos(@RequestBody ProductoDto dto){
        ProductoEntity productoEntity = productoService.registrarProducto(dto);
        ProductoDto nuevo = productoMapper.productoToDto(productoEntity);
        ApiResponse<ProductoDto> response = new ApiResponse<>(
                "success",
                " Producto creado exitosamente",
                HttpStatus.CREATED.value(),
                nuevo
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity <ApiResponse<List<ProductoDto>>> listarProductos(){
        List<ProductoEntity> productoEntities = this.productoService.listarProductos();
        List<ProductoDto> productoDtos = productoMapper.productoListToDto(productoEntities);
        ApiResponse<List<ProductoDto>> response = new ApiResponse<>(
                "success",
                "Productos obtenidos exitosamente",
                HttpStatus.ACCEPTED.value(),
                productoDtos
        );
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);


    }

    @PutMapping("/{id}/precio")
    public ResponseEntity<ApiResponse<ProductoDto>> actualizarPrecio(@PathVariable Long id, @RequestBody ProductoDto dto){

        ProductoEntity producto = productoService.actualizarPrecio(dto, id);
        ProductoDto actual = productoMapper.productoToDto(producto);

        ApiResponse<ProductoDto> response = new ApiResponse<>(
                "success",
                "Precio actualizado exitosamente",
                HttpStatus.ACCEPTED.value(),
                actual

        );

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);

    }

    @GetMapping("/{id}/movimientos")
    public ResponseEntity<ApiResponse<List<MovimientoDto>>> movimientosInventario(@PathVariable Long id){
        List<MovimientoEntity> listaEntity = movimientoService.listarMovimientosId(id);
        List<MovimientoDto> lista= movimientoMapper.movimientoListToDto(listaEntity);

        ApiResponse<List<MovimientoDto>> response = new ApiResponse<>(
                "success",
                "Movimientos obtenidos exitosamente",
                HttpStatus.ACCEPTED.value(),
                lista

        );
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

}

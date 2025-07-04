package ec.sasf.inventario.service.mapper;

import ec.sasf.inventario.persistence.entity.ProductoEntity;
import ec.sasf.inventario.service.dto.ProductoDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-04T10:50:58-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoDto productoToDto(ProductoEntity productoEntity) {
        if ( productoEntity == null ) {
            return null;
        }

        ProductoDto productoDto = new ProductoDto();

        productoDto.setIdProducto( productoEntity.getIdProducto() );
        productoDto.setNombre( productoEntity.getNombre() );
        productoDto.setDescripcion( productoEntity.getDescripcion() );
        productoDto.setPrecio( productoEntity.getPrecio() );
        productoDto.setStock( productoEntity.getStock() );
        productoDto.setProveedorId( productoEntity.getProveedorId() );

        return productoDto;
    }

    @Override
    public ProductoEntity productoToEntity(ProductoDto productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setIdProducto( productoDto.getIdProducto() );
        productoEntity.setNombre( productoDto.getNombre() );
        productoEntity.setDescripcion( productoDto.getDescripcion() );
        productoEntity.setPrecio( productoDto.getPrecio() );
        productoEntity.setStock( productoDto.getStock() );
        productoEntity.setProveedorId( productoDto.getProveedorId() );

        return productoEntity;
    }

    @Override
    public List<ProductoDto> productoListToDto(List<ProductoEntity> producto) {
        if ( producto == null ) {
            return null;
        }

        List<ProductoDto> list = new ArrayList<ProductoDto>( producto.size() );
        for ( ProductoEntity productoEntity : producto ) {
            list.add( productoToDto( productoEntity ) );
        }

        return list;
    }
}

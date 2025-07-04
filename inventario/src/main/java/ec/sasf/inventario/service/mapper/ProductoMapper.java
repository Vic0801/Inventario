package ec.sasf.inventario.service.mapper;

import ec.sasf.inventario.persistence.entity.ProductoEntity;
import ec.sasf.inventario.service.dto.ProductoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDto productoToDto (ProductoEntity productoEntity);

    ProductoEntity productoToEntity(ProductoDto productoDto);

    List<ProductoDto> productoListToDto(List<ProductoEntity> producto);
}

package ec.sasf.inventario.service.mapper;

import ec.sasf.inventario.persistence.entity.ProveedorEntity;
import ec.sasf.inventario.service.dto.ProveedorDto;
import org.mapstruct.Mapper;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.Mapping;

@Mapper(componentModel = "spring")
public interface ProveedorMapper {

    ProveedorDto proveedorToDto (ProveedorEntity proveedorEntity);

    ProveedorEntity proveedorToEntity(ProveedorDto proveedorDto);
}

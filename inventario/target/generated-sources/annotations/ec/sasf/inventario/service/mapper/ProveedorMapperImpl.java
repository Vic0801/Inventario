package ec.sasf.inventario.service.mapper;

import ec.sasf.inventario.persistence.entity.ProveedorEntity;
import ec.sasf.inventario.service.dto.ProveedorDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-04T09:43:20-0600",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ProveedorMapperImpl implements ProveedorMapper {

    @Override
    public ProveedorDto proveedorToDto(ProveedorEntity proveedorEntity) {
        if ( proveedorEntity == null ) {
            return null;
        }

        ProveedorDto proveedorDto = new ProveedorDto();

        proveedorDto.setIdProveedor( proveedorEntity.getIdProveedor() );
        proveedorDto.setNombre( proveedorEntity.getNombre() );
        proveedorDto.setCorreo( proveedorEntity.getCorreo() );
        proveedorDto.setTelefono( proveedorEntity.getTelefono() );

        return proveedorDto;
    }

    @Override
    public ProveedorEntity proveedorToEntity(ProveedorDto proveedorDto) {
        if ( proveedorDto == null ) {
            return null;
        }

        ProveedorEntity proveedorEntity = new ProveedorEntity();

        proveedorEntity.setIdProveedor( proveedorDto.getIdProveedor() );
        proveedorEntity.setNombre( proveedorDto.getNombre() );
        proveedorEntity.setCorreo( proveedorDto.getCorreo() );
        proveedorEntity.setTelefono( proveedorDto.getTelefono() );

        return proveedorEntity;
    }
}

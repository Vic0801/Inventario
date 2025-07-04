package ec.sasf.inventario.service.mapper;

import ec.sasf.inventario.persistence.entity.MovimientoEntity;
import ec.sasf.inventario.service.dto.MovimientoDto;
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
public class MovimientoMapperImpl implements MovimientoMapper {

    @Override
    public MovimientoDto movimientoToDto(MovimientoEntity movimientoEntity) {
        if ( movimientoEntity == null ) {
            return null;
        }

        MovimientoDto movimientoDto = new MovimientoDto();

        movimientoDto.setIdMovimiento( movimientoEntity.getIdMovimiento() );
        movimientoDto.setCantidad( movimientoEntity.getCantidad() );
        movimientoDto.setTipoMovimiento( movimientoEntity.getTipoMovimiento() );
        movimientoDto.setProductoId( movimientoEntity.getProductoId() );
        if ( movimientoEntity.getFechaCreacion() != null ) {
            movimientoDto.setFechaCreacion( movimientoEntity.getFechaCreacion().toLocalDate() );
        }

        return movimientoDto;
    }

    @Override
    public MovimientoEntity movimientoToEntity(MovimientoDto movimientoDto) {
        if ( movimientoDto == null ) {
            return null;
        }

        MovimientoEntity movimientoEntity = new MovimientoEntity();

        if ( movimientoDto.getFechaCreacion() != null ) {
            movimientoEntity.setFechaCreacion( movimientoDto.getFechaCreacion().atStartOfDay() );
        }
        movimientoEntity.setIdMovimiento( movimientoDto.getIdMovimiento() );
        movimientoEntity.setCantidad( movimientoDto.getCantidad() );
        movimientoEntity.setTipoMovimiento( movimientoDto.getTipoMovimiento() );
        movimientoEntity.setProductoId( movimientoDto.getProductoId() );

        return movimientoEntity;
    }

    @Override
    public List<MovimientoDto> movimientoListToDto(List<MovimientoEntity> movimiento) {
        if ( movimiento == null ) {
            return null;
        }

        List<MovimientoDto> list = new ArrayList<MovimientoDto>( movimiento.size() );
        for ( MovimientoEntity movimientoEntity : movimiento ) {
            list.add( movimientoToDto( movimientoEntity ) );
        }

        return list;
    }
}

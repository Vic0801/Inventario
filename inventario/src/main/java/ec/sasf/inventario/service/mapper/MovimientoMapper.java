package ec.sasf.inventario.service.mapper;

import ec.sasf.inventario.persistence.entity.MovimientoEntity;
import ec.sasf.inventario.persistence.entity.MovimientoEntity;
import ec.sasf.inventario.service.dto.MovimientoDto;
import ec.sasf.inventario.service.dto.MovimientoDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

    MovimientoDto movimientoToDto (MovimientoEntity movimientoEntity);

    MovimientoEntity movimientoToEntity(MovimientoDto movimientoDto);

    List<MovimientoDto> movimientoListToDto(List<MovimientoEntity> movimiento);
}

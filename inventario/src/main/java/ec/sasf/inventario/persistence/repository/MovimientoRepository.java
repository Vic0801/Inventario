package ec.sasf.inventario.persistence.repository;

import ec.sasf.inventario.persistence.entity.MovimientoEntity;
import ec.sasf.inventario.service.dto.MovimientoDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    List<MovimientoEntity> findByProductoId(Long id);
}

package ec.sasf.inventario.persistence.repository;

import ec.sasf.inventario.persistence.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long> {
}

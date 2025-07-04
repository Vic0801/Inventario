package ec.sasf.inventario.persistence.repository;

import ec.sasf.inventario.persistence.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Long> {
}

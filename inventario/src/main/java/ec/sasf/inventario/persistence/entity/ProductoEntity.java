package ec.sasf.inventario.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "producto")
@Data
public class ProductoEntity extends CamposGenerales  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer stock;
    @Column(name = "proveedor_id", nullable = false)
    private Long proveedorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proveedor_id",referencedColumnName = "id_proveedor", insertable = false, updatable = false)
    @JsonIgnore
    private ProveedorEntity proveedor;

}

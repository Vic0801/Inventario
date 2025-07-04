package ec.sasf.inventario.persistence.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "movimiento_inventario")
@Data
public class MovimientoEntity extends CamposGenerales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long idMovimiento;

    private Integer cantidad;

    private String tipoMovimiento; // entrada o salida

//    @Temporal(TemporalType.DATE)
//    private LocalDate fecha;

    @Column(name = "producto_id", nullable = false)
    private Long productoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id",referencedColumnName = "id_producto", insertable = false, updatable = false)
    @JsonIgnore
    private ProductoEntity producto;

}

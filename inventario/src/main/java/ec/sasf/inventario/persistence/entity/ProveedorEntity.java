package ec.sasf.inventario.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "proveedor")
@Data
public class ProveedorEntity extends CamposGenerales  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long idProveedor;

    private String nombre;

    private String correo;

    private String telefono;

//    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
//    private List<ProductoEntity> productos;


}

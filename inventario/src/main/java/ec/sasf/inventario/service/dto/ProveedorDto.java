package ec.sasf.inventario.service.dto;


import lombok.Data;

import java.util.List;
@Data
public class ProveedorDto {

    private Long idProveedor;
    private String nombre;
    private String correo;
    private String telefono;

//    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
//    private List<ProductoEntity> productos;
}

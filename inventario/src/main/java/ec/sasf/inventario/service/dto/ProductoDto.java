package ec.sasf.inventario.service.dto;

import lombok.Data;

@Data
public class ProductoDto {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private Long proveedorId;


}

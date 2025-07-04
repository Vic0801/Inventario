package ec.sasf.inventario.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ec.sasf.inventario.persistence.entity.ProductoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class MovimientoDto {
    private Long idMovimiento;
    private Integer cantidad;
    private String tipoMovimiento; // entrada o salida
    private Long productoId;
    private LocalDate fechaCreacion;


}

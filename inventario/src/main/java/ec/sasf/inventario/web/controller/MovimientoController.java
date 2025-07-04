package ec.sasf.inventario.web.controller;

import ec.sasf.inventario.persistence.entity.MovimientoEntity;
import ec.sasf.inventario.service.MovimientoService;
import ec.sasf.inventario.service.dto.ApiResponse;
import ec.sasf.inventario.service.dto.MovimientoDto;
import ec.sasf.inventario.service.mapper.MovimientoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    @Autowired
    private MovimientoService movimientoService;
    @Autowired
    private MovimientoMapper movimientoMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<MovimientoDto>> crearMovimiento(@RequestBody MovimientoDto dto){
        MovimientoEntity movimientoEntity = movimientoService.registrarMovimiento(dto);
        MovimientoDto nuevo = movimientoMapper.movimientoToDto(movimientoEntity);
        ApiResponse<MovimientoDto> response = new ApiResponse<>(
                "success",
                "Movimiento creado exitosamente",
                HttpStatus.CREATED.value(),
                nuevo
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

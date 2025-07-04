package ec.sasf.inventario.web.controller;

import ec.sasf.inventario.persistence.entity.ProveedorEntity;
import ec.sasf.inventario.service.ProveedorService;
import ec.sasf.inventario.service.dto.ApiResponse;
import ec.sasf.inventario.service.dto.MovimientoDto;
import ec.sasf.inventario.service.dto.ProveedorDto;
import ec.sasf.inventario.service.mapper.ProveedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private ProveedorMapper proveedorMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<ProveedorDto>> crearProveedor(@RequestBody ProveedorDto dto){
        ProveedorEntity proveedorEntity = proveedorService.registrarProveedor(dto);
        ProveedorDto nuevo = proveedorMapper.proveedorToDto(proveedorEntity);
        ApiResponse<ProveedorDto> response = new ApiResponse<>(
                "success",
                "Proveedor creado exitosamente",
                HttpStatus.CREATED.value(),
                nuevo
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}

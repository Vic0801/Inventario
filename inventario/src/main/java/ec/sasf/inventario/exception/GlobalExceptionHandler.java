package ec.sasf.inventario.exception;

import ec.sasf.inventario.service.dto.ApiResponse;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> manejarNotFound(NotFoundException ex) {
        ApiResponse<Object> respuesta = new ApiResponse<>(
                "error",
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> manejarBadRequest(BadRequestException ex) {
        ApiResponse<Object> respuesta = new ApiResponse<>(
                "error",
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }

    // Genérico para errores no controlados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> manejarExcepciones(Exception ex) {
        ApiResponse<Object> respuesta = new ApiResponse<>(
                "error",
                "Error interno del servidor",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
    }
}

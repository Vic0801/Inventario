package ec.sasf.inventario.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class CamposGenerales {

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private EstadoEnum estado;

    @CreatedBy
    @Column(name = "usuario_creacion", updatable = false, length = 50)
    private String usuarioCreacion;

    @LastModifiedBy
    @Column(name = "usuario_modificacion", length = 50)
    private String usuarioModificacion;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
}

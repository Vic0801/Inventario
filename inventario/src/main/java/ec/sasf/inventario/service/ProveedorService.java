package ec.sasf.inventario.service;

import ec.sasf.inventario.persistence.entity.EstadoEnum;
import ec.sasf.inventario.persistence.entity.ProveedorEntity;
import ec.sasf.inventario.persistence.repository.ProveedorRepository;
import ec.sasf.inventario.service.dto.ProveedorDto;
import ec.sasf.inventario.service.mapper.ProveedorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ProveedorMapper proveedorMapper;


    public ProveedorEntity registrarProveedor(ProveedorDto proveedorDto){
        ProveedorEntity proveedorEntity = proveedorMapper.proveedorToEntity(proveedorDto);
        proveedorEntity.setEstado(EstadoEnum.ACTIVO);
        return proveedorRepository.save(proveedorEntity);
    }
}

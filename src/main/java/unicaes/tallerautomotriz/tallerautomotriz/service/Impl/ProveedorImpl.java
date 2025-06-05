package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ProveedorDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.ProveedorRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.IProveedor;

import java.util.List;

@Service
public class ProveedorImpl  implements IProveedor {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorDto> findAll(){
        return buscarproveedorDto().findAll();
    }

    public ProveedorEntity save(ProveedorEntity proveedor){
        return proveedorRepository.save(proveedor);
    }

    @Override
    public List<ProveedorDto> buscarproveedorDto()
    {
        return proveedorRepository.buscarproveedorDto();
    }
}

package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.ClienteRepository;
import unicaes.tallerautomotriz.tallerautomotriz.repository.ProveedorRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.IProveedor;

import java.util.List;

@Service
public class ProveedorImpl  implements IProveedor {
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ProveedorEntity> findAll(){
        return proveedorRepository.findAll();
    }

    public ProveedorEntity save(ProveedorEntity proveedor){
        return proveedorRepository.save(proveedor);
    }
}

package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ProveedorDto;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ProveedorEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.ProveedorRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.IProveedor;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorImpl  implements IProveedor {
    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<ProveedorEntity> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Optional<ProveedorEntity> findById(Long id) {
        return proveedorRepository.findById(id);
    }

    @Override
    public ProveedorEntity save(ProveedorEntity proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public void delete(Long id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public List<ProveedorDto> findByNombre(String nombre) {
        return proveedorRepository.findByNombre(nombre);
    }

    @Override
    public ProveedorEntity update(Long id, ProveedorEntity updatedProveedor) {
    return proveedorRepository.findById(id)
            .map(existingProveedor -> {
                existingProveedor.setNombre(updatedProveedor.getNombre());
                existingProveedor.setDireccion(updatedProveedor.getDireccion());
                existingProveedor.setTelefono(updatedProveedor.getTelefono());
                return proveedorRepository.save(existingProveedor);
            })
            .orElseThrow(() -> new RuntimeException("Proveedor not found"));
}
}

package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.ClienteEntity;

import unicaes.tallerautomotriz.tallerautomotriz.entities.Dto.ClienteDto;
import unicaes.tallerautomotriz.tallerautomotriz.repository.ClienteRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.ICliente;

import java.util.List;

@Service
public class ClienteImpl implements ICliente {

    //para leer
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public List<ClienteEntity> findNameLess(String nombre) {
        return clienteRepository.findNameLess(nombre);
    }

    @Override
    public List<ClienteDto> buscarClienteDto() {
        return clienteRepository.buscarClienteDto();
    }


    //para escribir
    public ClienteEntity save(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }
}

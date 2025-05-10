package unicaes.tallerautomotriz.tallerautomotriz.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unicaes.tallerautomotriz.tallerautomotriz.entities.RepuestoEntity;
import unicaes.tallerautomotriz.tallerautomotriz.repository.RepuestoRepository;
import unicaes.tallerautomotriz.tallerautomotriz.service.IRepuesto;

import java.util.List;

@Service
public class RepuestoImpl implements IRepuesto {

    //para leer
    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public List<RepuestoEntity> findAll(){
        return repuestoRepository.findAll();

    }

    //para guardar

    public RepuestoEntity save(RepuestoEntity repuesto) {
        return repuestoRepository.save(repuesto);
    }


}

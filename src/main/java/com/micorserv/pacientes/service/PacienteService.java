package com.micorserv.pacientes.service;

import com.micorserv.pacientes.model.Paciente;
import com.micorserv.pacientes.repository.IPacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// implementation de la clase IPacienteService
@Service
public class PacienteService implements IPacienteService {

    // inyección de la dependencia de JPARepository para tomar los métodos CRUD
    @Autowired
    private IPacienteRepository pacienteRepo;

    @Override
    public List<Paciente> getPacientes() {
        return pacienteRepo.findAll();
    }

    @Transactional
    public void savePaciente(Paciente pac) {
        pacienteRepo.save(pac);
    }

    @Override
    public void deletePaciente(Long id) {
        pacienteRepo.deleteById(id);

    }

    @Override
    public Paciente findPaciente(Long id) {
        return pacienteRepo.findById(id).orElse(null);
    }

    @Override
    public void editPaciente(Long id, Paciente pac) {
        pacienteRepo.save(pac);

    }

    @Override
    public Paciente findPacienteDni(String dni) {
        return pacienteRepo.findByDni(dni);
    }
}

package com.micorserv.pacientes.service;

import com.micorserv.pacientes.model.Paciente;

import java.util.List;

public interface IPacienteService {
    public List<Paciente>getPacientes();
    public void savePaciente(Paciente pac);
    public void deletePaciente(Long id);
    public Paciente findPaciente(Long id); // buscar un
    public void editPaciente(Long id, Paciente pac); // editar un paciente por Id y le pasamos los datos a modificar

    Paciente findPacienteDni(String dni);
    // buscar un paciente por DNI
}

package com.micorserv.pacientes.repository;

import com.micorserv.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    // consulta personalizada para para consultar un paciente atrevés de su ndi
    @Query("SELECT p FROM Paciente p WHERE p.dni = :dni")
    Paciente findByDni(String dni);
}

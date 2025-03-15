package com.micorserv.pacientes.controller;

import com.micorserv.pacientes.model.Paciente;
import com.micorserv.pacientes.repository.IPacienteRepository;
import com.micorserv.pacientes.service.IPacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PacienteController {

    // inyección de la dependencia al la interfaz services para solicitar la inf
    @Autowired
    private IPacienteService pacienteServ;

    //1- crear un nuevo paciente
    @PostMapping ("/pacientes/crear")
    public String crearPaciente(@RequestBody Paciente pac) {
        System.out.println("Paciente recibido: " + pac);
        pacienteServ.savePaciente(pac);
        return "El paciente fue creado correctamente";
    }


    //2. traer todos los pacientes
    @GetMapping("pacientes/traer")
    public List<Paciente> traerPacientes() {
        return pacienteServ.getPacientes();
    }

    //3. eliminar un paciente
    @DeleteMapping("pacientes/borrar/{id}")
    public String deletePaciente(@PathVariable Long id) {
        pacienteServ.deletePaciente(id);
        return "El paciente fue eliminado correctamente";
    }

    //4. editar un paciente
    @PutMapping("pacientes/editar/{id_original}")
    public Paciente editPaciente(@PathVariable Long id_original,
                                 @RequestBody Paciente pacienteEditar) {
        pacienteServ.editPaciente(id_original, pacienteEditar);
        return pacienteServ.findPaciente(id_original);
    }

    //5. obtener un paciente en particular@Operation(
    @Operation(
            summary = "Obtener un turno por ID",
            description = "Devuelve la información de un turno específico dado su ID."
    )@ApiResponse(responseCode = "200", description = "Turno encontrado exitosamente")
    @ApiResponse(responseCode = "404", description = "No se encontró un turno con el ID especificado")

    @GetMapping("pacientes/traer/{id}")
    public Paciente traerPacientes(@PathVariable Long id) {
        return pacienteServ.findPaciente(id);
    }

    // traer buscar un paciente por su dni
    @GetMapping ("/pacientes/traerdni/{dni}")
    public Paciente traerPacienteDni (@PathVariable String dni) {
        return pacienteServ.findPacienteDni(dni);
    }


}

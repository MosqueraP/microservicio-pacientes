package com.micorserv.pacientes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPaciente;

//    @JsonProperty("dni")
    private String dni;

//    @JsonProperty("nombre")
    private String nombre;

//    @JsonProperty("apellido")
    private String apellido;

//    @JsonProperty("fechaNac")
    @Temporal (TemporalType.DATE)
    private LocalDate fechaNac;

//    @JsonProperty("telefono")
    private String telefono;
}
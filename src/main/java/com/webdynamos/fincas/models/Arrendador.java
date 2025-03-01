package com.webdynamos.fincas.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "arrendador")
public class Arrendador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_arrendador;
    private int calificacion;
    private String username;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String password;

    @OneToMany(mappedBy = "arrendador")
    @JsonIgnore
    @ToString.Exclude
    private Set<CalificacionArrendatario> calificacion_arrendatarios;

    @OneToMany(mappedBy = "arrendador")
    @JsonIgnore
    @ToString.Exclude
    private Set<CalificacionPropiedad> calificacion_propiedades;

    @OneToMany(mappedBy = "arrendador")
    @JsonIgnore
    @ToString.Exclude
    private Set<Solicitud> arrendador_solicitudes;

}

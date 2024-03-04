package com.webdynamos.fincas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity(name = "propiedad")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_propiedad;
    private int calificacion;
    private float precio;
    private String ubicacion;
    private int disponibilidad;

    @OneToMany(mappedBy = "propiedad")
    @JsonIgnore
    @ToString.Exclude
    private Set<Arrendador_propiedad> calificacion_arrendador_propiedades;

    @OneToOne(mappedBy = "propiedad")
    private Solicitud solicitud;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_arrendador", referencedColumnName = "id_arrendador")
    private Arrendador arrendador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_arrendatario", referencedColumnName = "id_arrendatario")
    private Arrendatario arrendatario;


}

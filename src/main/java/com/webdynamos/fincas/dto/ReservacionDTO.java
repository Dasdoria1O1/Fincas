package com.webdynamos.fincas.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReservacionDTO {

    private Long id;
    private Long arrendadorId;
    private Long propiedadId;
    private String fechaInicio;
    private String fechaFin;
}

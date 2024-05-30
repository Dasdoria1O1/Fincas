package com.webdynamos.fincas.services;

import com.webdynamos.fincas.dto.ReservacionDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservacionService {

    private List<ReservacionDTO> reservaciones = new ArrayList<>();

    public ReservacionDTO obtenerReservacionPorId(Long id) {
        return reservaciones.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    public List<ReservacionDTO> listarReservaciones() {
        return new ArrayList<>(reservaciones);
    }

    public ReservacionDTO crearReservacion(ReservacionDTO reservacionDTO) {
        reservacionDTO.setId((long) (reservaciones.size() + 1));
        reservaciones.add(reservacionDTO);
        return reservacionDTO;
    }

    public ReservacionDTO actualizarReservacion(Long id, ReservacionDTO reservacionDTO) {
        ReservacionDTO existente = obtenerReservacionPorId(id);
        if (existente != null) {
            existente.setArrendadorId(reservacionDTO.getArrendadorId());
            existente.setPropiedadId(reservacionDTO.getPropiedadId());
            existente.setFechaInicio(reservacionDTO.getFechaInicio());
            existente.setFechaFin(reservacionDTO.getFechaFin());
            return existente;
        }
        return null;
    }

    public boolean eliminarReservacion(Long id) {
        return reservaciones.removeIf(r -> r.getId().equals(id));
    }
}

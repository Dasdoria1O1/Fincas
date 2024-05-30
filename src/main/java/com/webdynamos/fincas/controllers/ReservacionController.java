package com.webdynamos.fincas.controllers;

import com.webdynamos.fincas.dto.ReservacionDTO;
import com.webdynamos.fincas.services.ReservacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservaciones")
public class ReservacionController {

    @Autowired
    private ReservacionService reservacionService;

    @GetMapping("/{id}")
    public ResponseEntity<ReservacionDTO> obtenerReservacionPorId(@PathVariable Long id) {
        ReservacionDTO reservacionDTO = reservacionService.obtenerReservacionPorId(id);
        if (reservacionDTO != null) {
            return new ResponseEntity<>(reservacionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<ReservacionDTO> listarReservaciones() {
        return reservacionService.listarReservaciones();
    }

    @PostMapping
    public ResponseEntity<ReservacionDTO> crearReservacion(@RequestBody ReservacionDTO reservacionDTO) {
        ReservacionDTO createdReservacionDTO = reservacionService.crearReservacion(reservacionDTO);
        return new ResponseEntity<>(createdReservacionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservacionDTO> actualizarReservacion(@PathVariable Long id, @RequestBody ReservacionDTO reservacionDTO) {
        ReservacionDTO updatedReservacionDTO = reservacionService.actualizarReservacion(id, reservacionDTO);
        if (updatedReservacionDTO != null) {
            return new ResponseEntity<>(updatedReservacionDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReservacion(@PathVariable Long id) {
        boolean eliminado = reservacionService.eliminarReservacion(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

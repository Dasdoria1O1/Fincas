package com.webdynamos.fincas.services;


import com.webdynamos.fincas.models.Arrendatario;
import com.webdynamos.fincas.models.Propiedad;
import com.webdynamos.fincas.models.Solicitud;
import com.webdynamos.fincas.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;


    @Autowired
    public SolicitudService (SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    //.save de JPA
    public Solicitud CrearSolicitud(Solicitud solicitud)
    {
        return solicitudRepository.save(solicitud);
    }

    //Encuentra todos los elementos
    public List<Solicitud> ListarSolicitudew()
    {
        return solicitudRepository.findAll();
    }

    public Solicitud obtenerSolicitudPorId(Long id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    public Solicitud actualizarSolicitud(Long id, Solicitud solicitud)
    {
        if (solicitudRepository.existsById(id))
        {
            Solicitud cambio = solicitudRepository.findById(id).orElse(null);


            cambio.setDuracion(solicitud.getDuracion());
            cambio.setDuracion(solicitud.getDuracion());
            return solicitudRepository.save(cambio);
        }

        return null;
    }
}

package com.sena.servicioautenticacion.dto;

// Permite devolver un mensaje sencillo al usuario que consume el servicio.
public class RespuestaServicio {

    private String mensaje;

    public RespuestaServicio(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}

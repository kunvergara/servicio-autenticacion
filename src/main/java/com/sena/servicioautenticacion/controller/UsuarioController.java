package com.sena.servicioautenticacion.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.servicioautenticacion.dto.RespuestaServicio;
import com.sena.servicioautenticacion.dto.SolicitudAutenticacion;
import com.sena.servicioautenticacion.service.UsuarioService;

// Define las direcciones (endpoints) que pueden utilizar los usuarios del servicio.
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Servicio para registrar un usuario: POST /api/usuarios/registro
    @PostMapping("/registro")
    public ResponseEntity<RespuestaServicio> registrar(
            @RequestBody SolicitudAutenticacion solicitud) {

        String mensaje = usuarioService.registrarUsuario(
                solicitud.getUsuario(), solicitud.getContrasena());

        if (mensaje.equals("Usuario registrado correctamente.")) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new RespuestaServicio(mensaje));
        }

        return ResponseEntity.badRequest().body(new RespuestaServicio(mensaje));
    }

    // Servicio para iniciar sesión: POST /api/usuarios/login
    @PostMapping("/login")
    public ResponseEntity<RespuestaServicio> iniciarSesion(
            @RequestBody SolicitudAutenticacion solicitud) {

        boolean autenticado = usuarioService.autenticarUsuario(
                solicitud.getUsuario(), solicitud.getContrasena());

        if (autenticado) {
            return ResponseEntity.ok(
                    new RespuestaServicio("Autenticación satisfactoria."));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new RespuestaServicio("Error en la autenticación."));
    }
}

package com.sena.servicioautenticacion.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sena.servicioautenticacion.model.Usuario;

// Contiene la lógica para registrar usuarios y comprobar sus credenciales.
@Service
public class UsuarioService {

    // Para esta actividad se utiliza memoria; los datos se pierden al apagar la aplicación.
    private final Map<String, Usuario> usuarios = new HashMap<>();

    // Registra un usuario si los datos son válidos y el nombre no existe.
    public String registrarUsuario(String nombreUsuario, String contrasena) {
        if (nombreUsuario == null || nombreUsuario.isBlank()
                || contrasena == null || contrasena.isBlank()) {
            return "El usuario y la contraseña son obligatorios.";
        }

        if (usuarios.containsKey(nombreUsuario)) {
            return "El usuario ya se encuentra registrado.";
        }

        usuarios.put(nombreUsuario, new Usuario(nombreUsuario, contrasena));
        return "Usuario registrado correctamente.";
    }

    // Compara los datos recibidos con los datos del usuario registrado.
    public boolean autenticarUsuario(String nombreUsuario, String contrasena) {
        if (nombreUsuario == null || contrasena == null) {
            return false;
        }

        Usuario usuarioEncontrado = usuarios.get(nombreUsuario);

        return usuarioEncontrado != null
                && usuarioEncontrado.getContrasena().equals(contrasena);
    }
}

# Servicio de autenticación

Proyecto académico básico desarrollado con Java 17 y Spring Boot para la evidencia GA7-220501096-AA5-EV01.

## Funcionalidad

- Registrar un usuario.
- Iniciar sesión con usuario y contraseña.
- Responder con un mensaje de autenticación satisfactoria o de error.

## Requisitos

- Java 17 o superior.
- Maven (o utilizar el Maven Wrapper si se agrega posteriormente).
- Visual Studio Code o un editor compatible.

## Ejecutar el proyecto

Desde la carpeta principal del proyecto, ejecutar:

```bash
mvn spring-boot:run
```

La aplicación inicia en `http://localhost:8080`.

## Probar el servicio

Se puede utilizar Postman o la extensión Thunder Client de Visual Studio Code.

### 1. Registrar usuario

- Método: `POST`
- URL: `http://localhost:8080/api/usuarios/registro`
- Cuerpo (Body), formato JSON:

```json
{
  "usuario": "aprendiz",
  "contrasena": "12345"
}
```

Respuesta esperada: `201 Created`

```json
{
  "mensaje": "Usuario registrado correctamente."
}
```

### 2. Iniciar sesión correctamente

- Método: `POST`
- URL: `http://localhost:8080/api/usuarios/login`
- Cuerpo (Body), formato JSON:

```json
{
  "usuario": "aprendiz",
  "contrasena": "12345"
}
```

Respuesta esperada: `200 OK`

```json
{
  "mensaje": "Autenticación satisfactoria."
}
```

### 3. Probar una contraseña incorrecta

Enviar al mismo endpoint de inicio de sesión una contraseña diferente.

Respuesta esperada: `401 Unauthorized`

```json
{
  "mensaje": "Error en la autenticación."
}
```

## Control de versiones con Git

En la terminal, ubicada en la carpeta del proyecto, ejecutar:

```bash
git init
git add .
git commit -m "Creacion del servicio web de autenticacion"
```

Después de crear un repositorio vacío en GitHub, copiar su dirección y ejecutar los comandos que GitHub muestra para conectar y subir el proyecto. Normalmente son:

```bash
git branch -M main
git remote add origin DIRECCION_DEL_REPOSITORIO
git push -u origin main
```

Reemplazar `DIRECCION_DEL_REPOSITORIO` por la dirección real del repositorio creado en GitHub.

## Nota académica

Para mantener el ejemplo sencillo, los usuarios se guardan temporalmente en memoria y las contraseñas no están cifradas. Los registros se pierden cuando se detiene la aplicación. Este ejemplo es para practicar la construcción de una API y no debe utilizarse como sistema de autenticación real.

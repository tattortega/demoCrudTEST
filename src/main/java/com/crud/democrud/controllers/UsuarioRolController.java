package com.crud.democrud.controllers;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.services.UsuarioRolService;
import com.crud.democrud.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Controlador para el Rol
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-06-08
 * @since 1.0.0
 */
@CrossOrigin
@RestController
@RequestMapping("/usuario/rol")
public class UsuarioRolController {

    /**
     * Servicio para el manejo del Rol
     */
    UsuarioRolService usuarioRolService;
    /**
     * Variable para el manejo de las respuestas de las API
     */
    private final Response response = new Response();
    /**
     * Manejo del código HTTP que se responde en las API
     */
    private HttpStatus httpStatus = HttpStatus.OK;

    /**
     * Administrador para las excepciones del sistema
     *
     * @param exception Objeto Exception
     * @author Ricardo Ortega <tattortega.28@gmail.com>
     * @since 1.0.0
     */
    private void getErrorMessageInternal(Exception exception) {
        response.error = true;
        response.message = exception.getMessage();
        response.data = exception.getCause();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    /**
     * Administrador para las excepciones en SQL con respecto al manejo del acceso a los datos
     *
     * @param exception Objeto DataAccessException
     * @author Ricardo Ortega <tattortega.28@gmail.com>
     * @since 1.0.0
     */
    private void getErrorMessageForResponse(DataAccessException exception) {
        response.error = true;
        if (exception.getRootCause() instanceof SQLException) {
            SQLException sqlEx = (SQLException) exception.getRootCause();
            var sqlErrorCode = sqlEx.getErrorCode();
            switch (sqlErrorCode) {
                case 1062:
                    response.message = "El dato ya está registrado";
                    break;
                case 1452:
                    response.message = "El rol indicado no existe";
                    break;
                default:
                    response.message = exception.getMessage();
                    response.data = exception.getCause();
            }
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            response.message = exception.getMessage();
            response.data = exception.getCause();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

    /**
     * Endpoint para obtener todos los roles
     *
     * @return Objeto Response en formato JSON
     */
    @GetMapping()
    public ResponseEntity<Response> getAllUserRoles() {
        response.restart();
        try {
            response.data = usuarioRolService.getUserRoles();
            response.message = "Lista de roles";
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Endpoint para obtener un rol por ID
     *
     * @param id Long
     * @return Objeto Response en formato JSON
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getUserRolById(@PathVariable(value = "id") Long id) {
        response.restart();
        try {
            response.data = usuarioRolService.findById(id);
            response.message = "Rol encontrado";
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Endpoint para obtener roles por el nombre
     *
     * @param rol String
     * @return Objeto Response en formato JSON
     */
    @GetMapping("/query")
    public ResponseEntity<Response> getUserRolByRol(@RequestParam(value = "rol") String rol) {
        response.restart();
        try {
            response.data = usuarioRolService.findByRol(rol);
            response.message = "Roles filtrado por: "+ rol;
            httpStatus = HttpStatus.OK;
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Endpoint para guardar roles
     *
     * @param usuarioRol UsuarioRolModel
     * @return Objeto Response en formato JSON
     */
    @PostMapping()
    public ResponseEntity<Response> saveUserRol(@RequestBody UsuarioRolModel usuarioRol) {
        response.restart();
        try {
            response.data = usuarioRolService.saveUserRol(usuarioRol);
            response.message = "Rol creado";
            httpStatus = HttpStatus.CREATED;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Endpoint para actualizar roles
     *
     * @param usuarioRol UsuarioRolModel
     * @param id         Long
     * @return Objeto Response en formato JSON
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateUserRol(@RequestBody UsuarioRolModel usuarioRol, @PathVariable(value = "id") Long id) {
        response.restart();
        try {
            response.data = usuarioRolService.updateUserRol(id, usuarioRol);
            response.message = "Rol actualizado";
            httpStatus = HttpStatus.OK;
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }

    /**
     * Endpoint para eliminar rol
     *
     * @param id Long
     * @return Objeto Response en formato JSON
     */
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response> deleteUserRol(@PathVariable(value = "id") Long id) {
        response.restart();
        try {
            response.data = usuarioRolService.deleteUserRol(id);
            if (response.data == null) {
                response.message = "El rol no existe";
                httpStatus = HttpStatus.NOT_FOUND;
            } else {
                response.message = "El rol fue eliminado exitosamente";
                httpStatus = HttpStatus.OK;
            }
        } catch (DataAccessException exception) {
            getErrorMessageForResponse(exception);
        } catch (Exception exception) {
            getErrorMessageInternal(exception);
        }
        return new ResponseEntity<>(response, httpStatus);
    }


}

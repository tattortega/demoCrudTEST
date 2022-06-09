package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Clase tipo Servicio para el manejo de Roles de Usuarios
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-06-08
 * @since 1.0.0
 */
@Service
public class UsuarioRolService {

    /**
     * Repositorio de Rol
     */
    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    /**
     * Método para obtener todos los roles
     *
     * @return List
     */
    @Transactional(readOnly = true)
    public List<UsuarioRolModel> getUserRoles() {
        return (List<UsuarioRolModel>) usuarioRolRepository.findAll();
    }

    /**
     * Método para guardar un rol
     *
     * @param usuarioRolModel UsuarioRolModel
     * @return UsuarioRolModel
     */
    @Transactional
    public UsuarioRolModel saveUserRol(UsuarioRolModel usuarioRolModel) {
        return usuarioRolRepository.save(usuarioRolModel);
    }

    /**
     * Método para encontrar por nombre de rol
     *
     * @param rol String
     * @return Optional
     */
    @Transactional(readOnly = true)
    public Optional<UsuarioRolModel> findByRol(String rol) {
        return usuarioRolRepository.findByRol(rol);
    }

    /**
     * Método para buscar rol por ID
     *
     * @param id Long
     * @return Optional
     */
    @Transactional(readOnly = true)
    public Optional<UsuarioRolModel> findById(Long id) {
        return usuarioRolRepository.findById(id);
    }

    /**
     * Método para actualizar rol
     *
     * @param id         Long
     * @param usuarioRol UsuarioRolModel
     * @return UsuarioRolModel
     */
    @Transactional
    public UsuarioRolModel updateUserRol(Long id, UsuarioRolModel usuarioRol) {
        usuarioRol.setId(id);
        return usuarioRolRepository.save(usuarioRol);
    }

    /**
     * Método para eliminar rol
     *
     * @param id Long
     * @return Boolean
     */
    @Transactional
    public Boolean deleteUserRol(Long id) {
        try {
            usuarioRolRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

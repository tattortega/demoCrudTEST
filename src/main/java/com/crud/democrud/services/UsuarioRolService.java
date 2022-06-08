package com.crud.democrud.services;

import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRolService {

    @Autowired
    UsuarioRolRepository usuarioRolRepository;


    @Transactional(readOnly = true)
    public List<UsuarioRolModel> getUserRols() {
        return (List<UsuarioRolModel>) usuarioRolRepository.findAll();
    }


    @Transactional
    public UsuarioRolModel saveUserRol(UsuarioRolModel usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }


    @Transactional(readOnly = true)
    public Optional<UsuarioRolModel> findByRol(String rol) {
        return usuarioRolRepository.findByRol(rol);
    }


    @Transactional(readOnly = true)
    public Optional<UsuarioRolModel> findById(Long id) {
        return usuarioRolRepository.findById(id);
    }


    @Transactional
    public UsuarioRolModel updateUserRol(Long id, UsuarioRolModel usuarioRol) {
        usuarioRol.setId(id);
        return usuarioRolRepository.save(usuarioRol);
    }

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

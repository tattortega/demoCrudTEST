package com.crud.democrud.repositories;

import com.crud.democrud.models.UsuarioRolModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Interfaz del repositorio de Entidad del Rol de Usuario
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-06-08
 * @since 1.0.0
 */
public interface UsuarioRolRepository extends CrudRepository<UsuarioRolModel, Long> {

    /**
     * Método para buscar por nombre de rol
     *
     * @param rol String
     * @return Optional
     */
    Optional<UsuarioRolModel> findByRol(String rol);

}

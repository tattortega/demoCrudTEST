package com.crud.democrud.repositories;

import com.crud.democrud.models.UsuarioRolModel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRolRepository extends CrudRepository<UsuarioRolModel, Long> {

    public abstract Optional<UsuarioRolModel> findByRol(String rol);

}

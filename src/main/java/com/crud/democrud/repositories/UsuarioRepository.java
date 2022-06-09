package com.crud.democrud.repositories;

import com.crud.democrud.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Interfaz del repositorio de Entidad del Usuario
 *
 * @author Edgar Morillo <edgar.morillo@sofka.com.co>
 * @version 1.0.0 2022-06-08
 * @since 1.0.0
 */
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {
    /**
     * Método para buscar por prioridad
     *
     * @param prioridad Integer
     * @return ArrayList
     */
    ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);

}
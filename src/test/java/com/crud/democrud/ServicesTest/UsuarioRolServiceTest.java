package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.models.UsuarioRolModel;
import com.crud.democrud.repositories.UsuarioRolRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test Data JPA Rol
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-06-08
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsuarioRolServiceTest {
    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Test
    void testSaveUserRol() {
        UsuarioModel usuarioModel = new UsuarioModel("Laura", "laura@mail.com", 90);
        UsuarioRolModel usuarioRolModel = new UsuarioRolModel(1L,"analista de datos", usuarioModel);
        UsuarioRolModel usuarioRolModelRegistrado = usuarioRolRepository.save(usuarioRolModel);
        assertNotNull(usuarioRolModelRegistrado);
    }

    @Test
    void testFindById() {
        Long idBuscado = 1L;
        Optional<UsuarioRolModel> usuarioRolModelBuscado = usuarioRolRepository.findById(idBuscado);
        assertThat(usuarioRolModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    public void testFinByRol() {
        String rol = "Programador junior";
        Optional<UsuarioRolModel> usuarioRolFound = usuarioRolRepository.findByRol(rol);
        assertThat(usuarioRolFound.get().getRol()).isEqualTo(rol);
    }

    @Test
    void testGetAllRoles() {
        List<UsuarioRolModel> usuarioRolModelList = (List<UsuarioRolModel>) usuarioRolRepository.findAll();
        assertThat(usuarioRolModelList).size().isGreaterThan(0);
    }
}

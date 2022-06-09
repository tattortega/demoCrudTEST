package com.crud.democrud.ServicesTest;

import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Data JPA Usuario
 *
 * @author Edgar Morillo <edgar.morillo@sofka.com.co>
 * @version 1.0.0 2022-06-08
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UsuarioServiceTest {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Test
    void testSaveUser() {
        UsuarioModel usuarioModel = new UsuarioModel("mateo", "mateo@gmail.com", 70);
        UsuarioModel usuarioModelRegistrado = usuarioRepository.save(usuarioModel);
        assertNotNull(usuarioModelRegistrado);
    }

    @Test
    void testFindUserById() {
        Long idBuscado = 1L;
        Optional<UsuarioModel> usuarioModelBuscado = usuarioRepository.findById(idBuscado);
        assertThat(usuarioModelBuscado.get().getId()).isEqualTo(idBuscado);
    }

    @Test
    void testGetAllUsers() {
        List<UsuarioModel> usuarioModelList = (List<UsuarioModel>) usuarioRepository.findAll();
        assertThat(usuarioModelList).size().isGreaterThan(0);
    }
}

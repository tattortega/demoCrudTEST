package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Entidad del Usuario - ORM
 *
 * @author Edgar Morillo <edgar.morillo@sofka.com.co>
 * @version 1.0.0 2022-06-08
 * @since 1.0.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String nombre;
    private String email;
    private Integer prioridad;

    @OneToMany(
            mappedBy = "usuarioModel",
            targetEntity = UsuarioRolModel.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE
    )
    @JsonManagedReference
    private List<UsuarioRolModel> usuarioRoles;


    /**
     * Constructor con parámetros
     *
     * @param nombre    String
     * @param email     String
     * @param prioridad Integer
     */
    public UsuarioModel(String nombre, String email, Integer prioridad) {
        this.nombre = nombre;
        this.email = email;
        this.prioridad = prioridad;
    }


}
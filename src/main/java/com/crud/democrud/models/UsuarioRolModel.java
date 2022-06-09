package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

/**
 * Entidad del Rol de Usuario - ORM
 *
 * @author Ricardo Ortega <tattortega.28@gmail.com>
 * @version 1.0.0 2022-06-08
 * @since 1.0.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario_rol")
public class UsuarioRolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String rol;

    @ManyToOne(
            targetEntity = UsuarioModel.class,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(name = "id_usu")
    @JsonBackReference
    private UsuarioModel usuarioModel;


    /**
     * Constructor con parámetros
     *
     * @param rol          String
     * @param usuarioModel UsuarioModel
     */
    public UsuarioRolModel(Long id, String rol, UsuarioModel usuarioModel) {
        this.id = id;
        this.rol = rol;
        this.usuarioModel = usuarioModel;
    }

}

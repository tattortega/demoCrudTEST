package com.crud.democrud.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
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

    //Constructors
    public UsuarioRolModel() {
    }

    public UsuarioRolModel(String rol, UsuarioModel usuarioModel) {
        this.rol = rol;
        this.usuarioModel = usuarioModel;
    }

    //Getters and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }
}

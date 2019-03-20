package com.delmarjunior.crudcliente.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 5161647831638104382L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    private String usuario;

    private String senha;

    private String role;

    private String nome;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(String usuario, String senha, String role, String nome) {
        this.usuario = usuario;
        this.senha = senha;
        this.role = role;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

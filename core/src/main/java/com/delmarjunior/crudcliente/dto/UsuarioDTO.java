package com.delmarjunior.crudcliente.dto;

public class UsuarioDTO {

    private Long id;

    private String usuario;

    private String senha;

    private String role;

    private String nome;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String usuario, String senha, String role, String nome) {
        this.id = id;
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

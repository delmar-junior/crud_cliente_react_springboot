package com.delmarjunior.crudcliente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = -6991488527095913222L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    private String nome;

    private String cpf;

    private String cep;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String numero;

    private String cidade;

    private String uf;

    @OneToMany(mappedBy = "cliente", targetEntity = Telefone.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> listaTelefone;

    @OneToMany(mappedBy = "cliente", targetEntity = Email.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Email> listaEmail;

//    private LocalDateTime created_at;
//
//    private LocalDateTime update_at;

    public Cliente() {
    }

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(String nome, String cpf, String cep, String logradouro, String complemento, String bairro, String numero, String cidade, String uf, List<Telefone> listaTelefone, List<Email> listaEmail) {
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.listaTelefone = listaTelefone;
        this.listaEmail = listaEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public List<Email> getListaEmail() {
        return listaEmail;
    }

    public void setListaEmail(List<Email> listaEmail) {
        this.listaEmail = listaEmail;
    }

//    public LocalDateTime getCreated_at() {
//        return created_at;
//    }
//
//    public void setCreated_at(LocalDateTime created_at) {
//        this.created_at = created_at;
//    }
//
//    public LocalDateTime getUpdate_at() {
//        return update_at;
//    }
//
//    public void setUpdate_at(LocalDateTime update_at) {
//        this.update_at = update_at;
//    }

//    @PrePersist
//    protected void onCreate() {
//        this.created_at = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.update_at = LocalDateTime.now();
//    }
}

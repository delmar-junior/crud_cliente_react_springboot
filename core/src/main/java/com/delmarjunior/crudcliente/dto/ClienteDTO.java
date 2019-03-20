package com.delmarjunior.crudcliente.dto;

import com.delmarjunior.crudcliente.model.Cliente;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDTO {

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

    private List<TelefoneDTO> listaTelefone;

    private List<EmailDTO> listaEmail;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.cep = cliente.getCep();
        this.logradouro = cliente.getLogradouro();
        this.complemento = cliente.getComplemento();
        this.bairro = cliente.getBairro();
        this.numero = cliente.getNumero();
        this.cidade = cliente.getCidade();
        this.uf = cliente.getUf();
        this.listaTelefone = cliente.getListaTelefone().stream().map(telefone -> new TelefoneDTO(telefone))
                .collect(Collectors.toList());
        this.listaEmail = cliente.getListaEmail().stream().map(email -> new EmailDTO(email))
                .collect(Collectors.toList());
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

    public List<TelefoneDTO> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<TelefoneDTO> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    public List<EmailDTO> getListaEmail() {
        return listaEmail;
    }

    public void setListaEmail(List<EmailDTO> listaEmail) {
        this.listaEmail = listaEmail;
    }
}

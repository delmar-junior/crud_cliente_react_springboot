package com.delmarjunior.crudcliente.dto;

import com.delmarjunior.crudcliente.model.Telefone;

public class TelefoneDTO {

    private Long id;

    private String numero;

    private String tipo;

    public TelefoneDTO() {
    }

    public TelefoneDTO(Telefone telefone) {
        this.id = telefone.getId();
        this.numero = telefone.getNumero();
        this.tipo = telefone.getTipo();
    }

    public TelefoneDTO(Long id, String numero, String tipo) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

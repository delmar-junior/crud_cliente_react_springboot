package com.delmarjunior.crudcliente.model;

import com.delmarjunior.crudcliente.dto.TelefoneDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Telefone implements Serializable {

    private static final long serialVersionUID = 311122208649733403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telefone")
    private Long id;

    private String numero;

    private String tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(String numero, String tipo, Cliente cliente) {
        this.numero = numero;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public Telefone(TelefoneDTO telefoneDTO, Cliente cliente) {
        this.id = telefoneDTO.getId();
        this.numero = telefoneDTO.getNumero();
        this.tipo = telefoneDTO.getTipo();
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

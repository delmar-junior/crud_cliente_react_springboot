package com.delmarjunior.crudcliente.model;

import com.delmarjunior.crudcliente.dto.EmailDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Email implements Serializable {

    private static final long serialVersionUID = -2503935501412734675L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_email")
    private Long id;

    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Email() {
    }

    public Email(String email, Cliente cliente) {
        this.email = email;
        this.cliente = cliente;
    }

    public Email(EmailDTO emailDTO, Cliente cliente) {
        this.id = emailDTO.getId();
        this.email = emailDTO.getEmail();
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

package com.delmarjunior.crudcliente.dto;

import com.delmarjunior.crudcliente.model.Email;

public class EmailDTO {

    private Long id;

    private String email;

    public EmailDTO() {
    }

    public EmailDTO(Email email) {
        this.id = email.getId();
        this.email = email.getEmail();
    }

    public EmailDTO(Long id, String email) {
        this.id = id;
        this.email = email;
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
}

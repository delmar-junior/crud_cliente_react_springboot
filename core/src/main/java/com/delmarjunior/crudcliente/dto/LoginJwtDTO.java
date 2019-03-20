package com.delmarjunior.crudcliente.dto;

public class LoginJwtDTO {

    private String token;

    public LoginJwtDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

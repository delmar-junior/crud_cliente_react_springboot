package com.delmarjunior.crudcliente.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.delmarjunior.crudcliente.model.Cliente;
import com.delmarjunior.crudcliente.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrincipal implements UserDetails {

    private static final long serialVersionUID = 7602220149224451347L;
    private static String ROLE_PREFIX = "ROLE_";

    private Long id;
    private String username;
    private String nome;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String nome, String username, String password,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(Usuario usuario) {

        List<GrantedAuthority> authorities = Stream.of(new SimpleGrantedAuthority(ROLE_PREFIX + usuario.getRole()))
                .collect(Collectors.toList());

        return new UserPrincipal(usuario.getId(), usuario.getNome(), usuario.getUsuario(), usuario.getSenha(), authorities);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserPrincipal other = (UserPrincipal) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

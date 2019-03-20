package com.delmarjunior.crudcliente.services;

import com.delmarjunior.crudcliente.model.Cliente;
import com.delmarjunior.crudcliente.model.Usuario;
import com.delmarjunior.crudcliente.repository.ClienteRepository;
import com.delmarjunior.crudcliente.repository.UsuarioRepository;
import com.delmarjunior.crudcliente.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado com o USUÁRIO: " + username));

        UserPrincipal principal = UserPrincipal.create(usuario);
        return principal;
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado com o ID: " + id));

        UserPrincipal principal = UserPrincipal.create(usuario);
        return principal;
    }

}

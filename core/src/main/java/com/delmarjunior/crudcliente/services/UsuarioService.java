package com.delmarjunior.crudcliente.services;

import com.delmarjunior.crudcliente.dto.UsuarioDTO;
import com.delmarjunior.crudcliente.model.Usuario;
import com.delmarjunior.crudcliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository repository;

    public void postUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();

        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuario.setRole("COMUM");
        usuario.setNome(usuarioDTO.getNome());

        repository.save(usuario);
    }

}

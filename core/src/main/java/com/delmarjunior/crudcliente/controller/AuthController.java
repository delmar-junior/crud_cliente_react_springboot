package com.delmarjunior.crudcliente.controller;

import javax.validation.Valid;

import com.delmarjunior.crudcliente.dto.LoginDTO;
import com.delmarjunior.crudcliente.dto.LoginJwtDTO;
import com.delmarjunior.crudcliente.dto.UsuarioDTO;
import com.delmarjunior.crudcliente.security.JwtTokenProvider;
import com.delmarjunior.crudcliente.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<?> postLogin(@Valid @RequestBody LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
                loginDTO.getUsuario(),
                loginDTO.getSenha()
        );

        Authentication authentication = authenticationManager.authenticate(user);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new LoginJwtDTO(jwt));
    }

    @PostMapping("/registro")
    public ResponseEntity<?> postUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        service.postUsuario(usuarioDTO);
        return ResponseEntity.ok().build();
    }

}

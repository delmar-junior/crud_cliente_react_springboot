package com.delmarjunior.crudcliente.controller;

import com.delmarjunior.crudcliente.dto.ClienteDTO;
import com.delmarjunior.crudcliente.security.annotation.AdminSecured;
import com.delmarjunior.crudcliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    @AdminSecured
    public ResponseEntity<List<ClienteDTO>> getClientes() {

        List<ClienteDTO> clientes = service.listarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteId(@PathVariable String id) {
        ClienteDTO clienteDTO = service.getClienteId(Long.parseLong(id));
        return clienteDTO != null ? ResponseEntity.ok(clienteDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    @AdminSecured
    public ResponseEntity<?> postCliente(@RequestBody ClienteDTO clienteDTO) {
        service.postCliente(clienteDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @AdminSecured
    public ResponseEntity<?> putClienteId(@PathVariable String id, @RequestBody ClienteDTO clienteDTO) {
        service.putCliente(Long.parseLong(id), clienteDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @AdminSecured
    public ResponseEntity<?> deleteClienteId(@PathVariable String id) {
        ClienteDTO clienteDTO = service.getClienteId(Long.parseLong(id));
        if (clienteDTO != null) {
            service.deleteCliente(Long.parseLong(id));
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

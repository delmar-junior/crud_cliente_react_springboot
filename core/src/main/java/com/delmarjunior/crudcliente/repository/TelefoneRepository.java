package com.delmarjunior.crudcliente.repository;

import com.delmarjunior.crudcliente.model.Cliente;
import com.delmarjunior.crudcliente.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    List<Telefone> findByCliente(Cliente cliente);
}

package com.delmarjunior.crudcliente.repository;

import com.delmarjunior.crudcliente.model.Cliente;
import com.delmarjunior.crudcliente.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    List<Email> findByCliente(Cliente cliente);
}

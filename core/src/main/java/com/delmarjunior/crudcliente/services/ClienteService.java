package com.delmarjunior.crudcliente.services;

import com.delmarjunior.crudcliente.dto.ClienteDTO;
import com.delmarjunior.crudcliente.model.Cliente;
import com.delmarjunior.crudcliente.model.Email;
import com.delmarjunior.crudcliente.model.Telefone;
import com.delmarjunior.crudcliente.repository.ClienteRepository;
import com.delmarjunior.crudcliente.repository.EmailRepository;
import com.delmarjunior.crudcliente.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EmailRepository emailRepository;

    public List<ClienteDTO> listarClientes() {

        List<Cliente> result = repository.findAll();
        return result.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
    }

    public ClienteDTO getClienteId(Long id) {

        Optional<Cliente> cliente = repository.findById(id);
        return cliente.isPresent() ? new ClienteDTO(cliente.get()) : null;
    }

    public void postCliente(ClienteDTO clienteDTO) {

        Cliente cliente = new Cliente();

        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setCep(clienteDTO.getCep());
        cliente.setLogradouro(clienteDTO.getLogradouro());
        cliente.setComplemento(clienteDTO.getComplemento());
        cliente.setBairro(clienteDTO.getBairro());
        cliente.setNumero(clienteDTO.getNumero());
        cliente.setCidade(clienteDTO.getCidade());
        cliente.setUf(clienteDTO.getUf());

        List<Telefone> listaTelefone = clienteDTO.getListaTelefone().stream().map(telefoneDTO -> new Telefone(telefoneDTO, cliente))
                .collect(Collectors.toList());
        cliente.setListaTelefone(listaTelefone);

        List<Email> listaEmail = clienteDTO.getListaEmail().stream().map(emailDTO -> new Email(emailDTO, cliente))
                .collect(Collectors.toList());
        cliente.setListaEmail(listaEmail);

        repository.save(cliente);
    }

    public void putCliente(Long id, ClienteDTO clienteDTO) {

        Cliente cliente = new Cliente();
        cliente.setId(id);

        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setCep(clienteDTO.getCep());
        cliente.setLogradouro(clienteDTO.getLogradouro());
        cliente.setComplemento(clienteDTO.getComplemento());
        cliente.setBairro(clienteDTO.getBairro());
        cliente.setNumero(clienteDTO.getNumero());
        cliente.setCidade(clienteDTO.getCidade());
        cliente.setUf(clienteDTO.getUf());

        List<Telefone> listaTelefone = clienteDTO.getListaTelefone().stream().map(telefoneDTO -> new Telefone(telefoneDTO, cliente))
                .collect(Collectors.toList());
        cliente.setListaTelefone(listaTelefone);

        List<Email> listaEmail = clienteDTO.getListaEmail().stream().map(emailDTO -> new Email(emailDTO, cliente))
                .collect(Collectors.toList());
        cliente.setListaEmail(listaEmail);

        repository.save(cliente);
    }

    public void deleteCliente(Long id) {

        Cliente cliente = new Cliente(id);

        List<Telefone> listaTelefone = telefoneRepository.findByCliente(cliente);
        telefoneRepository.deleteAll(listaTelefone);

        List<Email> listaEmail = emailRepository.findByCliente(cliente);
        emailRepository.deleteAll(listaEmail);

        repository.delete(cliente);
    }
}

package com.zuporangetalents.service.implement;

import com.zuporangetalents.controller.exceptions.type.DataIntegrationException;
import com.zuporangetalents.dto.ClienteDTO;
import com.zuporangetalents.model.Cliente;
import com.zuporangetalents.repository.ClienteRepository;
import com.zuporangetalents.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    // Essa assinatura será responsavel por buscar UM cliente através do Id
    public Cliente find(int id) {
        var cliente = clienteRepository.findById(id);

        // Caso error
        if(!cliente.isPresent()) {
            throw new DataIntegrationException("O cliente [" + id + "] nao consta no banco.");
        }

        // Caso sucesso
        return  cliente.get();
    }

    @Override
    // Retorna todos os clientes dentro de uma lista
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    // Inserseção de novo cliente
    public Cliente insert(ClienteDTO clienteDto){
        var cliente = clienteRepository.findOptionalByEmail(clienteDto.getEmail());

        if(cliente.isPresent()) {
            throw new DataIntegrationException("E-mail já cadastrado.");
        }

        return clienteRepository.save(Cliente.builder()
                .nome(clienteDto.getNome())
                .email(clienteDto.getEmail())
                .cpf(clienteDto.getCpf())
                .dataNascimento(clienteDto.getDataNascimento())
                .build());
    }

    @Override
    // Atualiza os dados do cliente por meio do Id
    public Cliente update(int idCliente, ClienteDTO clienteDTO) {
        var cliente = this.find(idCliente);

        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());

        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(int idCliente) {
        var cliente = this.find(idCliente);
        clienteRepository.delete(cliente);
    }
}

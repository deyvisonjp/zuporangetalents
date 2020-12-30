package com.zuporangetalents.service;

import com.zuporangetalents.dto.ClienteDTO;
import com.zuporangetalents.model.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente find(int id);
    List<Cliente> findAll();
    Cliente insert(ClienteDTO clienteDTO);
    Cliente update(int idCliente, ClienteDTO clienteDTO);
    void delete(int idCliente);
}

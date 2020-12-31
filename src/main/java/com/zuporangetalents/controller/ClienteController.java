package com.zuporangetalents.controller;

import com.zuporangetalents.dto.ClienteDTO;
import com.zuporangetalents.model.Cliente;
import com.zuporangetalents.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zuptalents")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    // Vamos mapear as rotas para os métodos criados em ClienteService
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClienteDTO> get(@PathVariable int id){
        var clienteObj = clienteService.find(id).clienteDTO();
        return ResponseEntity.ok(clienteObj);
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> getAll(){
        var clienteObj = clienteService.findAll().stream().map(Cliente::clienteDTO).collect(Collectors.toList());
        return ResponseEntity.ok(clienteObj);
    }

    @RequestMapping(value = "/criarCliente", method = RequestMethod.POST)
    public ResponseEntity<?> post(@Valid @RequestBody ClienteDTO clienteObjDTO) {
        clienteService.insert(clienteObjDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/atualizarCliente/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@Valid @RequestBody ClienteDTO clienteObjDTO, @PathVariable Integer id){
        var obj =clienteService.update(id, clienteObjDTO);
        return ResponseEntity.ok(obj.clienteDTO());
    }

    @RequestMapping(value = "/deletatar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        clienteService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

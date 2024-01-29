package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @GetMapping
    public Iterable<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("{codCliente}")
    public Cliente getCliente(@PathVariable Long codCliente){
        return clienteRepository.findByCod(codCliente);
    }

    @PostMapping
    public Cliente postCliente(@Validated @RequestBody Cliente cliente){

        return clienteRepository.save(cliente);

    }

    @PutMapping("/{codCliente}")
    public ResponseEntity<Cliente> putCliente (@PathVariable Long codCliente, @RequestBody Cliente cliente	){
        Cliente clienteSalvo = clienteRepository.findById(codCliente).get();

        BeanUtils.copyProperties(cliente, clienteSalvo,"cod");

        clienteRepository.save(cliente);

        return ResponseEntity.ok(clienteSalvo);
    }
}
package com.example.demo.controller;

import com.example.demo.model.Servico;
import com.example.demo.repository.ServicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    ServicoRepository servicoRepository;

    @GetMapping
    public Iterable<Servico> getServicos(){
        return servicoRepository.findAll();
    }

    @GetMapping("{codServico}")
    public Servico getServico(@PathVariable Long codServico){
        return servicoRepository.findByCod(codServico);
    }

    @PostMapping
    public Servico postServico(@Validated @RequestBody Servico servico){

        return servicoRepository.save(servico);

    }

    @PutMapping("/{codServico}")
    public ResponseEntity<Servico> putServico (@PathVariable Long codServico, @RequestBody Servico servico	){
        Servico servicoSalvo = servicoRepository.findById(codServico).get();

        BeanUtils.copyProperties(servico, servicoSalvo,"cod");

        servicoRepository.save(servico);

        return ResponseEntity.ok(servicoSalvo);
    }
}
package com.example.demo.repository;

import com.example.demo.model.Servico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServicoRepository extends CrudRepository<Servico, Long> {

    List<Servico> findByNome(String nome);
    Servico findByCod(Long cod);
}

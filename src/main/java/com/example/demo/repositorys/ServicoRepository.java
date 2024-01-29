package com.example.demo.repositorys;

import com.example.demo.models.Servico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServicoRepository extends CrudRepository<Servico, Long> {

    List<Servico> findByNome(String nome);
    Servico findByCod(Long cod);
}

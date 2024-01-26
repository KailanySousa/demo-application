package com.example.demo.repositorys;

import com.example.demo.models.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    Cliente findByCod(Long cod);
}

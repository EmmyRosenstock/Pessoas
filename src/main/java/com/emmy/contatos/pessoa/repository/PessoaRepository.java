package com.emmy.contatos.pessoa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.emmy.contatos.pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNome(String nome);

}
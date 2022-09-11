package com.github.jcarloscody.restbasicospring.demo.repositorio;

import com.github.jcarloscody.restbasicospring.demo.dominio.ClienteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<ClienteEntidade, Long> {
    List<ClienteEntidade> findByNomeLike(String nome);
}

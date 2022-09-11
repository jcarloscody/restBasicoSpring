package com.github.jcarloscody.restbasicospring.demo.controller;

import com.github.jcarloscody.restbasicospring.demo.dominio.ClienteEntidade;
import com.github.jcarloscody.restbasicospring.demo.servico.ClienteServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteServico clienteServico;

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteEntidade> findById(@PathVariable Long id) {
        ClienteEntidade obj = this.clienteServico.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<ClienteEntidade>> findAll() {
        List<ClienteEntidade> listClientes = clienteServico.findAll();
        return ResponseEntity.ok().body(listClientes);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<ClienteEntidade> create(@Valid @RequestBody ClienteEntidade obj) {
        ClienteEntidade post = clienteServico.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @CrossOrigin
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteEntidade> upDate(@PathVariable Long id, @Valid @RequestBody ClienteEntidade obj) {
        ClienteEntidade newObj = clienteServico.upDate(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteServico.delete(id);
        return ResponseEntity.noContent().build();
    }
}

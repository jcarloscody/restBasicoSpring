package com.github.jcarloscody.restbasicospring.demo.servico;

import com.github.jcarloscody.restbasicospring.demo.dominio.ClienteEntidade;
import com.github.jcarloscody.restbasicospring.demo.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServico {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public ClienteEntidade findById(Long id)  {
        Optional<ClienteEntidade> obj = this.clienteRepositorio.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("CODIGO DO CLIENTE INVÁLIDO!" + id));
    }

    public List<ClienteEntidade> findAll() {
        return clienteRepositorio.findAll();
    }

    public ClienteEntidade upDate(Long id, ClienteEntidade obj) {
        ClienteEntidade newObj = findById(id);
        upDateData(newObj, obj);
        return clienteRepositorio.save(newObj);
    }

    private void upDateData(ClienteEntidade newObj, ClienteEntidade obj) {
        newObj.setNome(obj.getNome());
        newObj.setCPF(obj.getCPF());
    }

    public ClienteEntidade create(ClienteEntidade obj) {
        return clienteRepositorio.save(obj);
    }

    public void delete(Long id) {
        ClienteEntidade obj = findById(id);
        clienteRepositorio.delete(obj);
    }
}

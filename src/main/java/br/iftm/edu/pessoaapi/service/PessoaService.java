package br.iftm.edu.pessoaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.iftm.edu.pessoaapi.controller.PessoaNaoEncontradaException;
import br.iftm.edu.pessoaapi.domain.Pessoa;
import br.iftm.edu.pessoaapi.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<Pessoa> todos() {
        return repository.findAll();
    }

    public Pessoa novo(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public Optional<Pessoa> busca(Integer id) {
        return repository.findById(id);
    }

    public Pessoa atualiza(Pessoa pessoa, Integer id) {
        if(repository.existsById(id)) {
            pessoa.setId(id);
            return repository.save(pessoa);
        }
        throw new PessoaNaoEncontradaException(id);
    }

    public void exclui(Integer id) {
        repository.deleteById(id);
    }
}

package br.iftm.edu.pessoaapi.controller;

public class PessoaNaoEncontradaException extends RuntimeException {

    PessoaNaoEncontradaException(Integer id) {
        super("Não encontrei pessoa " + id);
    }

}

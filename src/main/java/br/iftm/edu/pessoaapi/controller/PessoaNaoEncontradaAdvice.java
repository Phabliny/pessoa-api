package br.iftm.edu.pessoaapi.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PessoaNaoEncontradaAdvice {
    @ExceptionHandler
    ResponseEntity<String> employeeNotFoundHandler(PessoaNaoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    
    @ExceptionHandler
    public ResponseEntity<String> deleteIdNotFound(EmptyResultDataAccessException ex) {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encontrado!");
    }
}

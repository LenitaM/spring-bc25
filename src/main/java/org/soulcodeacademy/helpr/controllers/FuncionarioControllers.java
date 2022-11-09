package org.soulcodeacademy.helpr.controllers;

/*AULA DIA 08 DE NOV DE 2022*/

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //está classe é capaz de captar as requisições
public class FuncionarioControllers {

    @Autowired
    private FuncionarioService funcionarioService; //Controller depende do Service


    // /funcionarios (GET) - dois métodos gets para leituras de dados
    @GetMapping("/funcionarios")
    public List<Funcionario> listar() {

        return this.funcionarioService.listar();
    }

    // / Funcionarios/{id} (GET)
    @GetMapping("/funcionarios/{idFuncionario}")
       public Funcionario getFuncionario(@PathVariable Integer idFuncionario){
           return this.funcionarioService.getFuncionario(idFuncionario);
        }
    }

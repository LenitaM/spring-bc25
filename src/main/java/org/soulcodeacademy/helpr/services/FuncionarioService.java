package org.soulcodeacademy.helpr.services;

/*AULA DIA 09 DE NOV DE 2022*/

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listar() {
        return this.funcionarioRepository.findAll();
    }

    public Funcionario getFuncionario(Integer idFuncionario) {
        Optional<Funcionario> funcionario = this.funcionarioRepository.findById(idFuncionario); //vai fazer um filtro do FuncionarioRepository

        if(funcionario.isEmpty()) {
            throw new RuntimeException("O funcionário não goi encontrado.");
        }else {
            return funcionario.get(); //pega o valor da entidade encontrada
        }
    }


}

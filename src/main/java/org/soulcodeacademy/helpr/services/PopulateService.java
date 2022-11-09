package org.soulcodeacademy.helpr.services;

/*AULA DIA 01 DE NOV 2022
*
* Entidade de testes
* O objetivo dessa classe é inserir no banco de dados fictícios para testes.
*
* */

import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.Funcionario;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {// Torna o objeto de PopulateService disponível para toda a aplicação (global)
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository; //cargoRepository (atributo guar o objeto da interface) pode ser qualquer nome (rem esse nome pra saber que é da interface CargoRepository
    //Autowired vai ver se CargoRepository (interface)  está dentro da dependencia e adc no container

    /*AULA DIA 08 DE NOV DE 2022*/
    @Autowired //Precisa colocar pra entidade Funcionario tb
    private FuncionarioRepository funcionarioRepository;

    //Método
    public void populate() {
        // Integer idCargo, String nome, String descricao, Double salario
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        //Entidade + nome do objeto = new objeto
        Cargo c2 = new Cargo(null, "Diretor de Setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico geral", "Resolve os chamados urgentes", 12000.0);

        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.save(c1); // INSERT INTO (MySQL)
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);

        /*AULA DIA 08 DE NOV DE 2022*/
        Funcionario f1 = new Funcionario(null, "Renato Pereira", "renato.pereira@gmail.com", "68258098144", "12345", null, c1); //c1 = cargo que ele vai receber
        Funcionario f2 = new Funcionario(null, "Victor Icoma", "victor.icoma@gmail.com","688758098144", "67890", null, c2);

        this.funcionarioRepository.save(f1);
        this.funcionarioRepository.save(f2);
    }
}

// O objetivo desta classe é inserir no banco, dados fictícios (de teste)

/* IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias.
Quem gerencia a criação dos objetos é o Spring
 */

// Container = é o local onde o Spring guarda os objetos anotados

// @Service = indica que a classe é um serviço. O serviço tem múltiplos própositos como gerênciar regras de negócios, fazer utilidades do bd, manipular o repository

// Injeção de Dependências = quando o Spring injeta os objetos na classe

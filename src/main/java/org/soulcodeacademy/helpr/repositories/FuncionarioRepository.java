package org.soulcodeacademy.helpr.repositories;

/*08 DE NOV DE 2022
*
* Segundo Passo
* */

import org.soulcodeacademy.helpr.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Repository = é um recurso que permite manipular a entidade no banco de dados
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> { //Generics

}


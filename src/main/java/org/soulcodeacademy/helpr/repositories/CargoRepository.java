package org.soulcodeacademy.helpr.repositories;

/*AULA DIA 01 DE NOV DE 2022*/


import org.soulcodeacademy.helpr.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // indica que a interface é um repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> { // <Entidade, TIPO da PK = chave estrangeira>
}//antes de JpaRepository era CrudRepository. Outro tipo de repository com mais funcionalidades = JpaRepository
//CRUD é mais primitivo

// Repository = é um recurso que permite manipular a entidade no banco de dados
// Adicionar entidades, atualizar entidades, remover entidades e listar (CRUD)
// Indicar qual a entidade vai ser gerenciada pelo repository e qual o tipo (INTEGER, String etc) da PK.
// Obs: O Spring gera uma classe dinâmica com base em nossa interface CargoRepository
// CrudRepository = contém as operações básicas de um banco de dados
//JpaRepository = possui mais funcionalidade para tratar a entidade
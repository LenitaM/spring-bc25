package org.soulcodeacademy.helpr.repositories;

/*AULA DIA 07 DE NOV DE 2022
*
* 2ª Criando Repository
*
Repository vai ser uma interface onde vai ser guarda/manipular os dados do Banco de Dados
*
* JpaRepository tem mais funcionalidades que o CrudRepository
*/

import org.soulcodeacademy.helpr.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //indica que a Interface é Repository
//Class UsuarioRepositoryImpl implements UsuarioRepository (o sistema vai fazer esse comando)
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}

/*Métodos presentes
*
* findAll(Parametro vazio) => SELECT * FROM usuario;
* findById(Integer) => SELECT * FROM usuario WHERE id = ?
* save(Entidade, nesse caso Usuario) => INSERT INTO = caso o campo de id é nulo / UPDATE = caso o campo id não é nulo
* delete(Entidade, nesse caso Usuario) => DELETE FROM usuarios WHERE id = ?
* */

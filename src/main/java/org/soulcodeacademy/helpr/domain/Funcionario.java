package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*AULA DIA 08 DE NOV DE 2011
*
* Primeiro Passo
* Para quebrar linha alt + Page Down
* Criando a entidade Funcionario (N) e relacionando a outras entidades.
* */
//1º
@Entity //transforma em entidade
public class Funcionario extends Usuario { //estabelecer a herança
    //Gera uma coluna dtype para indicar qual a subclasse, coluna reservada destina de quem é a subclasse(Funcionario ou Cliente)

    //@Column na foto não é obrigatório
    private String foto;

    @ManyToOne //MUITOS (N) Funcionarios para UM (1) Cargo
    @JoinColumn(name = "idCargo") //Cria uma coluna nova que é a FK (Chave Estrangeira) de Cargo, SEMPRE colocar no lado N
    private Cargo cargo; //Se eu quiser mudar o cargo do Funcionario, basta mudar o objeto deste campo

    //2º Criar o construtor
    public Funcionario() {} //criar um vazio

    //Existi uma Herança por isso precisa por atributos da SuperClasse (Cargo) e depois da SubClasse (Funcionario)
    public Funcionario(Integer id, String nome, String email, String cpf, String senha, String foto, Cargo cargo){
      super(id,nome,email,cpf,senha, Perfil.FUNCIONARIO); //Chamada do Construtor de Usario
      this.foto = foto;
      this.cargo = cargo; //adc o atributos do Funcionario
    }

    //3º Getter e Setter
    //Posso alterar, atualizar do Funcionário
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}

/*Anotações de relacionamento
*
* @OneToOne = 1:1 Uma para Uma
* @OneToMany/@ManyToOne = 1:N Um para Muitas
* @ManyToMany = N:N Muitas para Muitas
*
*Programação Orientada a Objetos:
*
* - Relacionamento Unidirecional = apenas uma das entidades conhece a outra -
*
* CLASSE CARGO
* <nenhum>

* CLASSE FUNCIONARIO
* private Cargo cargo;
*
* Funcionário conhece o Cargo, nessa relação o Funcionario manda no Cargo, em que o F consegue mudar os objetos livrimente.
* É o F que conhece o Cargo, manda quem conhece.
*
* - Relacionamento Bidirecional = as duas entidades se conhecem. -
*
* Classe Empregado
* List<Dependente> Dependente;
*
* Classe Dependente
* private Empregado empregado;
*
* */


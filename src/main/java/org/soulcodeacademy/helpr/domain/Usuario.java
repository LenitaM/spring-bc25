package org.soulcodeacademy.helpr.domain;

import org.soulcodeacademy.helpr.domain.enums.Perfil;

import javax.persistence.*;
/*AULA DIA 07 DE NOV DE 2022*
*
* Domain é a package onde fica as entidades.
*
* Essa entidade Usuario só é feita para fazer a ligação entre Funcionarios e Clientes
*
* Criação da Entidade Usário. (Pode criar Repository e DTO, menos objetos)
*Herança:
* O objetivo de toda SuperClass(Pai) é agrupar o que a SubClass(Filhos) tem de semelhança entre cliente e funcionário
* */

//1º Construção da tabela
//@Anotações = aqui, são definições da coluna, criando a tabela
@Entity //essa Classe vai ser uma Entidade no Banco de Dados. Anotação Obrigatória
@Table(name = "usuarios") //usado para renomear tabelas, coloca um nome específico. Não é obrigatória
public abstract class Usuario { //abstratc não permite criar objetos nesta classe, não da para instanciar
    //a Usuario é uma superclasse com abstratc só vai ser possível instanciar(criar objetos) em funcionario e cliente
    @Id //Torna o campo abaixo em uma PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // preenche o campo id com AUTO_INCREMENT
    protected Integer id; //Protected = da pra usar nas subclasses, pq haverá herenças.

    //Essas anotações não são obrigatórias, mas é bom por para personalizar melhor a tabela
    @Column(nullable = false, length = 150) // NOTNULL (obrigatório) length = quantidade de caracteres
    protected String nome; //usa o protected quando for fazer Herança.

    @Column(nullable = false, unique = true, length = 120) //unique = única (cada usuário vai ter seu email, não pode repetir)
    protected String email;

    @Column(nullable = false, unique = true, length = 11)
    protected String cpf;

    @Column(nullable = false)
    protected String senha;

    //2º criando um enums
    @Enumerated(EnumType.STRING) //Representa os valores do ENUM (Perfil) como texto
    protected Perfil perfil; //importando o enum criado enum Perfil
    //Indica o que este usuário é no sistema

    //3º Criação do Constructor
    //Array ORM
    public Usuario() {} //Constructor vazio

    public Usuario(Integer id, String nome, String email, String cpf, String senha, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.perfil = perfil; //ele é um tipo da tabela
    }

    //4º Criando Get e Set (para poder alterar os valores dos objetos que serão criados)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    // 5º Abstract: Transformar a entidade em classe abstrada serve para não deixar criar objetos
    /*Usuario usuario = new Usario() = não é possível fazer isso*/
}

/*ORDEM DO BACKEND
 * 0 - CRUD dos Funcionarios e Clientes -
 * 1 - Cria a Entidade
 * 2 - Repository
 * 3 - DTO
A entidade SuperClass (Usuario)
 * 4 - Service
 * 5 - Controller
 * */


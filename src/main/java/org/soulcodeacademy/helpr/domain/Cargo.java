package org.soulcodeacademy.helpr.domain;

/*AULA DIA 31 DE OUT DE 2022: Criando cargos, inicio do projeto helpr
*
* Domain é a package onde fica as entidades.
 *
* Toda entidade é uma classe:
* Precisa ter um construtor vazio
* Pode ter outros construtores para criar manualmente os objetos
* Precisa ter getters e setters
* @Enity = transforma a classe em uma entidade
*
* */

import javax.persistence.*; // JPA = JAVA PERSISTENCE API

//CREATE - READ
@Entity // Transformar a classe numa entidade/tabela no banco
public class Cargo { // nome da tabela = cargo
    @Id // PRIMARY KEY - sempre vai ter ela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT - se quiser seja auto incremento
    private Integer idCargo; // será a chave primária da tabela
    //tem que usar as classes das variáveis
    @Column(nullable = false, length = 50) // NOT NULL, e máximo de 50 caracteres (nullable = padrão é true, logo pode ser nulo)
    private String nome;
    //nullable "essa opção pode ser vazia?" = false "não pode ser nulo"
    @Column(nullable = false, length = 120) // NOT NULL, e 120 caracteres
    private String descricao;
    @Column(nullable = false) // @Column serve para customizar a coluna, transformar em coluna, por padrão vai ser feitas colunas automaticamente
    private Double salario;
    /*Foi criada a entidade de como ela deve ser*/

    // a ORM irá usar este construtor em conjunto dos getters/setters. O padrão da ORM é transformar através do mapeamento tudo em tabela.
    public Cargo() {}

    //Criar outro construtor para poder criar objetos, usado mais de forma interna, para facilitar a criação dos objetos
    //criar manualmente os cargos, usado pelos dev
    public Cargo(Integer idCargo, String nome, String descricao, Double salario) {
        this.idCargo = idCargo;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Integer getIdCargo() {

        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {

        this.idCargo = idCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {

        this.descricao = descricao;
    }

    public Double getSalario() {

        return salario;
    }

    public void setSalario(Double salario) {

        this.salario = salario;
    }
}

/*
* Classes a partir de tipos primitivos
Integer - int
Double - double
Floating - float
Boolean - boolean
Character - char
String - String
Null - null (vazio)
*
* */

/*ORDEM DO BACKEND
 * 1 - Cria a Entidade
 * 2 - Repository
 * 3- DTO
 * 4 - Service
 * 5 - Controller
 * */
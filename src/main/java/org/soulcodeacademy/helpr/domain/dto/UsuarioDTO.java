package org.soulcodeacademy.helpr.domain.dto;

/*AULA DIA 01 DE NOV DE 2022
*
* CRUD: 3º Criando o DTO do Usuario, não pode ser instanciada pq é abstrada (Superclasse)
* */

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//Guarda as validações em comum para cliente e funcionário
//No controller: JSON -> DTO (converte)
public abstract class UsuarioDTO {

    @NotBlank(message = "O campo Nome é obrigatório")
    protected String nome;
    //Anotação própria para String que não permita que o campo seja Null (vazio)
    @Email(message = "Email inválido") //só permite se tiver o formato de email: exemplo@exemplo.com
    @NotBlank(message = "O campo Email é obrigatório")
    protected String email;

    @NotBlank(message = "O campo CPF é obrigatório")
    protected String cpg;

    @NotBlank(message = "O campo Senha é obrigatório")
    protected  String senha;

    //Get e Set
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

    public String getCpg() {
        return cpg;
    }

    public void setCpg(String cpg) {
        this.cpg = cpg;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

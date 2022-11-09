package org.soulcodeacademy.helpr.domain.dto;

import javax.validation.constraints.NotNull;

/*AULA DIA 08 DE NOV DE 2022
*
* Terceiro Passo
* */

public class FuncionarioDTO extends UsuarioDTO {
    private String foto;

    @NotNull(message = "idCargo é obrigatório")
    private Integer idCargo;

    //Getter e Setter
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
}

/*
Exercício:

Tentem implementar:

/funcionarios (GET) = Lista todos os funcionários.
/funcionarios/{idFuncionario} (GET) = Lista um funcionário.

Obs: Montar o service e o controller, conforme feito no CRUD de Cargos.
*/

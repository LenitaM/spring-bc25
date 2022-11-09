package org.soulcodeacademy.helpr.controllers;

/*AULA DIA 31 DE OUT DE 2022
*
* controllers é o package responsável pela comunicação em formato http com frontend, indica os dados existentes no banco de dados
*abrir sempre localhost:8080
*
* postman conversa com os usúarios, irar fazer testes das aplicações
* */

import org.soulcodeacademy.helpr.domain.Cargo; //essa classe está no domain que está no org, e nesse arquivo está reconhecendo
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController//retorno dos dados
public class CargoControllers {

    //Endpoiny é o endereço que será acessado no backend
    @GetMapping("/oi") //com base em localhost: 8080/oi retorna a String
    public String dizOla() {
        return "Eu posso retornar qualquer dado"; //resposta da requisição, sempre vai ser o return
    }

    @GetMapping("/batata") //quando ele não achar a gerência do endereço dará "Whitelabel Error Page"
    public  Integer valor() {
        return 1000; //resposta da requisição
    }

    @Autowired //vai pegar no container e vai por a instância criada no cargoService, com todas as dependências resolvidas
    private CargoService cargoService;

    /*AULA DIA 03 DE NOV DE 2022*/

    @GetMapping("/cargos")
    public List<Cargo> listar(){ //tem que importar list, cargo
        //Cadeia de comando:
        //Requisão do cliente -> Controllers (decide o que vai fazer) -> Service (controla a regra de negócio) -> Repository -> SELECT *FROM cargo;
        return this.cargoService.listar(); //JSON = javascript object notation
    }

    @GetMapping ("/cargos/{idCargo}") // /cargos/parametro - indica que o valor após a barra é dinâmico
    //o valor 1000 será jogado dentro desse segundo parametro, uma fomr ade acessar dinamicamente os dados
    public Cargo getCargo(@PathVariable Integer idCargo) {
        //@PathVariable -> extrai do endpoint o valor dinâmico
        System.out.println(idCargo);
        return this.cargoService.getCargo(idCargo); //extrair id do parametro idCargo
    }

    //podemos usar o mesmo endpoint para verbos diferentes (até recomendado)
    //Refatoração do salvar
    @PostMapping("/cargos") //REQUISIÇÃO TIPO POST para /cargos (endpoint)
    //Objeto do JSON convertido em objeto do JAVA:
    public Cargo salvar (@Valid @RequestBody CargoDTO cargo){ //(@RequestBody Cargo cargo)  //@Valid = vai validar o cargo com as regras colocadas
        // Permitir o envio de dados pelo POSTMAN, e vai ficar armazenado no cargo
        //@RequestBody = extrai o JSON do corpo e converte para o cargo (deserialização)
        Cargo salvo = this.cargoService.salvar(cargo);
       return salvo; //A resposta será o cargo inserido
    } //com o cargo salvo, ele vai está armazenado no banco de dados e pode ser visualizado no POSTMAN

    /*AULA DIA 04 DE NOV DE 2022*/
// Mapeia requisições do verbo PUT
    @PutMapping("/cargos/{idCargo}") // /cargos/5
    public Cargo atualizar(@PathVariable Integer idCargo,
      /*07 DE NOV*/ @Valid @RequestBody CargoDTO cargo) {
        Cargo atualizado = this.cargoService.atualizar(idCargo, cargo);
        return atualizado; // Resposta para o cliente (cargo atualizado)
    }

    @DeleteMapping("/cargos/{idCargo}") // Verbo DELETE no /cargos/1
    public void deletar(@PathVariable Integer idCargo) {
        this.cargoService.deletar(idCargo);
    }
}
package org.soulcodeacademy.helpr.services;

/*AULA DIA 01 DE NOV DE 2022
*
*
* Pasta para criar entidades de testes
*
*  Está atrelado a regra de negócios pq existe requisitos para usar o Repository.
* Possibilitando o restante da comunicação com o restante das camadas CargoRepository, Cargo até chegar no BD.
* Define como um filtro de quais dados podem ser acessados, ter, criar
* */

//precisa importar:
import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.domain.dto.CargoDTO;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired //insere os dados no cargoRepository
    private CargoRepository cargoRepository;
//Ler(READ)
    // Listar todos
    public List<Cargo> listar() { //1º criar um método. List<classe> = comando de superclasse de Array listar() = armazenamento
        // Retorna os dados da tabela em forma de lista
        return this.cargoRepository.findAll();// SELECT * FROM cargo;
    }

    // Listar um pelo ID
    public Cargo getCargo(Integer idCargo) { //analise se tem o id ou não
        // Optional = Pode haver cargo ou não (tipo)
        //cargo = nome da variável que vai está armazenado os dados
        Optional<Cargo> cargo = this.cargoRepository.findById(idCargo);// SELECT * FROM cargo WHERE idCargo = ?

        if(cargo.isEmpty()) { // Não encontrou o cargo?
            // Não encontrou o cargo com id solicitado
            throw new RuntimeException("O cargo não foi encontrado!"); // Causa um erro com a mensagem
        } else {
            return cargo.get(); // Extrair o cargo de dentro do optional
        }
    }
    /*AULA DIA 07 DE NOV DE 2022*/
    //Refatoração do DTO
    //Salvar
    //CargoDTO (tipo) dto = nome do paramêtro
    public Cargo salvar(CargoDTO dto){
        //INSERT INTO cargo, atualizando o cargo com DTO
        Cargo cargo = new Cargo (null, dto.getNome(), dto.getDescricao(), dto.getSalario());
        //dto.setIdCargo(null); //limpar o campo id para não substituir cargos, quando add cargo novo o id tem que nulo
        //INSERT INTO cargo (equivale)
        Cargo cargoSalvo = this.cargoRepository.save(cargo);
        return cargoSalvo;
    }

    /*04 DE NO DE 2022*/

    // Atualizar (UPDATE): Precisa usar o POSTMAN
    // Precisa do ID do cargo e dos dados atualizados
    public Cargo atualizar(Integer idCargo, CargoDTO dto) {
        // Verificar se o cargo existe mesmo
        Cargo cargoAtual = this.getCargo(idCargo);

        cargoAtual.setNome(dto.getNome()); /*07 NOV*/
        cargoAtual.setDescricao(dto.getDescricao());
        cargoAtual.setSalario(dto.getSalario());

        // Atualiza a entidade pois ela possui um ID diferente de nulo
        Cargo atualizado = this.cargoRepository.save(cargoAtual);
        return atualizado;
    }
    // Deletar (DELETE)
    public void deletar(Integer idCargo) {
        Cargo cargo = this.getCargo(idCargo);
        // DELETE FROM cargo WHERE idCargo = ?
        this.cargoRepository.delete(cargo);
    }

    //Postman é como se fosse o cliente inserindo dados no frontend
}
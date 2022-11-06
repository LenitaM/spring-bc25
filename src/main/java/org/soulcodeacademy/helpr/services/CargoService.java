package org.soulcodeacademy.helpr.services;

/*AULA DIA 01 DE NOV DE 2022
*
*   Está atrelado a regra de negócios pq existe requisitos para usar o Repository.
* Possibilitando o restante da comunicação com o restante das camadas CargoRepository, Cargo até chegar no BD.
* Define como um filtro de quais dados podem ser acessados, ter, criar
* */

//precisa importar:
import org.soulcodeacademy.helpr.domain.Cargo;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CargoService {
    @Autowired //insere os dados no cargoRepository
    private CargoRepository cargoRepository;

    // Listar todos
    public List<Cargo> listar() { //1º criar um método. List<classe> = comando de superclasse de Array listar() = armazenamento
        // Retorna os dados da tabela em forma de lista
        return this.cargoRepository.findAll();// SELECT * FROM cargo;
    }

    // Listar um pelo ID
    public Cargo getCargo(Integer idCargo) {
        // Optional = Pode haver cargo ou não
        Optional<Cargo> cargo = this.cargoRepository.findById(idCargo);// SELECT * FROM cargo WHERE idCargo = ?

        if(cargo.isEmpty()) { // Não encontrou o cargo?
            // Não encontrou o cargo com id solicitado
            throw new RuntimeException("O cargo não foi encontrado!"); // Causa um erro com a mensagem
        } else {
            return cargo.get(); // Extrair o cargo de dentro do optional
        }
    }

    public Cargo salvar(Cargo novoCargo){
        novoCargo.setIdCargo(null); //limpar o campo id para não substituir cargos, quando add cargo novo o id tem que nulo
        //INSERT INTO cargo (equivale)
        Cargo cargoSalvo = this.cargoRepository.save(novoCargo);

        return cargoSalvo;
    }

    /*04 DE NO DE 2022*/

    // Atualizar (Update)
    // Precisa do ID do cargo e dos dados atualizados
    public Cargo atualizar(Integer idCargo, Cargo novoCargo) {
        // Verificar se o cargo existe mesmo
        Cargo cargoAtual = this.getCargo(idCargo);

        cargoAtual.setNome(novoCargo.getNome());
        cargoAtual.setDescricao(novoCargo.getDescricao());
        cargoAtual.setSalario(novoCargo.getSalario());

        // Atualiza a entidade pois ela possui um ID diferente de nulo
        Cargo atualizado = this.cargoRepository.save(cargoAtual);
        return atualizado;
    }
    // Deletar (Delete)
    public void deletar(Integer idCargo) {
        Cargo cargo = this.getCargo(idCargo);
        // DELETE FROM cargo WHERE idCargo = ?
        this.cargoRepository.delete(cargo);
    }

    //Postman é como se fosse o cliente inserindo dados no frontend
}
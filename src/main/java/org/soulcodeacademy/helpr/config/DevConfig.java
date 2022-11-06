package org.soulcodeacademy.helpr.config;

/*01 DE NOV DE 2022
*
* usada para configurar as outras packages
* */

import org.soulcodeacademy.helpr.services.PopulateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

// indica que esta classe será gerenciada pelo Spring
// e que ela é uma classe de configuração
@Configuration
@Profile("dev") // será instanciada apenas se o perfil ativo for "dev"
public class DevConfig { //forma como vai configurar o BD
    // Esta classe irá chamar o PopulateService caso o perfil ativo seja de desenvolvimento (create em dev-properties)
    @Autowired //importa os valores no PopulateService
    private PopulateService populateService;
    //acessa os valores do dev.properties
    @Value("${spring.jpa.hibernate.ddl-auto}") // vai acessar a propriedade, e por no atributo ddlAuto
    private String ddlAuto; //precisa saber qual DDL está sendo usado. (Ex: create, none, validate, create-drop)

    @PostConstruct // faz com que o método execute após a instância ser criada
    public void init() {
        if(this.ddlAuto.equals("create")) {  // se o modo for create, insere os dados fictícios
            this.populateService.populate(); //populate = do PopulateService
            // inserir os dados novos caso a tabela tenha sido dropada
        }
    }
}
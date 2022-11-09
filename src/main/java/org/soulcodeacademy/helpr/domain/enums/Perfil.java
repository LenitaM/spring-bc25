package org.soulcodeacademy.helpr.domain.enums;
/*AULA DIA 07 DE NOV DE 2022
*
* Criação de um enum.
* O Java enum é um tipo de dado utilizado para armazenar um conjunto de valores constantes,
* ou seja, são valores fixos, que não podem ser modificados
* */

public enum Perfil { //delimita um conjunto de valores constantes, nesse caso para classe Usuário.
    //Perfil Integer = Por padrão quando se usar o enum ele usa padrão numericos(INTEGER)
    //Com a anotoção @Enumerated o enum muda de tipo. Perfil VACHAR(255)
    ADMIN, // 0
    FUNCIONARIO, //1
    CLIENTE //2 - Mudado vai ser representado pelos nomes
}

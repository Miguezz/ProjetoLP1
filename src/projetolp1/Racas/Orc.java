/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;

import projetolp1.Principal.Personagem;

/**
 *
 * @author felip
 */
public class Orc extends RacaBase {
    public Orc(Personagem p){
        modAtributo(0); // Vida
        modAtributo(0); // Vida
    }
  
    @Override
    public boolean HabUtility(Personagem self, Personagem target){ //Endurecimento - Ganha shield e defesa +10 por 3 turnos
        if(self.getManaMaxima()- self.getManaGasta() >= 25){
            self.setShield((int) ((self.getDanoRecebido())/4)); //recebe shield
            
        return true;
        } else {
            System.out.println("Não é possivel usar o Endurecimento(Mana insuficiente)");
            return false;
        }

}
    }
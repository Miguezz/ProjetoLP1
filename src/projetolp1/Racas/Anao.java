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
public class Anao extends RacaBase {
    public Anao(Personagem p){
        modAtributo(0); // Vida
        modAtributo(2); // Defesa
     }
  
    @Override
    public boolean HabUtility(Personagem self, Personagem target){ //Pele de pedra - recebe shield com base na vida perdida atual
        if(self.getManaMaxima()-self.getManaGasta() >= 25){
            self.setshield((int) ((self.getDanoRecebido())/2)); //recebe shield
        return true;
        } else {
            System.out.println("Não é possivel usar a Pele de Pedra(Mana insuficiente)");
            return false;
        }    
    
    }
    
}
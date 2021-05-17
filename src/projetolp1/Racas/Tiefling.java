/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;

import projetolp1.Mapa.Mapas;
import projetolp1.Principal.Personagem;

/**
 *
 * @author felip
 */
public class Tiefling extends RacaBase {
    public Tiefling(Personagem p){
        modAtributo(1); // Mana
        modAtributo(3); // Dano
    }
    
    @Override
    public boolean HabUtility(Mapas mapa, Personagem self, Personagem target){ //Troca equivalente - Troca 20 de vida atual por 30 de mana
           if(self.getVidaMaxima() - self.getDanoRecebido() > 20){
               self.setManaGasta(self.getManaGasta() - 30);
               return true;
           } else {
               System.out.println("Não é possivel usar a Troca Equivalente(Vida insuficiente)");
               return false;
           }
    }
    
}

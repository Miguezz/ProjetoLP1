/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;

import projetolp1.Misc.MultipDano;
import projetolp1.Mapa.Mapas;
import projetolp1.Principal.Personagem;

/**
 *
 * @author felip
 */
public class Elfo extends RacaBase {

    public Elfo(Personagem p){
        modAtributo(1); // Mana
        modAtributo(1); // Mana
    } 
   
    @Override
   public boolean HabUtility(Mapas mapa, Personagem self, Personagem target){
        //A habilidade do Elfo é buffar seu proximo ataque no proximo turno em 2.5x em dano
        if(self.getMana() >= 25){
            self.getStatus().addStatus(12,1);
            //formula para aumentar2.5x o proximo golpe
            self.setManaGasta(self.getManaGasta() + 25); 
            return true;
        }
        else{
            System.out.println("Mana Insuficiente!");
            return false;
        }
    }
}
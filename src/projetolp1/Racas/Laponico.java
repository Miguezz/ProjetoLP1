/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;

import projetolp1.Mapa.BlocoMapa;
import projetolp1.Mapa.Mapas;
import projetolp1.Principal.Personagem;

/**
 *
 * @author felip
 */
public class Laponico extends RacaBase {
    public Laponico(Personagem p){
        modAtributo(0); // Vida
        modAtributo(1); // Mana
    }
    
    @Override
    public boolean HabUtility(BlocoMapa selfBloco, Personagem self, Personagem target){ // polimorfismo laponico
        if(self.getStatus().isStatus(11)){
            self.getStatus().cureStatus(11);
            return false;
        }
        if(self.getManaMaxima()- self.getManaGasta() >= 5){
            self.getStatus().addStatus(11, 50);//maximo de turnos no jogo a definir
        }     
        return true;
    }

}
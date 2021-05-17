/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;

import projetolp1.Misc.MultipDano;
import projetolp1.Principal.Personagem;

/**
 *
 * @author felip
 */
public class Dragonborn extends RacaBase {
    public Dragonborn(Personagem p){
        modAtributo(2); // Def
        modAtributo(3); // Dano
    }
    
    @Override
    public boolean HabUtility(Personagem self, Personagem target){ //Flamethrower - Lança chamas tirando 20 de dano e status burn
        if(self.getMana() >= 30){
        int range = 3; //getDanoPelaFormula(Personagem target, double formula, int elemento, boolean ignoraDef)
        if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
            self.setManaGasta(self.getMana() - 30);
            int elemento = 0; //Elemento fogo
            double formulaDano = 20;
            formulaDano = MultipDano.getDanoPelaFormula(target, formulaDano, elemento, false);
            target.addDanoRecebido(formulaDano);
            target.getStatus().addStatus(1,3);
        }
        return true;
        } else {
            System.out.println("Não é possivel usar o Flamethrower(Mana insuficiente)");
            return false;
        }   

    }
}
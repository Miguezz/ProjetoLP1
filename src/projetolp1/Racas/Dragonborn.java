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
        int range = 3;
        if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
            self.setManaGasta(30);
            int elemento = 0;
            double formulaDano = 20;
            double mult = MultipDano.resultado(elemento, target.getEquipamento().getDefElemental());
            formulaDano = formulaDano * mult;
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Classes;

import projetolp1.Mapa.Mapas;
import projetolp1.Misc.MultipDano;
import projetolp1.Principal.Personagem;

/**
 *
 * @author felip
 */
public class Cavaleiro extends ClasseMae {

//    public Cavaleiro(Personagem self) {
//        super(self);
//    }
		@Override
    public boolean habDano(Mapas mapa, Personagem self, Personagem target){
        int custo = 25;
        int range = 1;
        if(self.getMana() >= custo){
            if(mapa.getRangeEntreBlocos(self.getBlocoMapa(), target.getBlocoMapa()) <= range){
                self.setManaGasta(self.getManaGasta() + custo); // Diminui a mana do lançador de acordo com o valor da habilidade
                int elemento = self.getEquipamento().getAtkElemental();
                double formulaDano = 5 + self.getEquipamento().getAtk() * 1.5;
            formulaDano = MultipDano.getDanoPelaFormula(target, formulaDano, elemento, false);
            target.addDanoRecebido(formulaDano);
        }
        return true;
        }
    return false;
    }
    
    @Override
    public boolean habDef(Mapas mapa, Personagem self, Personagem target){
            int custo = 40;
            if(self.getMana() >= custo){
                    self.setManaGasta(self.getManaGasta() + custo);
                    self.getStatus().addStatus(9, 2); //status 9, status do cavaleiro
                    self.setManaGasta(self.getManaGasta() + 40);
            }
            return true;
    }
   
    @Override
    public boolean ultimate(Mapas mapa, Personagem self, Personagem target){
        int custo = 45;
        int range = 1;
        if(self.getMana() >= custo){
            if(mapa.getRangeEntreBlocos(self.getBlocoMapa(), target.getBlocoMapa()) <= range){
                self.setManaGasta(self.getManaGasta() + custo); // Diminui a mana do lançador de acordo com o valor da habilidade
                int elemento = self.getEquipamento().getAtkElemental();
                double formulaDano = self.getEquipamento().getAtk() * 3;
                                                    formulaDano = MultipDano.getDanoPelaFormula(target, formulaDano, elemento, false);
                target.addDanoRecebido(formulaDano);
            }
            return true;
        }
        return false;
    }
}

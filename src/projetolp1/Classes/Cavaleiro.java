/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Classes;

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
    public boolean habDano(Personagem self, Personagem target){
			int custo = 25;
			int range = 1;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = self.getEquipamento().getAtkElemental();
            double formulaDano = 5 + self.getEquipamento().getAtk() * 1.5;
						double mult = new MultipDano().resultado(elemento, target.getEquipamento().getDefElemental());
						formulaDano = formulaDano * mult;
						formulaDano -= target.getDefesa();
            target.addDanoRecebido(formulaDano);
        }
        return true;
			}
			return false;
    }
    
		public boolean habDef(Personagem self){
			int custo = 40;
			if(self.getMana() >= custo){
                            self.getStatus().addStatus(9, 2); //status 9, status do cavaleiro
                            self.setManaGasta(self.getManaGasta() + 40);
                        }
			return true;
		}
   
    @Override
    public boolean ultimate(Personagem self, Personagem target){
			int custo = 45;
			int range = 1;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = self.getEquipamento().getAtkElemental();
            double formulaDano = self.getEquipamento().getAtk() * 3;
						double mult = new MultipDano().resultado(elemento, target.getEquipamento().getDefElemental());
						formulaDano = formulaDano * mult;
						formulaDano -= target.getDefesa();
            target.addDanoRecebido(formulaDano);
        }
        return true;
			}
			return false;
		}
}

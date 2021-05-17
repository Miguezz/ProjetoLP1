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
public class Sacerdote extends ClasseMae {

		@Override
    public boolean habDano(Personagem self, Personagem target){
			int range = 3;
			int custo = 40;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = 4; // Sagrado
            double formulaDano = 30 + self.getEquipamento().getAtk();
						double mult = new MultipDano().resultado(elemento, target.getEquipamento().getDefElemental());
						formulaDano = formulaDano * mult;
						formulaDano -= target.getDefesa();
            target.setDanoRecebido(formulaDano);
        }
        return true;
			}
		 return false; 
    }
    
		public boolean habDef(Personagem self, Personagem target){
			int range = 3;
			int custo = 35;
			if(self.getMana() >= custo){
				self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
				// TODO: Implementar limpesa de Status (congelamento, paralisia, maldicao)
				if(target.getDanoRecebido() >= 15){
					target.setDanoRecebido(-15);
				}
			}
			return false;
		}
   
    @Override
    public boolean ultimate(Personagem self, Personagem target){
			int range = 3;
			int custo = 50;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						// TODO: Implementar cura de 5 em area por 3 rodadas
						// TODO: Implementar dano de 10 sem def, em area e por turno. Pode usar Status...
						int elemento = 4;
            double formulaDano = 20 + self.getDano();
						double mult = new MultipDano().resultado(elemento, target.getEquipamento().getDefElemental());
						formulaDano = formulaDano * mult;
            target.setDanoRecebido(formulaDano);
        }
        return true;
			}
       return false; 
		}
}

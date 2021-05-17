/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Classes;

import projetolp1.Misc.Dano;
import projetolp1.Principal.Personagem;
import projetolp1.Misc.MultipDano;

/**
 *
 * @author felip
 */
public class Feiticeiro extends ClasseMae {


		@Override
    public boolean habDano(Personagem self, Personagem target){
			int custo = 35;
			int range = 2;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = 3; // Vento
            double formulaDano = 20 + self.getEquipamento().getAtk();
						double mult = new MultipDano().resultado(elemento, target.getEquipamento().getDefElemental());
						formulaDano = formulaDano * mult;
						formulaDano -= target.getDefesa();
            target.setDanoRecebido(formulaDano);
        }
        return true;
			}
			return false;
    }
    
		public boolean habDef(Personagem self){
			int custo = 20;
			if(self.getMana() >= custo){
				// TODO: Implementar escudo com base na manaMax (max/2)
			}	
			return false;
		}
   
    @Override
    public boolean ultimate(Personagem self, Personagem target){
			int range = 3;
			int custo = 60;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						// TODO: Implementar area de ataque 4x3 e empurrar inimigos 2 blocos
						// TODO: Implementar chance de congelar inimigos de 25% por 2 rodadas
						int elemento = 1; // Agua
            double formulaDano = 25 + self.getEquipamento().getAtk() * 1.5;
						double mult = new MultipDano().resultado(elemento, target.getEquipamento().getDefElemental());
						formulaDano = formulaDano * mult;
						formulaDano -= target.getDefesa();
            target.setDanoRecebido(formulaDano);
        }
        return true;
			}
		 return false;   
		}
}

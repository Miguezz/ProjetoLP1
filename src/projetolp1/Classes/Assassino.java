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
public class Assassino extends ClasseMae {

//    public Assassino(Personagem self) {
//        super(self);
//    }
    // Lembrar de implementar formulas melhores pra as funcoes
    /**
     *
     * @param target Personagem alvo
     * @return
     */
		    
		@Override
    public boolean habDano(Personagem self, Personagem target){
			int custo = 25;
			int range = 1;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = 5; // Sombrio
            double formulaDano = 25;
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
			int custo = 30;
			if(self.getMana() >= custo){
				// TODO: Implementar escudo de 999, que é destruido por qualquer dano		
			}
			return true;
		}
   
    @Override
    public boolean ultimate(Personagem self, Personagem target){
			int custo = 45;
			int range = 2;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = 5; // Sombrio
            double formulaDano = 20 + (self.getEquipamento().getAtk() * 2);
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

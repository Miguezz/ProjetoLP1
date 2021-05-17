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
public class Cacador extends ClasseMae {

//    public Cacador(Personagem self) {
//        super(self);
//    }
		@Override
    public boolean habDano(Personagem self, Personagem target){
			int range = 4;
			int custo = 30;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = 2; // Terra
            double formulaDano = 15 + self.getEquipamento().getAtk();
						formulaDano = MultipDano.getDanoPelaFormula(target, formulaDano, elemento, false);
						// TODO: Implementar Status "Prender" (por 1 rodada)
						target.getStatus().addStatus(5, 1);
            target.addDanoRecebido(formulaDano);
        }
        return true;
			}
			return false; 
    }
    
		public boolean habDef(Personagem self){
			int range = 2;
			int custo =	15;
			if(self.getMana() >= custo){
				// TODO: Implementar: colocar armadilha no mapa
				// TODO: Implementar: Efeito da armadilha ("Prender" por 2 rodadas)
				return true;
			}
			return false;
		}
   
    @Override
    public boolean ultimate(Personagem self, Personagem target){
			int range = 3;
			int custo = 45;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = 2; // Terra
            double formulaDano = 30 + self.getEquipamento().getAtk() * 2;
						// TODO: Implementar Status Stun por 1 rodada
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

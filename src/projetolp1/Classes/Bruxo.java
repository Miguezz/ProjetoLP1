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
public class Bruxo extends ClasseMae {

//    public Bruxo(Personagem self) {
//        super(self);
//    }
 		@Override
    public boolean habDano(Personagem self, Personagem target){
			int range = 3;
			int custo = 30;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = 5; // Sombrio
            double formulaDano = 10 + self.getEquipamento().getAtk();
						double mult = new MultipDano().resultado(elemento, target.getEquipamento().getDefElemental());
						formulaDano = formulaDano * mult;
						formulaDano -= target.getDefesa();
						// TODO: Implementar Status	de Maldição que causa 10 de dano por 3 turnos
            target.addDanoRecebido(formulaDano);
        }
        return true;
			}
			return false;
    }
    
		public boolean habDef(Personagem self){
			int custo =	(self.getVidaMaxima())/5;
			if(self.getVidaMaxima() - self.getDanoRecebido() > custo){
				self.addDanoRecebido(custo); // TODO: Verificar se vai ser compativel com a mudança no addDanoRecebido que Leao ficou de fazer
				// TODO: Implementar escudo de 3x vidaAtual
				// TODO: Implementar fim do escudo quando cura
			}
			return false;
		}
   
    @Override
    public boolean ultimate(Personagem self, Personagem target){
			int range = 4;
			int custo = 60;
			if(self.getMana() >= custo){
				if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= range){
					// TODO: Implementar dano em area
					// TODO: Implementar Status Burn por 3 turnos (para aliados e inimigos atingidos)
						self.setManaGasta(custo); // Diminui a mana do lançador de acordo com o valor da habilidade
						int elemento = 0;
            double formulaDano = 20 + self.getEquipamento().getAtk();
						double mult = new MultipDano().resultado(elemento, target.getEquipamento().getDefElemental());
						formulaDano = formulaDano * mult;
						// Por enquanto ta sem a defesa do alvo
            target.addDanoRecebido(formulaDano);
        }
        return true;
			}
       return false; 
		}
}

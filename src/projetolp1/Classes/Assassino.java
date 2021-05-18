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
    public boolean habDano(Mapas mapa, Personagem self, Personagem target){
        int custo = 25;
        int range = 1;
        if(self.getMana() >= custo){
            if(mapa.getRangeEntreBlocos(self.getBlocoMapa(), target.getBlocoMapa()) <= range){
                self.setManaGasta(self.getManaGasta() + custo); // Diminui a mana do lançador de acordo com o valor da habilidade
                int elemento = 5; // Sombrio
                double formulaDano = 25;
                formulaDano = MultipDano.getDanoPelaFormula(target, formulaDano, elemento, false);
                target.addDanoRecebido(formulaDano);
        }
        return true;
			}
			return false;
		}
    
                
                @Override
		public boolean habDef(Mapas mapa, Personagem self, Personagem target){
			int custo = 30;
			if(self.getMana() >= custo){
                                self.setManaGasta(self.getManaGasta() + custo);
				self.getStatus().addStatus(8, 2);
			}
			return true;
		}
   
    @Override
    public boolean ultimate(Mapas mapa, Personagem self, Personagem target){
        int custo = 45;
        int range = 2;
        if(self.getMana() >= custo){
            if(mapa.getRangeEntreBlocos(self.getBlocoMapa(), target.getBlocoMapa()) <= range){
                self.setManaGasta(self.getManaGasta() + custo); // Diminui a mana do lançador de acordo com o valor da habilidade
                int elemento = 5; // Sombrio
                double formulaDano = 20 + (self.getEquipamento().getAtk() * 2);
                formulaDano = MultipDano.getDanoPelaFormula(target, formulaDano, elemento, false);
                target.addDanoRecebido(formulaDano);
            }
            return true;
        }
    return false;
    }
}

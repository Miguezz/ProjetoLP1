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
public class Cacador extends ClasseMae {

    @Override
    public boolean habDano(Mapas mapa, Personagem self, Personagem target){
        int range = 4;
        int custo = 30;
        if(self.getMana() >= custo){
            if(mapa.getRangeEntreBlocos(self.getBlocoMapa(), target.getBlocoMapa()) <= range){
                self.setManaGasta(self.getManaGasta() + custo); // Diminui a mana do lançador de acordo com o valor da habilidade
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
    
    @Override
    public boolean habDef(Mapas mapa, Personagem self, Personagem target){
        int range = 2;
        int custo = 15;
        if(self.getMana() >= custo){
            if(mapa.getRangeEntreBlocos(self.getBlocoMapa(), target.getBlocoMapa()) <= range){
                self.setManaGasta(self.getManaGasta() + custo);
            // TODO: Implementar: colocar armadilha no mapa (interface grafica)
            // TODO: Implementar: Efeito da armadilha ("Prender" por 2 rodadas)
                target.getStatus().addStatus(5, 2);
                return true;

            }

        }
        return false;
    }
   
    @Override
    public boolean ultimate(Mapas mapa, Personagem self, Personagem target){
        int range = 3;
        int custo = 45;
        if(self.getMana() >= custo){
            if(mapa.getRangeEntreBlocos(self.getBlocoMapa(), target.getBlocoMapa()) <= range){
                self.setManaGasta(self.getManaGasta() + custo); // Diminui a mana do lançador de acordo com o valor da habilidade
                int elemento = 2; // Terra
                double formulaDano = 30 + self.getEquipamento().getAtk() * 2;
                formulaDano = MultipDano.getDanoPelaFormula(target, formulaDano, elemento, false);
                target.getStatus().addStatus(2, 1);
                target.addDanoRecebido(formulaDano);
            }
            return true;
            }
        return false;   
    }
}

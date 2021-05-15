/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Classes;

import projetolp1.Misc.Dano;
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
        if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= this.ranges[0]){
            float formulaDano = 10 + self.getDano();
            Dano dano = new Dano(0, formulaDano);
            target.setDanoRecebido(dano);
        }
        return true;
    }
    
    @Override
    public boolean habDef(Personagem self, Personagem target){
        if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= this.ranges[1]){
            System.out.println("Defesa");
        }
        return true;
    }
    
    @Override
    public boolean ultimate(Personagem self, Personagem target){
        if(target.getPosicaoNoMapa() - self.getPosicaoNoMapa() <= this.ranges[2]){
            float formulaDano = 20 + self.getDano(); 
            Dano dano = new Dano(0, formulaDano);
            target.setDanoRecebido(dano);
        }
        
        return true;
    }
}
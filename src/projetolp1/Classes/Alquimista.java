/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Classes;
import projetolp1.Principal.Personagem;
import projetolp1.Misc.Dano;
/**
 *
 * @author felip
 */
public abstract class Alquimista extends ClasseMae {
    Personagem self; // Link para o personagem dono da que possui a classe Alquimista
    public Alquimista(Personagem self){
        super(self);
        this.ranges[0] = 1;
        this.ranges[1] = 1;
        this.ranges[2] = 1;
        this.self = self;
    }
    
    // Lembrar de implementar formulas melhores pra as funcoes
    /**
     *
     * @param target Personagem alvo
     * @return
     */
    @Override
    public boolean habDano(Personagem target){
        if(target.getPosicaoNoMapa() - this.self.getPosicaoNoMapa() <= this.ranges[0]){
            float formulaDano = 10 + this.self.getDano().getValor();
            Dano dano = new Dano(0, formulaDano);
            target.setDanoRecebido(dano);
        }
        return true;
    }
    
    @Override
    public boolean habDef(Personagem target){
        if(target.getPosicaoNoMapa() - this.self.getPosicaoNoMapa() <= this.ranges[1]){
            System.out.println("Defesa");
        }
        return true;
    }
    
    @Override
    public boolean ultimate(Personagem target){
        if(target.getPosicaoNoMapa() - this.self.getPosicaoNoMapa() <= this.ranges[2]){
            float formulaDano = 20 + this.self.getDano().getValor(); 
            Dano dano = new Dano(0, formulaDano);
            target.setDanoRecebido(dano);
        }
        
        return true;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Items.Consumiveis;

import projetolp1.Items.Inventario;
import projetolp1.Misc.Rand;
import projetolp1.Principal.Personagem;

/**
 *
 * @author Batata
 */
public class PotionMana extends Consumivel {
    
    PotionMana(int a, Inventario x) {
        super(a,x);
    }
    PotionMana(String a, int b, Inventario x) {
        super(a,b,x);
    }
    PotionMana(String a, String b, int c, Inventario x) {
        super(a,b,c,x);
    }
    
    public int efeito(Personagem p){
    int Mana = Rand.New() % 11;
    Mana += 20;
    if(p.getManaGasta() < Mana){
    p.setManaGasta(0);
    }else{
    p.setManaGasta(p.getManaGasta() - Mana);
    }
    return 1; 
}
    
}

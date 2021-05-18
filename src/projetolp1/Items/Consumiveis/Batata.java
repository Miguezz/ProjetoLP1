/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Items.Consumiveis;
import projetolp1.Items.Inventario;
import projetolp1.Principal.Personagem;
import projetolp1.Misc.Rand;
        
/**
 *
 * @author Batata
 */
public class Batata extends Consumivel {
    
    Batata(int qtd, Inventario x) {
        super("Uma batata, Restaura uma pequena quantidade de vida e mana", qtd,x); 
    }
    /*Batata(String desc, int qtd, Inventario x) {
        super(desc,qtd,x);
    }
    Batata(String name, String desc, int qtd, Inventario x) {
        super(name,desc,qtd,x); 
    }*/
    
    public int efeito(Personagem p){
    int cura = Rand.New() % 11; int Mana = Rand.New() % 6; 
    cura += 15;Mana += 10;
    if(p.getDanoRecebido() < cura){
        p.addDanoRecebido(0);
        }else{
        p.addDanoRecebido(p.getDanoRecebido() - cura);
    }
        if(p.getManaGasta() < Mana){
        p.setManaGasta(0);
        }else{
        p.setManaGasta(p.getManaGasta() - Mana);
    }
   return 1;
  }
}

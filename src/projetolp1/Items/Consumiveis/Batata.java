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
    
    Batata(int a, Inventario x) {
        super(a,x); 
    }
    /*Batata(String a, int b, Inventario x) {
        super(a,b,x);
    }
    Batata(String a, String b, int c, Inventario x) {
        super(a,b,c,x); // Coloca nome de variavel melhor, pq senao daq a pouco vc nem sabe oq isso é
    }*/
    
    public int efeito(Personagem p){
    int cura = Rand.New() % 11; int Mana = Rand.New() % 6; 
    cura += 15;Mana += 10;
    if(p.getDanoRecebido() < cura){
        p.setDanoRecebido(0);
        }else{
        p.setDanoRecebido(p.getDanoRecebido() - cura);
    }
    if(p.getManaGasta() < Mana){
        p.setManaGasta(0);
        }else{
        p.setManaGasta(p.getManaGasta() - Mana);
    }
   return 1;
  }
}

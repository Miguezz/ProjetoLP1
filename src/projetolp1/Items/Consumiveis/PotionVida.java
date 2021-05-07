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
public class PotionVida extends Consumivel{
    
    PotionVida(int a, Inventario x) {
        super("Pot de Vida" , "Restaura uma certa quantidade de vida" ,a,x);
    }
  /*PotionVida(String desc, int qtd, Inventario x) {
        super(desc,qtd,x);
    }
    PotionVida (String name, String desc, int qtd, Inventario x) {
        super(name,desc,qtd,x); 
    }*/
    
    public int efeito(Personagem p){
    int cura = Rand.New() % 21;
    cura += 30;
    if(p.getDanoRecebido() < cura){
    p.setDanoRecebido(0);
    }else{
    p.setDanoRecebido(p.getDanoRecebido() - cura);
    }
    return 1;
    }
}

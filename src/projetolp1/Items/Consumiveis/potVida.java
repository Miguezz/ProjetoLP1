/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1;

/**
 *
 * @author Batata
 */
public class potVida extends Consumivel {
    


  public int efeito(Personagem p){
    int cura = Random.New() % 21;
    cura += 30;
    if(getDanoRecebido() < cura){
    setDanoRecebido(0);
    }else{
    setDanoRecebido(getDanoRecebido - cura);
    }
  }


}


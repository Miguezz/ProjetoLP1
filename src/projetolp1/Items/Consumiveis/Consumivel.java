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
public abstract class Consumivel {
    
  private int quantidade;
  
  public int Consumir(int quant, Personagem p){
  quantidade =  quantidade - quant;
  efeito(p);
  return quantidade;
  }

  public abstract int efeito(Personagem p);

}

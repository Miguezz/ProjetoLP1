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

public abstract class RacaBase { 
  public abstract int HabUtility(Personagem alvo);

  public void modAtributo(Personagem p, int atr){
    switch(atr){
      case 0:
        p.setVida(p.getVidaMaxima() + 20);
        break;
      case 1:
        p.setManaMaxima(p.getManaMaxima() + 10);
        break;
      case 2:
        p.setDefesa(p.getDefesa() + 5);
        break;
      case 3:
        p.setDanoBase(p.getDanoBase() + 5);
        break;
    }
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;
import projetolp1.Principal.Personagem;

/**
 *
 * @author Batata
 */

public abstract class RacaBase { 

    /**
     * @return the armaFavorita
     */
    public String getArmaFavorita() {
        return "";
    }

  public abstract boolean HabUtility(Personagem p);
  
  
/** 
 *  Modificador de atributo baseado na raca do personagem
     * @param p
     * @param atr
 */
  public void modAtributo(Personagem p, int atr){
    switch(atr){
      case 0: //aumenta 20 de vidaMaxima
        p.setVidaMaxima(p.getVidaMaxima() + 20); 
        break;
      case 1: //aumenta 10 de manaMaxima
        p.setManaMaxima(p.getManaMaxima() + 10);
        break;
      case 2: //aumenta 5 de defesa
        p.setDefesa(p.getDefesa() + 5);
        break;
      case 3: //aumenta 5 de dano
        p.setDanoBase(p.getDanoBase() + 5);
        break;
    }
  }
}
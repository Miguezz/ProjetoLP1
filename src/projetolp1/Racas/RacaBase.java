/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;
import projetolp1.Principal.Personagem;
import java.io.Serializable;
/**
 *
 * @author Batata
 */

public abstract class RacaBase implements Serializable{ 

    /**
     * @return the modVidaMax
     */
    public int getModVidaMax() {
        return modVidaMax;
    }

    /**
     * @return the modDefMax
     */
    public int getModDefBase() {
        return modDefBase;
    }

    /**
     * @return the modManaMax
     */
    public int getModManaMax() {
        return modManaMax;
    }

    /**
     * @return the modDanoBase
     */
    public int getModDanoBase() {
        return modDanoBase;
    }

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
    private int modVidaMax = 0;
/** 
 *  Modificador de atributo baseado na raca do personagem
     * @param p
     * @param atr
 */
    private int modDefBase = 0;
/** 
 *  Modificador de atributo baseado na raca do personagem
     * @param p
     * @param atr
 */
    private int modManaMax = 0;
/** 
 *  Modificador de atributo baseado na raca do personagem
     * @param p
     * @param atr
 */
    private int modDanoBase = 0;
    
  public void modAtributo(int atr){
    switch(atr){
      case 0: //aumenta 20 de vidaMaxima
        this.modVidaMax += 20; 
        break;
      case 1: //aumenta 10 de manaMaxima
        this.modManaMax += 10;
        break;
      case 2: //aumenta 5 de defesa
        this.modDefBase += 5;
        break;
      case 3: //aumenta 5 de dano
        this.modDanoBase += 5;
        break;
    }
  }
}

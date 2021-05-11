/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;

import projetolp1.Principal.Personagem;

/**
 *
 * @author felip
 */
public class Laponico extends RacaBase {
    public Laponico(Personagem p){
        modAtributo(p, 0); // Vida
        modAtributo(p, 1); // Mana
    }
  
    public boolean HabUtility(Personagem p){
           p.setshield((int) ((p.getshield() + p.getDanoRecebido())/2));
        return true;
    }

}
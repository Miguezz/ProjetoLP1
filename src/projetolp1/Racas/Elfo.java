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
public class Elfo extends RacaBase {
    public Elfo(Personagem p){
        modAtributo(p, 1); // Mana
        modAtributo(p, 1); // Mana
    } 
   
    public boolean HabUtility(Personagem p){
           p.setshield((int) ((p.getshield() + p.getDanoRecebido())/2));
        return true;
    }

}
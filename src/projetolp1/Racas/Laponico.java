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
        modAtributo(0); // Vida
        modAtributo(1); // Mana
    }
    
    @Override
    public boolean HabUtility(Personagem p, Personagem q){ // polimorfismo laponico
           
        return true;
    }

}
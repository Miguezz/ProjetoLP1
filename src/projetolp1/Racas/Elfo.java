/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Racas;

import projetolp1.Mapa.Mapas;
import projetolp1.Principal.Personagem;

/**
 *
 * @author felip
 */
public class Elfo extends RacaBase {
    public Elfo(Personagem p){
        modAtributo(1); // Mana
        modAtributo(1); // Mana
    } 
   
    @Override
    public boolean HabUtility(Mapas mapa, Personagem p, Personagem q){

        return true;
    }

}
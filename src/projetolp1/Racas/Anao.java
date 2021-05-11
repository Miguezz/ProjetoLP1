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
public class Anao extends RacaBase {
    public Anao(Personagem p){
        modAtributo(p, 0); // Vida
        modAtributo(p, 2); // Defesa
     }
  
    @Override
    public boolean HabUtility(Personagem p){
           p.setshield((int) ((p.getshield() + p.getDanoRecebido())/2)); //recebe shield
        return true;
    }
}
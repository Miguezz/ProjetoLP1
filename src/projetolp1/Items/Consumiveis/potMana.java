/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Items.Consumiveis;
import projetolp1.Principal.Personagem;
/**
 *
 * @author Batata
 */
public class potMana extends Consumivel {
    


  public int efeito(Personagem p){
    int Mana = Random.New() % 11;
    Mana += 20;
    if(getManaGasta() < Mana){
    setManaGasta(0);
    }else{
    setManaGasta(getManaGasta - Mana);
    }
  }


}


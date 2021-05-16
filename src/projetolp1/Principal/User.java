/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Principal;

import java.util.ArrayList;
import projetolp1.Items.Inventario;
import java.io.Serializable;
/**
 *
 * @author Batata
 */
public class User implements Serializable{

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    private String name ;
    
    ArrayList<Personagem>PersonagensCriados = new ArrayList<>();
    
    ArrayList<Personagem> Party = new ArrayList<>(); // n sei como deveriamos implementar isso,
                                                     // vamos deixar só poder criar 5 persoangens, ou
                                                     // remover 5, depois devolver pra PersonagensCriados?
    Inventario inventario = new Inventario();
	
		public void listarParty(){
			System.out.println("Party:");
			for(int i = 0; i < Party.size(); i++){
				System.out.println(Party.get(i));
			}
		}

		@Override
		public String toString(){
			return ("Jogador: " + this.name + "\n");
		}
    
}

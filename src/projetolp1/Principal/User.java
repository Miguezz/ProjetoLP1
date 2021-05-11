/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Principal;

import java.util.ArrayList;
import projetolp1.Items.Inventario;

/**
 *
 * @author Batata
 */
public class User {

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
                                                     //remover 5, depois devolver pra PersonagensCriados?
    Inventario inventario = new Inventario();
    
    
}

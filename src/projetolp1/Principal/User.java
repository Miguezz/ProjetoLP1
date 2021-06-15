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
    private String name;
    
    private ArrayList<Personagem>PersonagensCriados = new ArrayList<>();
    
    private ArrayList<Personagem> Party = new ArrayList<>(); // n sei como deveriamos implementar isso,
                                                     // vamos deixar só poder criar 5 persoangens, ou
                                                     // remover 5, depois devolver pra PersonagensCriados?
    private Inventario inventario = new Inventario();
    
    private boolean vez = false;

    private int qtdAcoes;
    
    public User(){
        this.qtdAcoes = 5;
    }
    
    public int getQtdAcoes(){
        return this.qtdAcoes;
    }
    public void setQtdAcoes(int qtd){
        this.qtdAcoes = qtd;
    }
    
    public void setVez(boolean vez){
        this.vez = vez;
    }
    
    public boolean getVez(){
        return this.vez;
    }
    
    public Inventario getInventario() {
        return inventario;
    }

    /**
     * @param inventario the inventario to set
     */
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    /**
     * @return the PersonagensCriados
     */
    public ArrayList<Personagem> getPersonagensCriados() {
        return PersonagensCriados;
    }

    /**
     * @param PersonagensCriados the PersonagensCriados to set
     */
    public void setPersonagensCriados(ArrayList<Personagem> PersonagensCriados) {
        this.PersonagensCriados = PersonagensCriados;
    }

    /**
     * @return the Party
     */
    public ArrayList<Personagem> getParty() {
        return Party;
    }

    /**
     * @param Party the Party to set
     */
    public void setParty(ArrayList<Personagem> Party) {
        this.Party = Party;
    }

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
    
    public void listarParty(){
        System.out.println("Party:");
        for(int i = 0; i < getParty().size(); i++){
                System.out.println(getParty().get(i));
        }
    }

    @Override
    public String toString(){
        return ("Jogador: " + this.name + "\n");
    }
    
    public void endOfTurn(){
        this.Party.forEach(p -> {
            p.endOfTurn();
        });
        this.qtdAcoes = 5;
        this.setVez(false);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Misc;
import java.io.Serializable;

/**
 *
 * @author Batata
 */
public class StatusUnit implements Serializable{

    private boolean fezEfeito;
    StatusUnit(int tipo, int dur){
     this.tipo = tipo;
     this.tempo = dur;
     this.fezEfeito = false;
    }
    
    public boolean getFezEfeito(){
        return this.fezEfeito;
    }
    
    public void setFezEfeito(boolean valor){
        this.fezEfeito = valor;
    }
    
    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @return the tempo
     */
    public int getTempo() {
        return tempo;
    }

    /**
     * @param tempo the tempo to set
     */
    public void decTempo() {
        this.tempo -= 1;
    }
  
    private int tipo;
    
    private int tempo;
    
    
}

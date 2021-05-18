package projetolp1.Mapa;
import projetolp1.Principal.Personagem;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FelipeBrasileiro
 */
public class BlocoMapa {
    private int[] posicao = new int[2];
    private Object ocupante;
    private Mapas mapa;
    
    public BlocoMapa(int x, int y){
        this.posicao[0] = x;
        this.posicao[1] = y;
        this.ocupante = null;
    }
    
    public void setOcupante(Object ocupante){
        if(ocupante instanceof Personagem || ocupante instanceof Obstaculo){
            this.ocupante = ocupante;
        }else{
            this.ocupante = null;
        }
    }
    
    public Object getOcupante(){
        return this.ocupante;
    }
    
    public int[] getPosicao(){
        return this.posicao;
    }
    
    @Override
    public String toString(){
        if(this.ocupante instanceof Personagem){
            Personagem p = (Personagem) ocupante;
            return(Integer.toString(p.getRacaInt()));
        }else if(this.ocupante instanceof Obstaculo){
            return("X");
        }
        return(".");
    }
}

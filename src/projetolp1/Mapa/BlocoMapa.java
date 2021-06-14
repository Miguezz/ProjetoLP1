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
    private String bg;
    private String fg;
//    private String time;
    private String estilo;
    
    public BlocoMapa(int x, int y){
        this.posicao[0] = x;
        this.posicao[1] = y;
        this.ocupante = null;
        this.estilo = "";
    }
//    public void setTime(String t){
//        this.time = t;
//    }
//    public String getTime(){
//        return this.time;
//    }
    public void setEstilo(String estilo){
        this.estilo = estilo;
    }
    public String getEstilo(){
        return this.estilo;
    }
    public void setBg(String bg){
        this.bg = bg;
    }
    public void setFg(String fg){
        this.fg = fg;
    }
    public String getBg(){
        return this.bg;
    }
    public String getFg(){
        return this.fg;
    }
    
    public void setOcupante(Object ocupante){
        if(ocupante instanceof Personagem) {
            ((Personagem) ocupante).setBlocoMapa(this);
            this.ocupante = ocupante;
        }else if(ocupante instanceof Obstaculo){
            this.ocupante = ocupante;
        }
        else{
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
            return(" " + Integer.toString(p.getRacaInt()) + " ");
        }else if(this.ocupante instanceof Obstaculo){
            return(" X ");
        }
        return(" . ");
    }
    
    public int getRangeEntreBlocos(BlocoMapa b1){
        int[] p1 = b1.getPosicao();
        int[] p2 = this.getPosicao();
        if(p1[0] - p2[0] > p1[1] - p2[1]){
            return Math.abs(p1[1] - p2[1]);
        }
        return  Math.abs(p1[0] - p2[0]);
    }
}

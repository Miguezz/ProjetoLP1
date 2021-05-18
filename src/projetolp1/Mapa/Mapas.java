/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolp1.Mapa;

import projetolp1.Principal.Personagem;

/**
 *
 * @author Rafael Miguez
 */
public class Mapas {
    //adicionar objeto obstaculo dps da av2.
    
    private BlocoMapa[][] mapa = new BlocoMapa[7][7];
    private int xMax;
    private int yMax;
    public Mapas(int xMax, int yMax){
        this.xMax = xMax;
        this.yMax = yMax;
        for(int i = 0; i < yMax; i++){
            for(int j = 0; j < xMax; j++){
                mapa[i][j] = new BlocoMapa(i, j);
            }
        }
    }
    
    public int getXMax(){
        return this.xMax;
    }
    public int getYMax(){
        return this.yMax;
    }
    
    public void printMapa(){
        for(int i = 0; i < yMax; i++){
            for(int j = 0; j < xMax; j++){
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }
    
    public BlocoMapa getBlocoPelaPos(int x, int y){
         if(x < this.getXMax() && x >= 0 && y < this.getYMax() && y >= 0){
            return this.mapa[x][y];
         }
         return null;
    }
    
    public boolean insertOcupanteBloco(Object o, int x, int y){
        if(x < this.getXMax() && x >= 0 && y < this.getYMax() && y >= 0){
            BlocoMapa b = this.mapa[y][x];
            if(b.getOcupante() == null){
                b.setOcupante(o);
                if(o instanceof Personagem){
                    Personagem p = (Personagem)o;
                    p.setBlocoMapa(b);
                }
                return true;
            }
        }
        return false;
    }
    
    public int getRangeEntreBlocos(BlocoMapa b1, BlocoMapa b2){
        int[] p1 = b1.getPosicao();
        int[] p2 = b2.getPosicao();
        if(p1[0] - p2[0] > p1[1] - p2[1]){
            return Math.abs(p1[1] - p2[1]);
        }
//        System.out.println(p1[0] + " " + p1[1]);
//        System.out.println(p2[0] + " " + p2[1]);
        return  Math.abs(p1[0] - p2[0]);
    }
}
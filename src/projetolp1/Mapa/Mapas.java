/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolp1.Mapa;

/**
 *
 * @author Rafael Miguez
 */
public class Mapas {
    //adicionar objeto obstaculo dps da av2.
    
    private BlocoMapa [][] mapa;
    public Mapas(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                mapa[i][j] = new BlocoMapa(i, j);
            }
        }
    }
    
    public void printMapa(){
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }
    
    public BlocoMapa getBlocoPelaPos(int x, int y){
        return this.mapa[x][y];
    }
    
    public boolean insertOcupanteBloco(Object o, int x, int y){
        BlocoMapa b = this.mapa[x][y];
        if(b.getOcupante() == null){
            b.setOcupante(o);
            return true;
        }
        return false;
    }
    
    public int getRangeEntreBlocos(BlocoMapa b1, BlocoMapa b2){
        int [] p1 = b1.getPosicao();
        int [] p2 = b1.getPosicao();
        if(p1[0] - p2[0] < p1[1] - p2[1]){
            return p1[1] - p2[1];
        }
        return p1[0] - p2[0];
    }
}
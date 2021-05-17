/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Principal;

/**
 *
 * @author Rafael Miguez
 */
public class Mapas {
    //adicionar objeto obstaculo dps da av2.
    
    private static char [][] mapa1 = {{'*','*','*','*','*','*','*'},
                                      {'*','.','.','.','.','.','*'},
                                      {'*','.','.','.','.','.','*'},
                                      {'*','.','.','.','.','.','*'},
                                      {'*','.','.','.','.','.','*'},
                                      {'*','.','.','.','.','.','*'},
                                      {'*','.','.','.','.','.','*'},
                                      {'*','.','.','.','.','.','*'},
                                      {'*','.','.','.','.','.','*'},
                                      {'*','*','*','*','*','*','*'}};
    
    public void Printmapa(){
        for(int i = 0; i < 7; i++){
            
            for(int j = 0; j < 7; j++){
            System.out.print(mapa1[i][j]);
            }
            System.out.println();
    }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Misc;

/**
 *
 * @author Batata
 */
public class MultipDano {
	// 0 - Fogo
	// 1 - Agua
	// 2 - Terra
	// 3 - Vento
	// 4 - Sagrado
	// 5 - Sombrio
	// 6 - Neutro
   private double[][] tabela = {{0.1,0.5,1.5,1,0.9,1.2,1},
                                {1.5,0.1,1,0.5,0.9,1.2,1},
                                {0.5,1,0.1,1.5,0.9,1.2,1},
                                {1,1.5,0.5,0.1,0.9,1.2,1},
                                {0.8,0.8,0.8,0.8,0.1,2,1},
                                {1.1,1.1,1.1,1.1,2,0.1,1.5},
                                {1,1,1,1,0.5,1.2,1}};
    
    public double resultado(int ataque, int def){
        return tabela[ataque][def];
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Principal;
import projetolp1.Classes.*;
import projetolp1.Racas.*;
/**
 *
 * @author FelipeBrasileiro
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Personagem p = new Personagem("Teste 1", 1, 0);
        Personagem p2 = new Personagem("Teste 2", 3, 2);
        System.out.println(p);
        p2.getClasse().habDano(p2, p);
        
        p.getRaca().HabUtility(p);
        System.out.println(p);
        
    }
    
}

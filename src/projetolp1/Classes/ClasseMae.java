/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Classes;
import projetolp1.Principal.Personagem;
import java.io.Serializable;
/**
 *
 * @author Batata
 */
public abstract class ClasseMae implements Serializable{
    
    public abstract boolean habDano(Personagem self, Personagem target);
    
    public abstract boolean ultimate(Personagem self, Personagem alvo);

}

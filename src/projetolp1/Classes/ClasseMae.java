/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Classes;
import projetolp1.Principal.Personagem;
import java.io.Serializable;
import projetolp1.Mapa.Mapas;
/**
 *
 * @author Batata
 */
public abstract class ClasseMae implements Serializable{
    
    public abstract boolean habDano(Mapas mapa, Personagem self, Personagem target);
    
    public abstract boolean habDef(Mapas mapa, Personagem self, Personagem target);
    
//    public abstract boolean habDef(Mapas mapa, Personagem self, Personagem target)
    public abstract boolean ultimate(Mapas mapa, Personagem self, Personagem alvo);

}

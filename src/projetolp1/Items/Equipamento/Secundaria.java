package projetolp1.Items.Equipamento;
import projetolp1.Items.Item;
import java.io.Serializable;

public class Secundaria extends Item implements Serializable{

    /**
     * @return the buffAtacar
     */
    public int getBuffAtacar() {
        return buffAtacar;
    }

    /**
     * @return the buffDef
     */
    public int getBuffDef() {
        return buffDef;
    }

    /**
     * @return the buffVida
     */
    public int getBuffVida() {
        return buffVida;
    }

    /**
     * @return the buffMana
     */
    public int getBuffMana() {
        return buffMana;
    }
    public int tipoBuff;
    Secundaria(String nome, String desc, int tipoBuff){
        super(nome, desc);
        this.tipoBuff = tipoBuff;               
        }
    
    private int buffAtacar;
    
    /*public void SerEquipado(Personagem p){
        switch(tipoBuff){
            case 0:
                //buff ataque
            case 1:
                //buff defesa
            case 2:
                //buff ataque
                //buff vidaMaxima
                //buff manaMaxima
        }
    }*/
    
        /*public void SerDesequipado(Personagem p){
        switch(tipoBuff){
            case 0:
                //buff ataque
            case 1:
                //buff defesa
            case 2:
                //buff ataque
                //buff vidaMaxima
                //buff manaMaxima
        }
    }*/
    private int buffDef;
    
    /*public void SerEquipado(Personagem p){
        switch(tipoBuff){
            case 0:
                //buff ataque
            case 1:
                //buff defesa
            case 2:
                //buff ataque
                //buff vidaMaxima
                //buff manaMaxima
        }
    }*/
    
        /*public void SerDesequipado(Personagem p){
        switch(tipoBuff){
            case 0:
                //buff ataque
            case 1:
                //buff defesa
            case 2:
                //buff ataque
                //buff vidaMaxima
                //buff manaMaxima
        }
    }*/
    private int buffVida;
    
    /*public void SerEquipado(Personagem p){
        switch(tipoBuff){
            case 0:
                //buff ataque
            case 1:
                //buff defesa
            case 2:
                //buff ataque
                //buff vidaMaxima
                //buff manaMaxima
        }
    }*/
    
        /*public void SerDesequipado(Personagem p){
        switch(tipoBuff){
            case 0:
                //buff ataque
            case 1:
                //buff defesa
            case 2:
                //buff ataque
                //buff vidaMaxima
                //buff manaMaxima
        }
    }*/
    private int buffMana;
    
    /*public void SerEquipado(Personagem p){
        switch(tipoBuff){
            case 0:
                //buff ataque
            case 1:
                //buff defesa
            case 2:
                //buff ataque
                //buff vidaMaxima
                //buff manaMaxima
        }
    }*/
    
        /*public void SerDesequipado(Personagem p){
        switch(tipoBuff){
            case 0:
                //buff ataque
            case 1:
                //buff defesa
            case 2:
                //buff ataque
                //buff vidaMaxima
                //buff manaMaxima
        }
    }*/
  }

package projetolp1.Items.Equipamento;
import projetolp1.Items.Item;
import java.io.Serializable;

public class Secundaria extends Item implements Serializable{
    private int buffAtacar;
    private int buffDef;
    private int buffVida;
    private int buffMana;
    public int tipoBuff;
    
    Secundaria(String nome, String desc, int buffAtacar, int buffDef, int buffVida, int buffMana){
        super(nome, desc);
    }
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
  }

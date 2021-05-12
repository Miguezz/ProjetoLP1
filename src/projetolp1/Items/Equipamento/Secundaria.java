package projetolp1.Items.Equipamento;
import projetolp1.Items.Item;
import projetolp1.Principal.Personagem;

class Secundaria extends Item{
    public int tipoBuff;
    Secundaria(String nome, String desc, int tipoBuff){
        super(nome, desc);
        this.tipoBuff = tipoBuff;               
        }
    
    public void SerEquipado(Personagem p){
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
    }
    
        public void SerDesequipado(Personagem p){
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
    }
  }

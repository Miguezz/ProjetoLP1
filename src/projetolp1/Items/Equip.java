/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Items;
import projetolp1.Items.Equipamento.Armadura;
import projetolp1.Items.Equipamento.Armas.Arma;
import projetolp1.Items.Equipamento.Secundaria;

public class Equip {
		int elemento;
		public Armadura getArmor() {
        return armor;
    }
	
		public int getDefElemental(){
			if(armor == null)	{
				return 7;
			}
			return armor.getElemento();
		}

		public int getAtkElemental(){
			if(arma == null){
				return 7;
			}
			return arma.getElemento();
		}

    public int getDef(){
        int def = 0;
        if(this.armor != null ) def += this.armor.getDefArmadura();
        if(this.secundaria != null) def += this.secundaria.getBuffDef();
        return def;
    }
    
    public int getAtk(){
        int atk = 0;
        if(this.arma != null) atk += this.arma.getDanoArma();
        if(this.armor != null ) atk += this.armor.getAtkArmadura();
        if(this.secundaria != null) atk += this.secundaria.getBuffAtacar();
        return atk;
    }
    
    
    public void removeArmor(Inventario x){
        if(this.armor != null)x.add(this.armor);
        this.armor = null;
    }
    
    public Arma getArma() {
        return arma;
    }
    
    
    public void removeSecundaria(Inventario x){
        if(this.secundaria != null)x.add(this.secundaria);
        this.secundaria = null;
    }
    public void removeArma(Inventario x){
        if(this.arma != null)x.add(this.arma);
        this.arma = null;
    }
    

    public Secundaria getSecundaria() {
        return secundaria;
    }

    
    private Armadura armor;
    private Arma arma;
    private Secundaria secundaria;
    
    public void setGlobal(Item item, Inventario x){
        if(item instanceof Arma){
          setGlobal((Arma)item, x);
        }
        else if(item instanceof Armadura){
            setGlobal((Armadura)item, x);
        }
        else if(item instanceof Secundaria){
            setGlobal((Secundaria)item, x);
        }
        
        
        
    }
    
        public void setGlobal(Arma arma, Inventario x) {
        if(arma.getQtdMaos() == 2){
            removeSecundaria(x);
        }
        removeArma(x);
        this.arma = arma;
        x.remove(arma);
    }

public void setGlobal(Armadura armor, Inventario x) {
        removeArmor(x);
        this.armor = armor;
        x.remove(armor);
    }

 public void setGlobal(Secundaria secundaria, Inventario x) {
        if(arma.getQtdMaos() == 2){
        removeArma(x);
        }
        removeSecundaria(x);
        this.secundaria = secundaria;
        x.remove(secundaria);
    }
}

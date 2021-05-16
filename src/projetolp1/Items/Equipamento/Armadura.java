package projetolp1.Items.Equipamento;
import projetolp1.Items.Item;
public class Armadura extends Item {

 
private int defArmadura;
private int atkArmadura;
private int elemento;
  Armadura(String nome, String desc, int defArmadura, int elemento){
    super(nome, desc);
    this.defArmadura = defArmadura;
    
    this.atkArmadura = 0;
		this.elemento = elemento;
  }
  Armadura(String nome, String desc, int defArmadura, int atkArmadura, int elemento){
    super(nome, desc);
    this.defArmadura = defArmadura;
    
    this.atkArmadura = atkArmadura;
		this.elemento = elemento;
  }

	public int getElemento(){
		return this.elemento;
	}

  public int getDefArmadura(){
    return this.defArmadura;
  }

  public void setdefArmadura(int defArmadura){
    this.defArmadura = defArmadura;
  }

  public int getAtkArmadura() {
        return atkArmadura;
    }

    public void setAtkArmadura(int atkArmadura) {
        this.atkArmadura = atkArmadura;
    }
}

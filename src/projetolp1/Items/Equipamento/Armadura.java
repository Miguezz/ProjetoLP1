package projetolp1.Items.Equipamento;
import projetolp1.Items.Item;
public class Armadura extends Item {

 
private int defArmadura;
private int atkArmadura;
  Armadura(String nome, String desc, int defArmadura){
    super(nome, desc);
    this.defArmadura = defArmadura;
    
    this.atkArmadura = 0;
  }
  Armadura(String nome, String desc, int defArmadura, int atkArmadura){
    super(nome, desc);
    this.defArmadura = defArmadura;
    
    this.atkArmadura = atkArmadura;
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

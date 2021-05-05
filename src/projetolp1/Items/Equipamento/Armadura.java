package projetolp1.Items.Equipamento;
import projetolp1.Items.Item;
class Armadura extends Item {

private int defArmadura;

  Armadura(String nome, String desc, int defArmadura){
    super(nome, desc);
    this.defArmadura = defArmadura;
  }

  public int getDefArmadura(){
    return this.defArmadura;
  }
  public void setdefArmadura(int defArmadura){
    this.defArmadura = defArmadura;
  }
}
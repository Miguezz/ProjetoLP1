package projetolp1.Items.Equipamento;

public class ArmaduraDeMadeira extends Armadura{
  public ArmaduraDeMadeira(){
    super("Armadura de madeira", "Armadura feita de pedaços de madeira podre", 4, 2);
  }
  
  public ArmaduraDeMadeira(int elemento){
    super("Armadura de madeira", "Armadura feita de pedaços de madeira podre", 4, elemento);
  }
}

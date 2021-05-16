package projetolp1.Items.Equipamento.Armas;
import projetolp1.Items.Item;
public class Arma extends Item {
  private int range;
  private int danoArma;
  private int qtdMaos;
  private double modDanoQtdMaos;
	private int elemento; 

  Arma(String nome, String desc, int range, int danoArma, int qtdMaos, double modDanoQtdMaos, int elemento){
    super(nome, desc);
    this.range = range;
    this.danoArma = danoArma;
    this.qtdMaos = qtdMaos;
    this.modDanoQtdMaos = modDanoQtdMaos;
		this.elemento = elemento;
  }
  Arma(int range, int danoArma, int qtdMaos, double modDanoQtdMaos, int elemento){
    super();
    this.range = range;
    this.danoArma = danoArma;
    this.qtdMaos = qtdMaos;
    this.modDanoQtdMaos = modDanoQtdMaos;
		this.elemento = elemento;
  }
	public int getElemento(){
		return this.elemento;
	} 
		
  public int getRange(){
    return this.range;
  }
  public int getDanoArma(){
    return this.danoArma;
  }
  public int getQtdMaos(){
    return this.qtdMaos;
  }
  public double getModDanoQtdMaos(){
    return this.modDanoQtdMaos;
  }
  public void setRange(int valor){
    this.range = valor;
  }
  public void setDanoArma(int valor){
    this.danoArma = valor;
  }
  public void setQtdMaos(int valor){
    this.qtdMaos = valor;
  }
  public void setModDanoQtdMaos(float valor){
    this.modDanoQtdMaos = valor;
  }
}

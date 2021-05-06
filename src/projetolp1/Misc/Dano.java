package projetolp1.Misc;

public class Dano{
  private int tipo;
  private float valor;
  
  public Dano(int tipo, float valor){
    this.tipo = tipo;
    this.valor = valor;
  }
  public int getTipo(){
    return this.tipo; 
  }
  public float getValor(){
    return this.valor; 
  }
  public void setTipo(int tipo){
    this.tipo = tipo;
  }
  public void setValor(float valor){
    this.valor = valor;
  }
}
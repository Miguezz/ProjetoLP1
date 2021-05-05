package projetolp1.Misc;

public class Dano{
  private int tipo;
  private int valor;
  
  Dano(int tipo, int valor){
    this.tipo = tipo;
    this.valor = valor;
  }
  public int getTipo(){
    return this.tipo; 
  }
  public int getValor(){
    return this.valor; 
  }
  public void setTipo(int tipo){
    this.tipo = tipo;
  }
  public void setValor(int valor){
    this.valor = valor;
  }
}
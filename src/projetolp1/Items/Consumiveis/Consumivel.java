/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Items.Consumiveis;



import projetolp1.Items.Inventario;
import projetolp1.Items.Item;
import projetolp1.Principal.Personagem;
/**
 *
 * @author Batata
 */
public abstract class Consumivel extends Item{

    Consumivel(int qtd, Inventario x){
        super();
        this.quantidade = qtd;
        this.stack(x);
        x.add(this);
    }
    
    Consumivel(String descricao, int qtd, Inventario x){
        super(descricao);
        this.quantidade = qtd; 
        this.stack(x);
        x.add(this);
    }
    
    Consumivel(String nome, String descricao, int qtd,  Inventario x){
       super(nome, descricao);
        this.quantidade = qtd;
        this.stack(x);
        x.add(this);
    }

    
  private int quantidade;
  
  @Override
  public int getQuantidade(){
    return quantidade;
  }

  public void setQuantidade(int q){
    this.quantidade = q;
  }


  public int Consumir(int quant, Personagem p){
  if(quant <= quantidade){
  quantidade =  quantidade - quant;
  efeito(p);
  return quantidade;
         }else{ return -1;
    }
  

  
}

  public abstract int efeito(Personagem p);

  private void stack(Inventario x){
      int local = x.find(this);
      if(local >= 0){
        this.quantidade +=  x.get(local).getQuantidade();
        x.set(local, this);
        this.quantidade = 0;
      }
  }
  
  
}




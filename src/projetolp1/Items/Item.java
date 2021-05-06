/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Items;

/**
 *
 * @author Batata
 */
public class Item {
    
    private String nome;
    private String descricao;
    
   public Item(){
    this.nome = this.getClass().getName();
    }
    
   public Item(String descricao){
    this.nome = this.getClass().getName();
    this.descricao = descricao;
    }
    
    public Item(String nome, String descricao){
      this.nome = nome;
      this.descricao = descricao;
    }
   /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
    public int getQuantidade(){
      return 1;  
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1;

/**
 *
 * @author Batata
 */
public class Personagem {
    private String nome;
    private int vidaMaxima;
    private int danoRecebido; 
    private int manaAtual;
    private int manaGasta;
    private int defesa;
    private int status;
    private int qtdMovimento;
    private int posicaoNoMapa;
    // Equip equipamento -- talvez separar em slots? cabeca, armadura, botas.
    //ArrayList<item> Inventario = new ArrayList;
    // Dano dano;
    RacaBase  raca;
    ClasseMae classe;
    
    Personagem(String nome, ClasseMae classe, RacaBase raca){
      this.nome = nome;
      this.classe = classe;
      this.raca = raca;
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the vidaMaxima
     */
    public int getVidaMaxima() {
        return vidaMaxima;
    }

    /**
     * @param vidaMaxima the vidaMaxima to set
     */
    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    /**
     * @return the danoRecebido
     */
    public int getDanoRecebido() {
        return danoRecebido;
    }

    /**
     * @param danoRecebido the danoRecebido to set
     */
    public void setDanoRecebido(int danoRecebido) {
        this.danoRecebido = danoRecebido;
    }

    /**
     * @return the manaAtual
     */
    public int getManaAtual() {
        return manaAtual;
    }

    /**
     * @param manaAtual the manaAtual to set
     */
    public void setManaAtual(int manaAtual) {
        this.manaAtual = manaAtual;
    }

    /**
     * @return the manaGasta
     */
    public int getManaGasta() {
        return manaGasta;
    }

    /**
     * @param manaGasta the manaGasta to set
     */
    public void setManaGasta(int manaGasta) {
        this.manaGasta = manaGasta;
    }

    /**
     * @return the defesa
     */
    public int getDefesa() {
        return defesa;
    }

    /**
     * @param defesa the defesa to set
     */
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the qtdMovimento
     */
    public int getQtdMovimento() {
        return qtdMovimento;
    }

    /**
     * @param qtdMovimento the qtdMovimento to set
     */
    public void setQtdMovimento(int qtdMovimento) {
        this.qtdMovimento = qtdMovimento;
    }

    /**
     * @return the posicaoNoMapa
     */
    public int getPosicaoNoMapa() {
        return posicaoNoMapa;
    }

    /**
     * @param posicaoNoMapa the posicaoNoMapa to set
     */
    public void setPosicaoNoMapa(int posicaoNoMapa) {
        this.posicaoNoMapa = posicaoNoMapa;
    }
   

    }

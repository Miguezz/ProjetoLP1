/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Principal;

import projetolp1.Classes.*;
import projetolp1.Items.Equip;
import projetolp1.Misc.Status;
import projetolp1.Racas.*;
import java.io.Serializable;
import java.lang.Math;
import projetolp1.Misc.MultipDano;
import projetolp1.Mapa.BlocoMapa;
import projetolp1.Mapa.Mapas;
/**
 *
 * @author Batata
 */
public class Personagem implements Serializable{

    private String nome;
    private int vidaMaxima;
    private double danoRecebido; // vidaMaxima - danoRecebido = vidaAtual
    private int manaGasta;
    private int manaMaxima;
    private int danoBase;
    private int defesa;
    private Status status;
    private int qtdMovimento;
    private int posicaoNoMapa;
    private float modDano;
    private int shield;
    private Equip equipamento;
    private BlocoMapa blocoAtual;
    
    //Inventario Removido
    // Equip equipamento -- talvez separar em slots? cabeca, armadura, botas.
    private int dano;
    private RacaBase  raca;
    private int racaInt;
    private ClasseMae classe;
    
    Personagem(String nome, int classe, int raca){
      this.nome = nome;
      this.classe = this.getSetClasse(classe);
      this.raca = this.getSetRaca(raca);
      this.racaInt = raca;
      this.modDano = 1;
      this.danoBase = 5 + this.raca.getModDanoBase();
      this.defesa = 5 + this.raca.getModDefBase();
      this.manaMaxima = 50 + this.raca.getModManaMax();
      this.vidaMaxima = 100 + this.raca.getModVidaMax();
      this.shield = 0;
      this.danoRecebido = 0;
      this.equipamento = new Equip();
      this.status = new Status();
    }
    
    
    
    public int getRacaInt(){ // necessario para printar no mapa. Pode tirar dps qnd tiver na parte grafica
        return this.racaInt;
    }
    
    public BlocoMapa getBlocoMapa(){
        return this.blocoAtual;
    }
    
    public void setBlocoMapa(BlocoMapa bloco){
        this.blocoAtual = bloco;
    }
    
    public boolean movimentarPersonagem(Mapas mapa, int x, int y){
        BlocoMapa bAlvo = mapa.getBlocoPelaPos(x, y);
        if(mapa.getRangeEntreBlocos(this.blocoAtual, bAlvo) >= this.qtdMovimento){
            if(bAlvo.getOcupante() == null){
                bAlvo.setOcupante(this);
                this.blocoAtual.setOcupante(null);
                this.blocoAtual = bAlvo;
                return true;
            }
        }
        return false;
    }
    
     /**
     * @return the equipamento
     */
    public Equip getEquipamento() {
        return equipamento;
    }

    /**
     * @param equipamento the equipamento to set
     */
    public void setEquipamento(Equip equipamento) {
        this.equipamento = equipamento;
    }
    
    @Override
    public String toString(){
        return ("Nome: " + this.nome +
                "\nRaca " + this.raca.getClass().getSimpleName() + 
                "\nClasse: " + this.classe.getClass().getSimpleName() +
                "\nVida Max: " + this.vidaMaxima + 
                "\nVida Atual: " + (this.vidaMaxima - this.danoRecebido) +
                "\nMana Max: " + this.manaMaxima + 
                "\nMana Atual: " + (this.manaMaxima - this.manaGasta) +
                "\nDano: " + getDano() + 
                "\nDefesa: " + this.getEquipamento().getDef() +
                "\nShield: " + this.shield + "\n");
    }
    
    private RacaBase getSetRaca(int raca){
        switch(raca){
            case 0:
                return new Laponico(this);
            case 1:
                return new Anao(this);
            case 2:
                return new Dragonborn(this);
            case 3:
                return new Elfo(this);
            case 4:
                return new Orc(this);
            case 5:
                return new Tiefling(this);
      }
        
        return new Laponico(this);
    }
    
    private ClasseMae getSetClasse(int classe){
        switch(classe){
            case 0:
                return new Alquimista();
            case 1:
                return new Assassino();
            case 2:
                return new Bruxo();
            case 3:
                return new Cacador();
            case 4:
                return new Cavaleiro();
            case 5:
                return new Feiticeiro();
            case 6:
                return new Sacerdote();
      }
        
        return new Cavaleiro();
    }
    
    public RacaBase getRaca(){
        return raca;
    }
    
    public ClasseMae getClasse(){
        return this.classe;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @return the shield
     */
    public int getShield() {
        return shield;
    }

    /**
     * @param shield the shield to set
     */
    public void setShield(int shield) {
        this.shield = shield;
    }
    
    /**
     * @return the vidaMaxima
     */
    public int getVidaMaxima() {
        int vida=0;
        if (getStatus().isStatus(11)) vida += 5;
        return vidaMaxima + vida;
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
    public double getDanoRecebido() {
        return danoRecebido;
    }

    /**
     * @param danoRecebido the danoRecebido to set
     */
    
    public void addDanoRecebido(double danoRecebido) { // Usado para cura ou "dano normal" (sem atributos)
        if(getStatus().isStatus(8)){
            danoRecebido = 0;
            getStatus().cureStatus(8);
        }
        if(danoRecebido > 0 && getStatus().isStatus(9)){
            danoRecebido = Math.floor(danoRecebido/2);
        }
        if(getShield() > 0){
           if(getShield() >= danoRecebido ){
               setShield((int)Math.floor(getShield()-danoRecebido));
               danoRecebido = 0;
           }else{
               danoRecebido -= getShield();
               setShield(0);
           }
        }
        
        setDanoRecebido(getDanoRecebido() - danoRecebido);
        }
    
    
    public void setDanoRecebido(double danoRecebido){
        this.danoRecebido = danoRecebido;
        //if(this.doRecebido == this.getVidaMaxima()) kill
    }

    /**
     * @return the manaAtual
     */
    public int getManaGasta() {
        return manaGasta;
    }

    
    public int getMana(){
	    return this.manaMaxima - this.manaGasta;
    }

    /**
     * @param manaGasta the manaGasta to set
     */
    public void setManaGasta(int manaGasta) {
        this.manaGasta = manaGasta;
    }

    /**
     * @return the manaMaxima
     */
    public int getManaMaxima() {
        return manaMaxima;
    }

    /**
     * @param manaMaxima the manaMaxima to set
     */
    public void setManaMaxima(int manaMaxima) {
        this.manaMaxima = manaMaxima;
    }

    /**
     * @return the defesa
     */
    public int getDefesa() {
        int deftotal = this.defesa + this.equipamento.getDef();
               if (getStatus().isStatus(7)) deftotal += 20;
               if (getStatus().isStatus(10)) deftotal += 10;
               if (getStatus().isStatus(11)) deftotal += 5;
           return  deftotal;
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
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
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

   
    public float getDanoBase(){
      return this.modDano;
    }
    
    public void setDanoBase(float modDano){ // rever, setDanoBase deveria conter this.setDanoBase
      this.modDano = modDano;
    }
    
    public int getDano(){
        int dano=0;
        if (getStatus().isStatus(11)) dano += 5;
        return this.danoBase + this.equipamento.getAtk()+dano;
    }

    public void atacar(){
        
        
    }
    
    public void andar(){
        
        
    }
    
    public void usarhabilidade(){
        
        
    }
    
    public void endOfTurn(){
        this.getStatus().ReduzirTempoNoFimDoTurno();
        if(this.getStatus().isStatus(1)) this.addDanoRecebido(Math.ceil(5 * MultipDano.resultado(0, this.getEquipamento().getDefElemental())));
        if(this.getStatus().isStatus(6)) this.setDanoRecebido(this.getDanoRecebido() + 10);
        if(this.getStatus().isStatus(11)) this.setManaGasta(this.getMana() - 5);
    }
    
}

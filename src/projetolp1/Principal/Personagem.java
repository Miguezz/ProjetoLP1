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
    private int racaInt, classeInt;
    private ClasseMae classe;
    private String time;
    public Personagem(String nome, int classe, int raca){
      this.nome = nome;
      this.classe = this.getSetClasse(classe);
      this.raca = this.getSetRaca(raca);
      this.racaInt = raca;
      this.classeInt = classe;
      this.modDano = 1;
      this.danoBase = 10 + this.raca.getModDanoBase();
      this.defesa = 5 + this.raca.getModDefBase();
      this.manaMaxima = 50 + this.raca.getModManaMax();
      this.vidaMaxima = 100 + this.raca.getModVidaMax();
      this.shield = 0;
      this.danoRecebido = 0;
      this.equipamento = new Equip();
      this.status = new Status();
      this.qtdMovimento = 1;
      
    }
    public void setTime(String t){
        this.time = t;
    }
    public String getTime(){
        return this.time;
    }
   
    public void setMovimento(int mov){
        this.qtdMovimento = mov;
    }
    
    public void setAtributos(int raca){
        switch(raca){
            case 0: // laponico
                this.raca.modAtributo(0); // Vida
                this.raca.modAtributo(1); // Mana
                break;
            case 1:// anao
                this.raca.modAtributo(0); // Vida
                this.raca.modAtributo(2); // Defesa
                break;
            case 3: // dragonborn
                this.raca.modAtributo(2); // Def
                this.raca.modAtributo(3); // Dano
                break;
            case 4: // elfo
                this.raca.modAtributo(1); // Mana
                this.raca.modAtributo(1); // Mana
                break;
            case 5: // orc
                this.raca.modAtributo(0); // Vida
                this.raca.modAtributo(0); // Vida
                break;
            case 6: // tiefling
                this.raca.modAtributo(1); // Mana
                this.raca.modAtributo(3); // Dano
                break;
        }
    }
    
    public String getRacaStr(){
        switch(this.racaInt){
            case 0:
                return "Laponico";
            case 1:
                return "Anao";
            case 2:
                return "Dragonborn";
            case 3:
                return "Elfo";
            case 4:
                return "Orc";
            case 5:
                return "Tiefling";
      }
        return "None";
    }
    public String getClasseStr(){
        switch(this.classeInt){
            case 0:
                return "Alquimista";
            case 1:
                return "Assassino";
            case 2:
                return "Bruxo";
            case 3:
                return "Cacador";
            case 4:
                return "Cavaleiro";
            case 5:
                return "Feiticeiro";
            case 6:
                return "Sacerdote";
      }
        return "None";
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
    
    public boolean movimentarPersonagem(BlocoMapa bAlvo, User u){
        if(bAlvo == null) return false;
        if(bAlvo.getRangeEntreBlocos(this.blocoAtual) <= this.qtdMovimento){
            System.out.println(bAlvo.getRangeEntreBlocos(this.blocoAtual));
            if(bAlvo.getOcupante() == null){
                bAlvo.setOcupante(this);
                this.blocoAtual.setOcupante(null);
                this.blocoAtual = bAlvo;
                u.endOfTurn();
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
        int [] pos = {-10,-10};
        if(this.blocoAtual != null){
            pos = this.blocoAtual.getPosicao();
        }
        
        return ("Nome: " + this.nome +
                "\nRaca " + this.raca.getClass().getSimpleName() + 
                "\nClasse: " + this.classe.getClass().getSimpleName() +
                "\nVida Max: " + this.vidaMaxima + 
                "\nVida Atual: " + (this.vidaMaxima - this.danoRecebido) +
                "\nMana Max: " + this.manaMaxima + 
                "\nMana Atual: " + (this.manaMaxima - this.manaGasta) +
                "\nDano: " + this.getDano() + 
                "\nDefesa: " + this.getDefesa() +
                "\nShield: " + this.shield + 
                "\nPosicao: " + pos[0] + " " + pos[1] + "\n");
    }
    public void setRaca(int raca){
        this.raca = getSetRaca(raca);
    }
    public void setClasse(int classe){
        this.classe = getSetClasse(classe);
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    private RacaBase getSetRaca(int raca){
        switch(raca){
            case 0:
                return new Laponico(this);
            case 1:
                return new Anao(this);
            case 2:
                this.setMovimento(2);
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
        if(this.shield == 0 && this.getStatus().isStatus(13)){
            this.getStatus().cureStatus(13);
        }
    }
    
    /**
     * @return the vidaMaxima
     */
    public int getVidaMaxima() {
        int vida=0;
        if (getStatus().isStatus(11)) vida += 5;
        return vidaMaxima + vida + this.getEquipamento().getVida();
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
        
        setDanoRecebido(getDanoRecebido() + danoRecebido);
        }
    
    
    public void setDanoRecebido(double danoRecebido){
        this.danoRecebido = danoRecebido;
        if(this.danoRecebido == 0 && this.getStatus().isStatus(13)) {
            this.getStatus().cureStatus(13);
                this.setShield(0);
        }
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
        return manaMaxima + this.getEquipamento().getMana();
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
           return deftotal;
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
        int dano = this.danoBase + this.equipamento.getAtk();
        if(getStatus().isStatus(12)){
            dano = dano*2;
            getStatus().cureStatus(12);
        }
        if (getStatus().isStatus(11)) dano += 5;
        return dano;
        
    }
    public int seeDano(){
        int dano = this.danoBase + this.equipamento.getAtk();
        if (getStatus().isStatus(11)) dano += 5;
        return this.danoBase + this.equipamento.getAtk()+dano;
}

    public boolean atacar(BlocoMapa selfBloco, Personagem target, User dono){
        if(selfBloco.getRangeEntreBlocos(target.getBlocoMapa()) <= this.getEquipamento().getRangeArma()){
            int elemento = this.getEquipamento().getAtkElemental(); // elemento de acordo com a arma
            double formulaDano = getDano();
            formulaDano = MultipDano.getDanoPelaFormula(target, formulaDano, elemento, false);
            target.addDanoRecebido(formulaDano);
            System.out.println("DANO: " + formulaDano);
            System.out.println(this.nome + " atacou " + target.getNome());
            System.out.println(target);
            dono.endOfTurn();
            
            return true;
        }
        return false;
    }

    
    public boolean usarhabilidade(int habilidade, BlocoMapa alvo, Personagem target){
        // 1 - Ataque
        // 2 - Def
        // 3 - Utility
        // 4 - Ultimate
            switch(habilidade){
            case 1:
                if(this.getClasse().habDano(alvo, this, target)){
                    System.out.println(this.nome + " usou habilidade dano em " + target.getNome());
                    System.out.println(this);
                    System.out.println(target);
                    return true;
                }
                System.out.println(this.nome + " nao conseguiu usar a habilidade dano");
                return false;
            case 2:
                if(this.getClasse().habDef(alvo, this, target)){
                    System.out.println(this.nome + " usou habilidade defesa em " + target.getNome());
                    System.out.println(this);
                    if(this != target) System.out.println(target);
                    return true;
                }
                System.out.println(this.nome + " nao conseguiu usar a habilidade defesa");
                return false;
            case 3:
                if(this.getRaca().HabUtility(alvo, this, target)){
                    System.out.println(this.nome + " usou habilidade utility em " + target.getNome());
                    System.out.println(this);
                    if(this != target) System.out.println(target);
                    return true;
                }
                System.out.println(this.nome + " nao conseguiu usar a habilidade utility");
                return false;
            case 4:
                if(this.getClasse().ultimate(alvo, this, target)){
                    System.out.println(this.nome + " usou habilidade ultimate em " + target.getNome());
                    System.out.println(this);
                    System.out.println(target);
                    return true;
                }
                System.out.println(this.nome + " nao conseguiu usar a habilidade ultimate");
                return false;
            }
        return false;
    }
    
    public void endOfTurn(){
        this.getStatus().ReduzirTempoNoFimDoTurno();
        if(this.getStatus().isStatus(1)) this.addDanoRecebido(Math.ceil(5 * MultipDano.resultado(0, this.getEquipamento().getDefElemental())));
        if(this.getStatus().isStatus(6)) this.setDanoRecebido(this.getDanoRecebido() + 10);
        if(this.getStatus().isStatus(11)) this.setManaGasta(this.getMana() - 5);
    }
    
}

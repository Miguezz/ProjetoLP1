/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Principal;
import projetolp1.Misc.Rand;
/**
 *
 * @author FelipeBrasileiro
 */
public class Jogo {
    
    User u1, u2;
    int qtdTurno;
    int turnoAtual;
    
    public Jogo(User u1, User u2, int qtdTurno){
        this.u1 = u1;
        this.u2 = u2;
        this.qtdTurno = qtdTurno;
        this.turnoAtual = 0;
    }
    
    public int sortearJogador(){
        int valor;
        if(Rand.New() % 2 == 0){
            u1.setVez(true);
            u2.setVez(false);
            valor = 1;
        }else{
            u2.setVez(true);
            u1.setVez(false);
            valor = 2;
        }
        return valor;
    }
    
    private boolean checkTurno(){
        if(this.turnoAtual >= this.qtdTurno){
            return true;
        }
        return false;
    }
    
    public int getRoundAtual(){
        return this.turnoAtual;
    }
    public int getRounds(){
        return this.qtdTurno;
    }
    
    public boolean mudaTurno(){
        this.turnoAtual++;
        System.out.println("Turno: " + this.turnoAtual);
        if(checkTurno()){
            System.out.println("CABO");
            return true;
        }
        return false;
    }
}

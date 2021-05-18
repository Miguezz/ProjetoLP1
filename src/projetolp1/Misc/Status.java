/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.Misc;

import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Batata
 */
public class Status implements Serializable{
      
    private ArrayList<StatusUnit> statusPlayer = new ArrayList<StatusUnit>(); 

    /*
    Status-
    1-Queimando(dano 5 por turno)
    2-Stun(Não pode fazer nada, 1 turno)
    3-Congelar(um Stun com outro nome)
    4-Paralisia(um stun com outro nome)
    5-Armadilha(impede de se mover por 2 turnos)
    6-Maldicao (dano 10 dark 3 turnos)
    7-status do alquimista, defensivo (2 turnos, 20 armor)
    8-status do assassino, defensivo ( 2 turnos, 1 hit)
    9-status do cavaleiro, defensivo (2 turnos, 1/2 dano)
    10-status da skill utility orc (3 turnos, +10 Defesa)
    11-Status da skill utility laponico (5 de mana por turno, +5 de dano +5 de vida +5 de defesa)
    13-Escudo do bruxo, remove com vida cheia, ou quando acaba o shield
    */
    
    
    
    /*Essa função vai servir para retornar 0/1 dependendo do status e situação
    ex: Situação 1, final do turno. Status 1, envenenado.  Retorna 1, ele toma dano
    ex2: Situação 2, Quero realizar uma ação, Petrificado, Retorna 1, ele não pode mover
    */
    public int addStatus(int tipo, int duracao){
        StatusUnit z = new StatusUnit( tipo , duracao); 
        statusPlayer.add(z);
        return 1;
    }
    
    public boolean isStatus(int tipo){
        for(int cont = 0; cont < statusPlayer.size() ; cont++){
            if (statusPlayer.get(cont).getTipo() == tipo) return true;
        }
        return false;
    }
    
    public void ReduzirTempoNoFimDoTurno(){
     for(int cont = 0; cont < statusPlayer.size() ; cont++){ 		      
          statusPlayer.get(cont).decTempo();
            if(statusPlayer.get(cont).getTempo() == 0){
                statusPlayer.remove(cont); cont--;
            }
          }
      }
    public int cureStatus(int tipo){
        int removidos = 0;
         for(int cont = 0; cont < statusPlayer.size() ; cont++){ 		      
            if(statusPlayer.get(cont).getTipo() == tipo){
                statusPlayer.remove(cont); cont--; removidos++;
                  }
          }
         return removidos;
      }
    
   }
    
     
    

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
    
    */
    
    
    
    /*Essa função vai servir para retornar 0/1 dependendo do status e situação
    ex: Situação 1, final do turno. Status 1, envenenado.  Retorna 1, ele toma dano
    ex2: Situação 2, Quero realizar uma ação, Petrificado, Retorna 1, ele não pode mover
    */
    public int addStatus(int a, int b){
        StatusUnit z = new StatusUnit(a,b); 
        statusPlayer.add(z);
        return 1;
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
    
     
    

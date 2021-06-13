/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import projetolp1.Mapa.BlocoMapa;
import projetolp1.Principal.Personagem;
import projetolp1.Principal.User;

/**
 *
 * @author FelipeBrasileiro
 */
public class Mapa10x10Controller extends MapaGUI implements Initializable{
    
    User u, u2;
    
    public void setUsers(User u, User u2){
        System.out.println("SET USERS");
        this.u = u;
        this.u2 = u2;
        addPersonagens();
        updateImages();
    }
    
    @FXML 
    public void initialize(URL url, ResourceBundle rb){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                System.out.println(i + " " + j);
                bm[i][j] = new BlocoMapa(j, i);
                configurarMapa(bm[i][j], i, j);
                paneArray[i][j] = new Pane();
                background[i][j] = new Pane();
//                setImage(bm[i][j]);
                mapa.add(paneArray[i][j], i, j, 1, 1);
                mapaBackground.add(background[i][j], i, j, 1, 1);
            }
        }
    }
    
    private void updateImages(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                setImage(bm[i][j]);
            }
        }
    }
    
    @FXML
    private void addPersonagens(){
        int i = 1;
        String path;
        String classe;
        String raca;
        for(Personagem p : this.u.getParty()){
            classe = p.getClasseStr();
            raca = p.getRacaStr();
            path = "/resources/" + raca + "/" + classe + "/"+raca+classe+"_0.png";
            this.bm[i][1].setOcupante(p);
            this.bm[i][1].setFg(path);
            i++;
        }
        i = 1;
        for(Personagem p : this.u2.getParty()){
            classe = p.getClasseStr();
            raca = p.getRacaStr();
            path = "/resources/" + raca + "/" + classe + "/"+raca+classe+"_0.png";
            this.bm[i][8].setOcupante(p);
            this.bm[i][8].setFg(path);
            i++;
        }
    }
    
    
}

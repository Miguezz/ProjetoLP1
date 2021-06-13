/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.GUI;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import projetolp1.Mapa.BlocoMapa;
import projetolp1.Principal.Personagem;
import projetolp1.Principal.User;

/**
 *
 * @author FelipeBrasileiro
 */
public class MapaGUI extends Stager{
    @FXML
    GridPane mapa, mapaBackground;
    
    @FXML
    Pane[][] paneArray = new Pane[10][10];
    Pane[][] background = new Pane[10][10];
    
    BlocoMapa[][] bm = new BlocoMapa[10][10];

    @FXML
    protected void configurarMapa(BlocoMapa bm, int x, int y){ // Padrao 10x10
        if(y == 0 || x == 0 || y == 9 || x == 9){
            bm.setBg("resources/Mapa/PedraGrama.png");
            bm.setEstilo("-fx-background-size: 130;");
        }
        else if((y == 4 || y == 5)){
            if(x == 2 || x == 7){
                bm.setBg("resources/Mapa/Terra.png");
            }else{
                bm.setBg("resources/Mapa/Agua.png");
                bm.setEstilo("-fx-background-size: 58;-fx-background-position: 0;");
            }
            
        }else{
            bm.setBg("resources/Mapa/Grama.png");
            bm.setEstilo("-fx-background-size: 58;-fx-background-position: 0;");
        }
    }
    
    @FXML
    public void setImage(BlocoMapa bm){
        int[] pos = bm.getPosicao();
        this.background[pos[1]][pos[0]].setStyle(
//                "-fx-background-color: red;"
                "-fx-background-size: 130;"
                +"-fx-background-image: url(\""+ bm.getBg() +"\");" 
                +"-fx-background-position: -35,0;" + bm.getEstilo()
        );
        if(bm.getOcupante() instanceof Personagem){
            System.out.println("Personagem");
            this.paneArray[pos[1]][pos[0]].setStyle(
                "-fx-background-size: 130;"
                +"-fx-background-image: url(\""+ bm.getFg() +"\");" 
                +"-fx-background-position: -35,0;"
            );
        }
        
    }
}

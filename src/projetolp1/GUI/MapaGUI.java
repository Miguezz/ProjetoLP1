/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import projetolp1.Mapa.BlocoMapa;
import projetolp1.Mapa.Obstaculo;
import projetolp1.Principal.Personagem;
import projetolp1.Principal.User;

/**
 *
 * @author FelipeBrasileiro
 */
public class MapaGUI extends Stager{
    @FXML
    GridPane mapa, mapaBackground, mapaForeground;
    
    @FXML
    Pane[][] paneArray = new Pane[10][10];
    Pane[][] background = new Pane[10][10];
    Pane[][] foreground = new Pane[10][10];
    //0 = grama.png
    //1 = pedragrama.png
    //2 = terra.png
    //3 = pedraterra.png
    //4 = areia.png
    //5 = cactoareia.png
    //6 = agua.png
    //7 = pedraareia
    int[][] mapaLaponia={{1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,1},  
                        {1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,1},
                        {1,6,2,6,6,6,6,2,6,1},
                        {1,6,2,6,6,6,6,2,6,1},
                        {1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1}};
    
    int[][] mapaDeserto={{4,4,4,4,4,4,4,4,4,4},
                        {4,5,4,4,4,4,4,4,5,4},  
                        {4,4,4,4,4,4,4,4,4,4},
                        {4,7,7,4,6,6,7,4,4,7},
                        {4,4,4,4,6,6,4,4,4,4},
                        {4,4,4,4,6,6,4,4,4,4},
                        {4,7,7,4,6,6,4,7,7,4},
                        {4,4,4,4,4,4,4,4,4,4},
                        {4,5,4,4,4,4,4,4,5,4},
                        {4,4,4,4,4,4,4,4,4,4}};
    
    int[][] mapaValePedra={{3,2,2,2,2,2,2,2,2,3},
                            {3,2,2,2,3,3,2,2,2,3},
                            {3,3,3,2,2,2,2,3,3,3},
                            {3,3,3,2,2,2,2,3,3,3},
                            {3,2,2,2,6,6,2,2,2,3},
                            {3,2,2,2,6,6,2,2,2,3},
                            {3,3,3,2,2,2,2,3,3,3},
                            {3,3,3,2,2,2,2,3,3,3},
                            {3,2,2,2,3,3,2,2,2,3},
                            {3,2,2,2,2,2,2,2,2,3}};
    
    BlocoMapa[][] bm = new BlocoMapa[10][10];
    
    @FXML
    protected void configurarMapa(BlocoMapa bm, int x, int y, int[][] mapa){ // Padrao 10x10
        switch(mapa[x][y]){
            case 0:
                bm.setBg("resources/Mapa/Grama.png");
                bm.setEstilo("-fx-background-size: 53;-fx-background-position: center; -fx-background-repeat: no-repeat;");
                break;
            case 1:
                bm.setOcupante(new Obstaculo());
                bm.setBg("resources/Mapa/PedraGrama.png");
                bm.setEstilo("-fx-background-size: 130;");
                break;
            case 2:
                bm.setBg("resources/Mapa/Terra.png");
                break;
            case 3:
                bm.setOcupante(new Obstaculo());
                bm.setBg("resources/Mapa/TerraPedra.png");
                bm.setEstilo("-fx-background-size: 53;-fx-background-position: center; -fx-background-repeat: no-repeat;");
                break;
            case 4:
                bm.setBg("resources/Mapa/Areia.png");
                bm.setEstilo("-fx-background-size: 53;-fx-background-position: center; -fx-background-repeat: no-repeat;");
                break;
            case 5:
                bm.setOcupante(new Obstaculo());
                bm.setBg("resources/Mapa/CactoAreia.png");
                bm.setEstilo("-fx-background-size: 53;-fx-background-position: center; -fx-background-repeat: no-repeat;");
                break;
            case 6:
                bm.setOcupante(new Obstaculo());
                bm.setBg("resources/Mapa/Agua.png");
                bm.setEstilo("-fx-background-size: 53;-fx-background-position: center; -fx-background-repeat: no-repeat;");
                break;
            case 7:
                bm.setOcupante(new Obstaculo());
                bm.setBg("resources/Mapa/PedraAreia.png");
                bm.setEstilo("-fx-background-size: 53;-fx-background-position: center; -fx-background-repeat: no-repeat;");
                break;
        }

    }
    
    @FXML
    public void setImage(BlocoMapa bm){
        int[] pos = bm.getPosicao();
        this.background[pos[0]][pos[1]].setStyle(
//                "-fx-background-color: red;"
                "-fx-background-size: 130;"
                +"-fx-background-image: url(\""+ bm.getBg() +"\");" 
                +"-fx-background-position: -35,0;" + bm.getEstilo()
        );
        if(bm.getOcupante() instanceof Personagem){
            this.paneArray[pos[0]][pos[1]].setStyle(
                "-fx-background-size: 130;"
                +"-fx-background-image: url(\"" + bm.getFg() + "\");" 
                +"-fx-background-position: -35,0;"
                +"-fx-border-color:" + ((Personagem)bm.getOcupante()).getTime() + ";"
            );
        }else{
            this.paneArray[pos[0]][pos[1]].setStyle("");
        }
        
    }
    
    
}

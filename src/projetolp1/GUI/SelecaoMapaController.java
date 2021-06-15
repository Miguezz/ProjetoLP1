/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import projetolp1.Principal.Personagem;
import projetolp1.Principal.User;

/**
 *
 * @author FelipeBrasileiro
 */
public class SelecaoMapaController extends Stager implements Initializable{
    @FXML
    Button btnMapaLaponia, btnMapaDeserto, btnMapaValePedra;
            
    @FXML
    Pane pMapaLaponia, pMapaDeserto, pMapaValePedra;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.pMapaLaponia.setStyle("-fx-background-size: 275;"
                + "-fx-background-image: url(\"resources/Laponia.png\");"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat;");
        this.pMapaDeserto.setStyle("-fx-background-size: 275;"
                + "-fx-background-image: url(\"resources/Deserto.png\");"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat;");
        this.pMapaValePedra.setStyle("-fx-background-size: 275;"
                + "-fx-background-image: url(\"resources/ValePedra.png\");"
                + "-fx-background-position: center;"
                + "-fx-background-repeat: no-repeat;");
    }
    User u1, u2;
    public void setUsers(User u1, User u2){
        this.u1 = u1;
        this.u2 = u2;
    }
    @FXML
    private void setMapa(int mapa) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent)loader.load(getClass().getResource("fxml/Mapa10x10.fxml").openStream());
        Mapa10x10Controller mpc = loader.getController();
        mpc.setStage(this.getStage());
        mpc.setUsers(this.u1, this.u2, mapa);
        Scene sc = new Scene(root);
        sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
        this.getStage().setScene(sc);
        this.getStage().show();
    }
    
    @FXML
    private void onClick(ActionEvent event) throws Exception{
           
        if(event.getSource() == btnMapaLaponia){
            setMapa(1);
        }else if(event.getSource() == btnMapaDeserto){
            setMapa(2);
        }else if(event.getSource() == btnMapaValePedra){
            setMapa(3);
        }
    }
    
}

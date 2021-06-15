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
import javafx.scene.control.Label;


/**
 *
 * @author felip
 */


public class LojaController extends Stager implements Initializable {

    @FXML
    private Button Voltar, ComprarU1, ComprarU2;
    
    @FXML
    private Label LapaCoinU1, LapaCoinU2, VenderJogador;

    private void acaoClick(ActionEvent event) throws Exception {
        
        if (event.getSource() == Voltar) {
            System.out.println("Voltando para o menu");
            FXMLLoader loader = new FXMLLoader();
            Parent root = (Parent)loader.load(getClass().getResource("fxml/CriacaoUsuario.fxml").openStream());
            CriacaoUsuarioController cuc = loader.getController();
            cuc.setStage(this.getStage());
            Scene sc = new Scene(root);
            sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
            this.getStage().setScene(sc);
            this.getStage().show();
        }else if (event.getSource() == ComprarU1){
            System.out.println("Usuario 1 comprou 1 item");
        }else if (event.getSource() == ComprarU2){
            System.out.println("Usuario 2 comprou 1 item");
        }

    
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.GUI;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author FelipeBrasileiro
 */
public class MenuPrincipalPaneController extends Stager implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    @FXML
    private Button btnNovoJogo;

    @FXML
    private Button btnCarregarJogo;
    
    @FXML
    private Button Tutorial;

    @FXML
    private AnchorPane panePrincipal;
    
    @FXML
    private Button btnSair;

    @FXML
    private void acaoClick(ActionEvent event) throws Exception {
        if (event.getSource() == btnNovoJogo) {

           FXMLLoader loader = new FXMLLoader();
           Parent root = (Parent)loader.load(getClass().getResource("fxml/CriacaoUsuario.fxml").openStream());
           CriacaoUsuarioController cuc = loader.getController();
           cuc.setStage(this.getStage());
           Scene sc = new Scene(root);
           sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
           this.getStage().setScene(sc);
           this.getStage().show();
            
            
        } else if (event.getSource() == btnCarregarJogo) {
            System.out.println("Carrega Jogo");
            
        }else if (event.getSource() == Tutorial) {
            System.out.println("Click");
           FXMLLoader loader = new FXMLLoader();
           Parent root = (Parent)loader.load(getClass().getResource("fxml/Tutorial.fxml").openStream());
           TutorialController tc = loader.getController();
           tc.setStage(this.getStage());
           Scene sc = new Scene(root);
           sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
           this.getStage().setScene(sc);
           this.getStage().show();
        }else if (event.getSource() == btnSair) {
            Stage stage = (Stage) btnSair.getScene().getWindow();
            stage.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

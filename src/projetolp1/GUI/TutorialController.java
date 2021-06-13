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
 *
 * @author felip
 */
public class TutorialController implements Initializable {
    
    @FXML
    private Button MenuButton;
    
    
    
    private void acaoClick(ActionEvent event) throws Exception {
        if (event.getSource() == MenuButton) {
            System.out.println("Voltando para o menu");
       System.out.println("Novo Jogo");
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent)loader.load(getClass().getResource("fxml/MenuPrincipalPane.fxml").openStream());
        MenuPrincipalPaneController mpp = loader.getController();
        mpp.setStage(this.getStage());
        Scene sc = new Scene(root);
        sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
        this.getStage().setScene(sc);
        this.getStage().show();
        } else if (event.getSource() == proximo) {
            System.out.println("Passando a pagina");
        }else if (event.getSource() == anterior) {
            System.out.println("Voltando a pagina");
        }

    }

   
    
    
}

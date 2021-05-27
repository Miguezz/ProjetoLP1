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
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author FelipeBrasileiro
 */
public class MenuPrincipalPaneController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private void acaoClick(ActionEvent event) {
        System.out.println("Ola Mundo!");
        File file = new File("src/resources/");
        for (String fileNames : file.list())
            System.out.println(fileNames);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

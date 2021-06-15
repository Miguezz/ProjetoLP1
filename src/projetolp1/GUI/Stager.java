/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.GUI;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 *
 * @author FelipeBrasileiro
 */
public class Stager {
    @FXML
    private Stage mStage;
    public void setStage(Stage mStage){
        this.mStage = mStage;
    }
    public Stage getStage(){
        return this.mStage;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolp1.GUI;
import projetolp1.Principal.User;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import projetolp1.Principal.Personagem;

/**
 *
 * @author FelipeBrasileiro
 */
public class CriacaoUsuarioController extends Stager implements Initializable {
    
//    @FXML
//    private Canvas canvas;
//    
    @FXML
    List<Label> labelListNRCJ1, labelListNRCJ2;
    
    @FXML
    List<Pane> paneListJ1, paneListJ2;
    
    User u1, u2;
    public void setUsers(User u1, User u2){
        this.u1 = u1;
        this.u2 = u2;
        System.out.println(u1.getParty().get(0).getNome());
        int i =0;
        if(u1.getParty().size() > 0){
            System.out.println("AAA");
            for(Personagem p : u1.getParty()){
                fillPane(1, p, i);
                i+=3;
            }
        }
        i = 0;
        if(u2.getParty().size() > 0){
            for(Personagem p : u1.getParty()){
                fillPane(2, p, i);
                i+=3;
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    private void fillPane(int user, Personagem p, int index){
        int pos = index*3;
        if(user == 1){
            this.labelListNRCJ1.get(pos).setText(p.getNome());
            this.labelListNRCJ1.get(pos+1).setText(p.getClasseStr());
            this.labelListNRCJ1.get(pos+2).setText(p.getRacaStr());
        }
        else if(user == 2){
            this.labelListNRCJ2.get(pos).setText(p.getNome());
            this.labelListNRCJ2.get(pos+1).setText(p.getClasseStr());
            this.labelListNRCJ2.get(pos+2).setText(p.getRacaStr());
        }
        
    }
    
    @FXML
    private void selecionarPersonagem(User u, Personagem p, int index, boolean replace, User u2, int ord) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent)loader.load(getClass().getResource("fxml/SelecaoPersonagem.fxml").openStream());
        SelecaoPersonagensController spc = loader.getController();
        spc.setStage(this.getStage());
        spc.setUser(u, index, replace, u2, ord);
        spc.setPersonagem(p, p.getNome());
        Scene sc = new Scene(root);
        sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
        this.getStage().setScene(sc);
        this.getStage().show();
    }
    
    @FXML
    private void btnClick(ActionEvent event) throws Exception {
        // Inicia o jogo
    }
    
    @FXML
    private void acaoClickJ1(MouseEvent event) throws Exception {
        int i = 0;
        for(Pane pa : this.paneListJ1){
            if(event.getSource() == pa){
                Personagem p = new Personagem("Personagem " + (i+1), 0, 0);
                this.selecionarPersonagem(this.u1, p, i, true, this.u2, 1);
                System.out.println(i);
                return;
            }
            i++;
        }
    }
    @FXML
    private void acaoClickJ2(MouseEvent event) throws Exception {
        int i = 0;
        for(Pane pa : this.paneListJ2){
            if(event.getSource() == pa){
                Personagem p = new Personagem("Personagem " + i+1, 0, 0);
                this.selecionarPersonagem(this.u2, p, i, true, this.u1, 2);
                System.out.println(i);
                return;
            }
            i++;
        }
    }
}

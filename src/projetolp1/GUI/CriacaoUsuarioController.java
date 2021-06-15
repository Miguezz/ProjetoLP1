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
import javafx.scene.control.TextField;
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
    List<Pane> paneListJ1, paneListJ2, paneListCabecasJ1, paneListCabecasJ2;
    
    @FXML
    Button btnContinuar, btnLoja, btnInventario, btnMenu;
    
    @FXML
    TextField nomeUsuario1, nomeUsuario2;
    
    User u1, u2;
    public void setUsers(User u1, User u2){
        this.u1 = u1;
        this.u2 = u2;
        if(u1 != null){
            nomeUsuario1.setText(this.u1.getName());
        }
        if(u2 != null){
            nomeUsuario2.setText(this.u2.getName());
        }
        int i =0;
        if(u1.getParty().size() > 0){
            for(Personagem p : u1.getParty()){
                fillPane(1, p, i);
                i+=3;
            }
        }
        i = 0;
        if(u2.getParty().size() > 0){
            for(Personagem p : u2.getParty()){
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
        System.out.println("fillPane");
        System.out.println(p);
        if(user == 1){
            if(index == 0){
                this.paneListCabecasJ1.get(index).setStyle(
                        "-fx-border-color: #000000;"
                        +"-fx-border-radius: 10;"
                        +"-fx-background-radius: 10;"
                        +"-fx-background-size: 200;"
                        +"-fx-background-position: -63,0;"
                        + "-fx-background-image: url(\"resources/Cabecas/Cabeca" + p.getRacaStr() + ".png\")");
            }
            else{
                this.paneListCabecasJ1.get(index/3).setStyle(
                        "-fx-border-color: #000000;"
                        +"-fx-border-radius: 10;"
                        +"-fx-background-radius: 10;"
                        +"-fx-background-size: 200;"
                        +"-fx-background-position: -63,0;"
                        + "-fx-background-image: url(\"resources/Cabecas/Cabeca" + p.getRacaStr() + ".png\")");
            }
                
            this.labelListNRCJ1.get(index).setText(p.getNome());
            this.labelListNRCJ1.get(index+1).setText(p.getClasseStr());
            this.labelListNRCJ1.get(index+2).setText(p.getRacaStr());
        }
        else if(user == 2){
            if(index == 0){
                this.paneListCabecasJ2.get(index).setStyle(
                        "-fx-border-color: #000000;"
                        +"-fx-border-radius: 10;"
                        +"-fx-background-radius: 10;"
                        +"-fx-background-size: 200;"
                        +"-fx-background-position: -63,0;"
                        + "-fx-background-image: url(\"resources/Cabecas/Cabeca" + p.getRacaStr() + ".png\")");
            }
            else{
                this.paneListCabecasJ2.get(index/3).setStyle(
                        "-fx-border-color: #000000;"
                        +"-fx-border-radius: 10;"
                        +"-fx-background-radius: 10;"
                        +"-fx-background-size: 200;"
                        +"-fx-background-position: -63,0;"
                        + "-fx-background-image: url(\"resources/Cabecas/Cabeca" + p.getRacaStr() + ".png\")");
            }
            this.labelListNRCJ2.get(index).setText(p.getNome());
            this.labelListNRCJ2.get(index+1).setText(p.getClasseStr());
            this.labelListNRCJ2.get(index+2).setText(p.getRacaStr());
        }
    }
    
    @FXML
    private void selecionarPersonagem(User u, String nome, int index, boolean replace, User u2, int ord) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent)loader.load(getClass().getResource("fxml/SelecaoPersonagem.fxml").openStream());
        SelecaoPersonagensController spc = loader.getController();
        spc.setStage(this.getStage());
        spc.setUser(u, index, replace, u2, ord);
        spc.setPersonagem(nome);
        Scene sc = new Scene(root);
        sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
        this.getStage().setScene(sc);
        this.getStage().show();
    }
    
    @FXML
    private void setNomeUsuarios(){
        String nome1;
        String nome2;
        if((nome1 = this.nomeUsuario1.getText()) != null){
            this.u1.setName(nome1);
        }else{
            this.u1.setName("Jogador 1");
        }
        if((nome2 = this.nomeUsuario2.getText()) != null){
            this.u2.setName(nome2);
        }else{
            this.u2.setName("Jogador 2");
        }
    }
    
    @FXML
    private void btnClick(ActionEvent event) throws Exception {
        // Inicia o jogo
        if(event.getSource() == btnContinuar){
            setNomeUsuarios();
            FXMLLoader loader = new FXMLLoader();
            Parent root = (Parent)loader.load(getClass().getResource("fxml/SelecaoMapa.fxml").openStream());
            System.out.println("SELECAO MAPA");
            SelecaoMapaController smc = loader.getController();
            Scene sc = new Scene(root);
            smc.setStage(this.getStage());
            smc.setUsers(this.u1, this.u2);
            sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
            this.getStage().setScene(sc);
            this.getStage().show();
            
        }else if(event.getSource() == btnLoja){
            setNomeUsuarios();
        }
        
    }
    
    @FXML
    private void acaoClickJ1(MouseEvent event) throws Exception {
        int i = 0;
        for(Pane pa : this.paneListJ1){
            if(event.getSource() == pa){
                if(this.u1 != null ) setNomeUsuarios();
                this.selecionarPersonagem(this.u1, "Personagem " + (i+1), i, true, this.u2, 1);
                
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
                if(this.u2 != null) setNomeUsuarios();
                this.selecionarPersonagem(this.u2,"Personagem " + (i+1), i, true, this.u1, 2);
                
                return;
            }
            i++;
        }
    }
}

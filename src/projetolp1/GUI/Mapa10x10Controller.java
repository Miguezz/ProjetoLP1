/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetolp1.GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import projetolp1.Mapa.BlocoMapa;
import projetolp1.Principal.Personagem;
import projetolp1.Principal.User;

/**
 *
 * @author FelipeBrasileiro
 */
public class Mapa10x10Controller extends MapaGUI implements Initializable{
    @FXML
    ArrayList<Pane> paneListCabecasJ1, paneListCabecasJ2;
    
    @FXML
    Button btnMover;
    boolean btnMoverSelecionado = false;
    BlocoMapa blocoMapaSelecionado1 = null;
    
    @FXML
    ArrayList<Label> labelListNJ1, labelListNJ2;
    User u, u2;
    
    public void setUsers(User u, User u2){
        System.out.println("SET USERS");
        this.u = u;
        this.u2 = u2;
        addPersonagens();
        updateImages();
    }
    
    @FXML 
    public void initialize(URL url, ResourceBundle rb){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                bm[i][j] = new BlocoMapa(j, i);
                configurarMapa(bm[i][j], i, j, this.mapaDeserto);
                paneArray[i][j] = new Pane();
                paneArray[i][j].setOnMouseClicked(event -> {
                    try {
                        onPaneClick(event);
                    } catch (Exception ex) {
                        Logger.getLogger(Mapa10x10Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                background[i][j] = new Pane();
                foreground[i][j] = new Pane();
                mapa.add(paneArray[i][j], i, j, 1, 1);
                mapaBackground.add(background[i][j], i, j, 1, 1);
            }
        }
    }
    
    private void updateImages(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                setImage(bm[i][j]);
            }
        }
    }
    
    @FXML
    private void addPersonagens(){
        int i = 1;
        String path;
        String classe;
        String raca;
        for(Personagem p : this.u.getParty()){
            classe = p.getClasseStr();
            raca = p.getRacaStr();
            path = "/resources/" + raca + "/" + classe + "/"+raca+classe+"_0.png";
            if(this.bm[i][1].getOcupante() != null){
                this.bm[i][2].setOcupante(p);
                this.bm[i][2].setFg(path);
            }else{
                this.bm[i][1].setOcupante(p);
                this.bm[i][1].setFg(path);
            }
            
//            this.bm[i][1].setTime("resources/Times/TeamBlue.png");
            this.paneListCabecasJ1.get(i-1).setStyle(
             "-fx-border-color: #000000;"
                        +"-fx-border-radius: 10;"
                        +"-fx-background-radius: 10;"
                        +"-fx-background-size: 110;"
                        +"-fx-background-position: center;"
                        +"-fx-background-repeat: no-repeat;"
                        + "-fx-background-image: url(\"resources/Cabecas/Cabeca" + raca + ".png\")"
            );
            if(p.getNome().equals("")){
                this.labelListNJ1.get(i-1).setText("Personagem " + i);
            }else{
                this.labelListNJ1.get(i-1).setText(p.getNome());
            }
            i++;
        }
        i = 1;
        for(Personagem p : this.u2.getParty()){
            classe = p.getClasseStr();
            raca = p.getRacaStr();
            path = "/resources/" + raca + "/" + classe + "/"+raca+classe+"_0.png";
            if(this.bm[i][8].getOcupante() != null){
                this.bm[i][7].setOcupante(p);
                this.bm[i][7].setFg(path);
            }else{
                this.bm[i][8].setOcupante(p);
                this.bm[i][8].setFg(path);
            }
//            this.bm[i][8].setTime("resources/Times/TeamRed.png");
            this.paneListCabecasJ2.get(i-1).setStyle(
             "-fx-border-color: #000000;"
                        +"-fx-border-radius: 10;"
                        +"-fx-background-radius: 10;"
                        +"-fx-background-size: 110;"
                        +"-fx-background-position: center;"
                        +"-fx-background-repeat: no-repeat;"
                        + "-fx-background-image: url(\"resources/Cabecas/Cabeca" + raca + ".png\")"
            );
            
            if(p.getNome().equals("")){
                this.labelListNJ2.get(i-1).setText("Personagem " + i);
            }else{
                this.labelListNJ1.get(i-1).setText(p.getNome());
            }
            i++;
        }
    }
    
    @FXML
    private void onClick(ActionEvent event) throws Exception{
        if(event.getSource() == btnMover){
            this.btnMoverSelecionado = true;
        }
    }
    
    @FXML
    private BlocoMapa detectarBloco(Pane pa){
        for(int i = 0; i < 10 ; i++){
            for(int j = 0; j < 10; j++){
                if(this.paneArray[i][j] == pa){
                    return bm[i][j];
                }
            }
        }
        return null;
    }
    
    @FXML
    private void onPaneClick(MouseEvent event) throws Exception{
//        for(int i = 0; i < 10; i ++){
//            for(int j = 0; j < 10; j++){
//                if(event.getSource() == this.paneArray[i][j]){
                    Pane pa = ((Pane)event.getSource());
                    BlocoMapa bloco = detectarBloco(pa);
                    if(bloco == null) return;
                    System.out.println("CLICOU");
                    if(blocoMapaSelecionado1 == null){
                        System.out.println("B NULO");
                        if(bloco.getOcupante() instanceof Personagem){
                            System.out.println("SETOU");
                            blocoMapaSelecionado1 = bloco;
                        }else{
                            System.out.println("FALSE");
                            this.btnMoverSelecionado = false;
                        }
                    }else{
                        System.out.println("ELSE");
                        if(this.blocoMapaSelecionado1 != null){
                            System.out.println("MOVER SELECIONADO");
                            Personagem p = ((Personagem)blocoMapaSelecionado1.getOcupante());
                            int [] pos = bloco.getPosicao();
                            int [] posAnt = p.getBlocoMapa().getPosicao();
                            System.out.println(p);
                            p.movimentarPersonagem(bloco, pos[0], pos[1]);
                            System.out.println(p);
                            System.out.println("MOVEU");
                            this.btnMoverSelecionado = false;
                            this.blocoMapaSelecionado1 = null;
                            bm[posAnt[0]][posAnt[1]].setOcupante(null);
                            bm[pos[0]][pos[1]].setOcupante(p);
                            System.out.println(this.paneArray[pos[0]][pos[1]].getStyle());
                            System.out.println(this.paneArray[pos[0]][pos[1]].getStyle());
                            this.setImage(bm[pos[0]][pos[1]]);
                            this.setImage(bm[posAnt[0]][posAnt[1]]);
                            System.out.println(this.paneArray[pos[0]][pos[1]].getStyle());
                        }
//                        TESTAR ISSO DAQ (SUBSTITUI OS -fx-background-image) PQ APARENTEMENTE BUGA
//                        Image img = new Image(file.getAbsoluteFile().toURI().toString());
//                        BackgroundImage bgImg = new BackgroundImage(img, 
//                        BackgroundRepeat.NO_REPEAT,
//                        BackgroundRepeat.NO_REPEAT,
//                        BackgroundPosition.DEFAULT,
//                        BackgroundSize.DEFAULT);
//                        borderPane.setBackground(new Background(bgImg));
                    }
                }
//            }
//        }
//    }
}

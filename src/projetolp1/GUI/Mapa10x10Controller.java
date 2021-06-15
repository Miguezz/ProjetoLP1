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
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import projetolp1.Mapa.BlocoMapa;
import projetolp1.Principal.Jogo;
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
    ArrayList<ProgressBar> pbVMJ1, pbVMJ2;
    
    @FXML
    Label lbQtdAcoes;
    
    @FXML
    Button btnMover, btnCancelar, btnAtaque;
    
    @FXML
    Label vezUsuario;
    
    int contJogada;
    boolean btnClicado = false;
    boolean btnMoverSelecionado = false, btnAtaqueSelecionado = false;
    BlocoMapa blocoMapaSelecionado1 = null;
    
    Jogo jogo;
    
    @FXML
    ArrayList<Label> labelListNJ1, labelListNJ2;
    
    User u, u2;
    public void setUsers(User u, User u2, int mapa){
        int turnos = 10;
        switch (mapa) {
            case 1:
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        configurarMapa(this.bm[i][j], i, j, this.mapaLaponia);
                        turnos = 30;
                    }
                }   break;
            case 2:
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        configurarMapa(this.bm[i][j], i, j, this.mapaDeserto);
                        turnos = 20;
                    }
                }   break;
            case 3:
                for(int i = 0; i < 10; i++){
                    for(int j = 0; j < 10; j++){
                        configurarMapa(this.bm[i][j], i, j, this.mapaValePedra);
                        turnos = 20;
                    }
                }   break;
            default:
                break;
        }
        this.u = u;
        this.u2 = u2;
        addPersonagens();
        updateImages();
        this.jogo = new Jogo(this.u, this.u2, turnos);
        int usuarioSorteado = jogo.sortearJogador();
        if(usuarioSorteado == 1){
            this.u.setVez(true);
            this.u2.setVez(false);
            vezUsuario.setText("Vez de " + this.u.getName());
            this.lbQtdAcoes.setText("Rounds: " + this.jogo.getRoundAtual() + " / " + this.jogo.getRounds());
        }else if(usuarioSorteado == 2){
            this.u2.setVez(true);
            this.u.setVez(false);
            vezUsuario.setText("Vez de " + this.u2.getName());
            this.lbQtdAcoes.setText("Ações: "+this.u2.getQtdAcoes()+" / 5");
        }
    }
    
    @FXML 
    public void initialize(URL url, ResourceBundle rb){
        this.contJogada = 0;
        btnCancelar.setVisible(false);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                bm[i][j] = new BlocoMapa(j, i);
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
            if(this.bm[1][i].getOcupante() != null){
                p.setTime("#00ffff"); // Azul claro
                this.bm[2][i].setOcupante(p);
                this.bm[2][i].setFg(path);
            }else{
                p.setTime("#00ffff"); // Azul claro
                this.bm[1][i].setOcupante(p);
                this.bm[1][i].setFg(path);
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
            if(this.bm[8][i].getOcupante() != null){
                p.setTime("red");
                this.bm[7][i].setOcupante(p);
                this.bm[7][i].setFg(path);
            }else{
                p.setTime("red");
                this.bm[8][i].setOcupante(p);
                this.bm[8][i].setFg(path);
            }
            
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
    private void resetButtons(){
        this.blocoMapaSelecionado1 = null;
        this.btnMoverSelecionado = false;
        this.btnAtaqueSelecionado = false;
        this.btnClicado = false;
        this.btnCancelar.setVisible(false);
    }
    
    @FXML
    private void onClick(ActionEvent event) throws Exception{
        if(event.getSource() == btnMover){
            resetButtons();
            this.btnMoverSelecionado = true;
            this.btnClicado = true;
            btnCancelar.setVisible(true);
        }else if(event.getSource() == btnCancelar){
            System.out.println("CANCELAR");
            resetButtons();
        }else if(event.getSource() == btnAtaque){
            resetButtons();
            this.btnAtaqueSelecionado = true;
            this.btnClicado = true;
            btnCancelar.setVisible(true);
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
    
    
    private int[] detectarPersonagem(Personagem p1){
        int[] pe = {-10, -10};
        int i = 0;
        for(Personagem p : this.u.getParty()){
            if(p == p1){
                pe[0] = i;
                pe[1] = 1;
                return pe;
            }
            i+=2;
        }
        i = 0;
        for(Personagem p : this.u2.getParty()){
            if(p == p1){
                pe[0] = i;
                pe[1] = 2;
                return pe;
            }
            i+=2;
        }
        return pe;
    }
    
    
    private void mudarTurno(){
        this.contJogada++;
        if(this.contJogada % 2 == 0){
            this.contJogada = 0;
            boolean cabou = this.jogo.mudaTurno();
            this.lbQtdAcoes.setText("Rounds: " + this.jogo.getRoundAtual() + " / " + this.jogo.getRounds());
            if(cabou){    // Muda pra tela do final + recompensa
                
            }
            
        }
    }
    
    @FXML
    private void onPaneClick(MouseEvent event) throws Exception{
        if(btnClicado){
            Pane pa = ((Pane)event.getSource());
            int [] pos = detectarBloco(pa).getPosicao(); // pega coordenada do pane
            if(this.bm[pos[0]][pos[1]] == null) return;
            System.out.println("CLICOU");
            if(blocoMapaSelecionado1 == null){
                if(this.bm[pos[0]][pos[1]].getOcupante() instanceof Personagem){
                    blocoMapaSelecionado1 = this.bm[pos[0]][pos[1]];
                }else{
                    this.blocoMapaSelecionado1 = null;
                    this.btnMoverSelecionado = false;
                    this.btnClicado = false;
                    btnCancelar.setVisible(false);
                }
            }else{
                if(btnMoverSelecionado){
                    if(this.blocoMapaSelecionado1 != null){
                    Personagem p = ((Personagem)blocoMapaSelecionado1.getOcupante());
                    int [] posAnt = blocoMapaSelecionado1.getPosicao();
                    if(this.u.getVez() && !p.getTime().equals("red")){
                        System.out.println("U1: " + this.u.getVez());
                        if(p.movimentarPersonagem(this.bm[pos[0]][pos[1]], this.u)){
                            this.btnMoverSelecionado = false;
                            this.blocoMapaSelecionado1 = null;
                            this.bm[posAnt[1]][posAnt[0]].setOcupante(null);
                            this.paneArray[posAnt[0]][posAnt[1]].setStyle("-fx-background-image: none;");
                            this.paneArray[posAnt[0]][posAnt[1]].setStyle("-fx-border-color: none;");
                            this.bm[pos[0]][pos[1]].setOcupante(p);
                            this.setImage(this.bm[pos[0]][pos[1]]);
                            btnCancelar.setVisible(false);
                            this.u.endOfTurn();
                            this.u2.setVez(true);
                            this.vezUsuario.setText("Vez de " + this.u2.getName());
                            this.mudarTurno();
                        }
                    }else if(this.u2.getVez()&& p.getTime().equals("red")){
                        System.out.println("U2: " + this.u.getVez());
                        if(p.movimentarPersonagem(this.bm[pos[0]][pos[1]], this.u2)){
                            this.btnMoverSelecionado = false;
                            this.blocoMapaSelecionado1 = null;
                            this.bm[posAnt[1]][posAnt[0]].setOcupante(null);
                            this.paneArray[posAnt[0]][posAnt[1]].setStyle("-fx-background-image: none;");
                            this.paneArray[posAnt[0]][posAnt[1]].setStyle("-fx-border-color: none;");
                            this.bm[pos[0]][pos[1]].setOcupante(p);
                            this.setImage(this.bm[pos[0]][pos[1]]);
                            btnCancelar.setVisible(false);
                            this.u2.endOfTurn();
                            this.u.setVez(true);
                            this.vezUsuario.setText("Vez de " + this.u.getName());
                            this.mudarTurno();
                        }
                    }
                        
                }
                }else if(btnAtaqueSelecionado){
                    if(this.blocoMapaSelecionado1 != null){
                    Personagem p = ((Personagem)blocoMapaSelecionado1.getOcupante());
                    Object o = this.bm[pos[0]][pos[1]].getOcupante();
                        if(o instanceof Personagem){
                            Personagem alvo = (Personagem)o;
                            if(this.u.getVez()){
                                if(p.atacar(blocoMapaSelecionado1, (Personagem)this.bm[pos[0]][pos[1]].getOcupante(), this.u)){
                                    this.btnMoverSelecionado = false;
                                    this.blocoMapaSelecionado1 = null;
                                    btnCancelar.setVisible(false);
                                    abaixarVida(pos);
                                    resetButtons();
                                    this.u.endOfTurn();
                                    this.u2.setVez(true);
                                    this.vezUsuario.setText("Vez de " + this.u2.getName());
                                    this.mudarTurno();
                                    
                                }
                            }else if(this.u2.getVez()){
                                if(p.atacar(blocoMapaSelecionado1, (Personagem)this.bm[pos[0]][pos[1]].getOcupante(), this.u2)){
                                    this.btnMoverSelecionado = false;
                                    this.blocoMapaSelecionado1 = null;
                                    btnCancelar.setVisible(false);
                                    abaixarVida(pos);
                                    resetButtons();
                                    this.u2.endOfTurn();
                                    this.u.setVez(true);
                                    this.vezUsuario.setText("Vez de " + this.u.getName());
                                    
                                }
                            }else{
                                resetButtons();
                            }
                        }
                    }
                }
            }
        }
    }
    
    @FXML
    private void abaixarVida(int []pos){
        int[] pers = detectarPersonagem((Personagem)this.bm[pos[0]][pos[1]].getOcupante());
        if(pers[1] == 1){
            double vidaMax = ((Personagem)this.bm[pos[0]][pos[1]].getOcupante()).getVidaMaxima();
            double vidaAtual = ((Personagem)this.bm[pos[0]][pos[1]].getOcupante()).getVidaMaxima() - ((Personagem)this.bm[pos[0]][pos[1]].getOcupante()).getDanoRecebido();
            int pos0 = pers[0];
            pbVMJ1.get(pos0).setProgress((vidaAtual)/vidaMax);

        }else if(pers[1] == 2){
            double vidaMax = ((Personagem)this.bm[pos[0]][pos[1]].getOcupante()).getVidaMaxima();
            double vidaAtual = ((Personagem)this.bm[pos[0]][pos[1]].getOcupante()).getVidaMaxima() - ((Personagem)this.bm[pos[0]][pos[1]].getOcupante()).getDanoRecebido();
            int pos0 = pers[0];
            pbVMJ2.get(pos0).setProgress((vidaAtual)/vidaMax);
        }
    }
}

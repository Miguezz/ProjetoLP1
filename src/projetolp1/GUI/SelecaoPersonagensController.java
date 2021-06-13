/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetolp1.GUI;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projetolp1.Principal.Personagem;
import projetolp1.Principal.User;

/**
 *
 * @author FelipeBrasileiro
 */
public class SelecaoPersonagensController extends Stager implements Initializable {
    
    @FXML
    private Canvas canvas;
    
    @FXML
    private Label lbRaca, lbClasse, lbAtaque, lbDefesa, lbVida, lbMana;
    
    @FXML
    private TextField tfNome;
    @FXML
    private Button btnProxClasse, btnAntClasse, btnProxRaca, btnAntRaca, btnConfirmar;
    
    @FXML
    AnimationTimer at;
    
    String[] racas = {"Laponico", "Anao", "Dragonborn", "Elfo", "Orc", "Tiefling"},
            classes= {"Alquimista", "Assassino", "Bruxo", "Cacador", "Cavaleiro", "Feiticeiro", "Sacerdote"};
    int contRaca = 0, contClasse = 0;
    
    User u, u2;
    Personagem p;
    int index, ord;
    boolean replace;
    String pNome;
    public void setUser(User u, int index, boolean replace, User u2, int ord){
        this.index = index;
        this.replace = replace;
        this.u = u;
        this.u2 = u2;
        this.ord = ord;
        System.gc();
    }
    public void setPersonagem(String nome){
        this.pNome = nome;
    }
    Image i = new Image(getClass().getResource("../../resources/parede.png").toExternalForm());
    private void startAnimacao(GraphicsContext gc){
        final long startNanoTime = System.nanoTime();
        at = new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 10000000.0;
                // Pog pra limpar e atualizar o frame
                gc.drawImage(i, 0, 0, 600, 600);
                gc.drawImage( boneco.getFrame(t), -350, -200 );
                
            }
        };
        at.start();
    }
    
    AnimatedImage boneco = new AnimatedImage();
    private void loadImage(String img, boolean primeiraRodada){

        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Image[] imageArray = new Image[4];
        for (int i = 0; i < 4; i++)
           imageArray[i] = new Image(getClass().getResource(img + "_" + i + ".png").toExternalForm() );
        this.boneco.frames = imageArray;
        this.boneco.duration = 100;
        if(primeiraRodada){
            this.startAnimacao(gc);
        }
    }
    
    @FXML 
    public void initialize(){
        this.lbRaca.setText(this.racas[this.contRaca]);
        this.lbClasse.setText(this.classes[this.contClasse]);
        this.p = new Personagem(this.pNome, this.contClasse, this.contRaca);
        this.setAtributos();
        loadImage("../../resources/"+ this.racas[contRaca] +"/"+ this.classes[contClasse]
                + "/" + this.racas[contRaca] + this.classes[contClasse], true);
    }
    
    @FXML
    private void setAtributos(){
        this.lbVida.setText(String.valueOf(this.p.getVidaMaxima()));
        this.lbMana.setText(String.valueOf(this.p.getManaMaxima()));
        this.lbDefesa.setText(String.valueOf(this.p.getDefesa()));
        this.lbAtaque.setText(String.valueOf(this.p.getDano()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.gc();
        initialize();
        System.gc();

    }
    
    @FXML
    private void acaoClick(ActionEvent event) throws Exception {
        if(this.u == null){
            this.u = new User();
        }
        if(this.u2 == null){
            this.u2 = new User();
        }
        if (event.getSource() == this.btnProxRaca) {
            this.contRaca = (this.contRaca + 1) % this.racas.length; // limita ao max
            this.lbRaca.setText(this.racas[this.contRaca]);
            loadImage("../../resources/"+ this.racas[contRaca] +"/"+
                    this.classes[contClasse] + "/" + this.racas[contRaca] + this.classes[contClasse], false);
//            this.p.setRaca(contRaca);
            this.p = new Personagem(this.pNome, this.contClasse, this.contRaca);
            this.setAtributos();

            
        } else if (event.getSource() == this.btnAntRaca) {
            if(this.contRaca == 0){
                this.contRaca = this.racas.length -1;
            }else{
                this.contRaca--;
            }
            this.lbRaca.setText(this.racas[this.contRaca]);
            loadImage("../../resources/"+ this.racas[contRaca] +"/"+ 
                    this.classes[contClasse] + "/" + this.racas[contRaca] + this.classes[contClasse], false);
            this.p.setRaca(contRaca);
            this.p = new Personagem(this.pNome, this.contClasse, this.contRaca);
            this.setAtributos();

            
        }else if (event.getSource() == this.btnProxClasse) {
            this.contClasse = (this.contClasse + 1) % this.classes.length; // limita ao max
            this.lbClasse.setText(this.classes[this.contClasse]);
            loadImage("../../resources/"+ this.racas[contRaca] +"/"+ this.classes[contClasse] + "/" +
                    this.racas[contRaca] + this.classes[contClasse], false);
            this.p.setClasse(contClasse);
            this.p = new Personagem(this.pNome, this.contClasse, this.contRaca);
            this.setAtributos();
            
        } else if (event.getSource() == this.btnAntClasse) {
            if(this.contClasse == 0){
                this.contClasse = this.classes.length -1;
            }else{
                this.contClasse--;
            }
            this.lbClasse.setText(this.classes[this.contClasse]);
            loadImage("../../resources/"+ this.racas[contRaca] +"/"+ this.classes[contClasse] + "/"
                    + this.racas[contRaca] + this.classes[contClasse], false);
            this.p.setClasse(contClasse);
            this.p = new Personagem(this.pNome, this.contClasse, this.contRaca);
            this.setAtributos();

        }else if(event.getSource() == this.btnConfirmar){
            this.p = new Personagem(this.tfNome.getText(), this.contClasse, this.contRaca);
            this.p.setNome(this.tfNome.getText());
            this.p.setRaca(contRaca);
            this.p.setClasse(contClasse);
            
//            System.out.println(this.p);
            
            if(this.replace && (this.u.getParty().size() > 0 && this.u.getParty().size() > index)){
                this.u.getParty().set(this.index, this.p);
            }else{
                u.getParty().add(p);
//                System.out.println(u.getParty().get(0));
            }
//            System.out.println("Tamanho: " + this.u.getParty().size());
            FXMLLoader loader = new FXMLLoader();
            Parent root = (Parent)loader.load(getClass().getResource("fxml/CriacaoUsuario.fxml").openStream());
            CriacaoUsuarioController cuc = loader.getController();
            cuc.setStage(this.getStage());
            if(this.ord == 1){
                cuc.setUsers(this.u, this.u2);
//                System.out.println(u.getParty().get(0));
            }else{
                cuc.setUsers(this.u2, this.u);
            }
            Scene sc = new Scene(root);
            sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
            this.getStage().setScene(sc);
            System.gc();
            this.getStage().show();
            
        }

    }
}

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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author FelipeBrasileiro
 */
public class SelecaoPersonagensController implements Initializable {
    
    @FXML
    private Canvas canvas;
    
    @FXML
    private Label lbRaca, lbClasse;
    
    @FXML
    private Button btnProxClasse, btnAntClasse, btnProxRaca, btnAntRaca;
    
    @FXML
    AnimationTimer at;
    
    String[] racas = {"Anão", "Dragonborn", "Elfo", "Laponico", "Orc", "Tiefling"},
            classes= {"Alquimista", "Assassino", "Bruxo", "Cacador", "Cavaleiro", "Feiticeiro", "Sacerdote"};
    int contRaca = 3, contClasse = 0;
    
    private void startAnimacao(GraphicsContext gc){
        final long startNanoTime = System.nanoTime();
        at = new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 10000000.0; 
                gc.drawImage(new Image(getClass().getResource("../../resources/parede.png").toExternalForm()), 0, 0, 600, 600);
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
        loadImage("../../resources/"+ this.racas[contRaca] +"/"+ this.classes[contClasse]
                + "/" + this.racas[contRaca] + this.classes[contClasse], true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initialize();

    }
    
    @FXML
    private void acaoClick(ActionEvent event) throws Exception {
        
        if (event.getSource() == this.btnProxRaca) {
            this.contRaca = (this.contRaca + 1) % this.racas.length; // limita ao max
            this.lbRaca.setText(this.racas[this.contRaca]);
            loadImage("../../resources/"+ this.racas[contRaca] +"/"+
                    this.classes[contClasse] + "/" + this.racas[contRaca] + this.classes[contClasse], false);

            
        } else if (event.getSource() == this.btnAntRaca) {
            if(this.contRaca == 0){
                this.contRaca = this.racas.length;
            }else{
                this.contRaca--;
            }
            this.lbRaca.setText(this.racas[this.contRaca]);
            loadImage("../../resources/"+ this.racas[contRaca] +"/"+ 
                    this.classes[contClasse] + "/" + this.racas[contRaca] + this.classes[contClasse], false);

            
        }else if (event.getSource() == this.btnProxClasse) {
            this.contClasse = (this.contClasse + 1) % this.classes.length; // limita ao max
            this.lbClasse.setText(this.classes[this.contClasse]);
            loadImage("../../resources/"+ this.racas[contRaca] +"/"+ this.classes[contClasse] + "/" +
                    this.racas[contRaca] + this.classes[contClasse], false);

            
        } else if (event.getSource() == this.btnAntClasse) {
            if(this.contClasse == 0){
                this.contClasse = this.classes.length;
            }else{
                this.contClasse--;
            }
            this.lbClasse.setText(this.classes[this.contClasse]);
            loadImage("../../resources/"+ this.racas[contRaca] +"/"+ this.classes[contClasse] + "/"
                    + this.racas[contRaca] + this.classes[contClasse], false);

        }

    }
}
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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author felip
 */
public class TutorialController extends Stager implements Initializable {
    
    int pag=0;
    
    @FXML
    private Pane ImagemTutorial, ImagemTutorialD, ImagemTutorialE;
    
    @FXML
    private Button MenuButton;
    
    @FXML
    private Button Proximo;
    
    @FXML
    private Button Anterior;
            
    @FXML
    private Label Tutorialpag;
    
    
    @FXML
    private void acaoClick(ActionEvent event) throws Exception {
        if (event.getSource() == MenuButton) {
            System.out.println("Voltando para o menu");
            FXMLLoader loader = new FXMLLoader();
            Parent root = (Parent)loader.load(getClass().getResource("fxml/MenuPrincipalPane.fxml").openStream());
            MenuPrincipalPaneController mpp = loader.getController();
            mpp.setStage(this.getStage());
            Scene sc = new Scene(root);
            sc.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
            this.getStage().setScene(sc);
            this.getStage().show();
        } else if (event.getSource() == Proximo) {
            System.out.println("Passando a pagina");
            pag=(pag+1)%9;
            System.out.println(pag);
            passarpag();
            
            
        }else if (event.getSource() == Anterior) {
            System.out.println("Voltando a pagina");
            pag--;
            if(pag == -1){
                pag=8;
            }
            System.out.println(pag);
            passarpag();
        }

    }
    void passarpag(){
            switch(pag){
                case 0:
                    ImagemTutorialD.setVisible(false);
                    ImagemTutorialE.setVisible(false);
                    ImagemTutorial.setVisible(false);
                    
                    Tutorialpag.setText("Mapas(1/2)\n" +
"\n" +
"No jogo existe 3 mapas, sendo 10x10, 15x15 e 20x20 respectivamente,\n" +
"cada mapa, possui seu formato diferente com diferentes obstaculos que bloqueiam\n" +
"a passagem dos jogadores e seus posicionamentos");
                break;
                case 1:

                    ImagemTutorialE.setStyle("-fx-background-size: 300; -fx-background-image: url(\"resources/Laponia.png\")");
                    ImagemTutorial.setStyle("-fx-background-size: 300; -fx-background-image: url(\"resources/Deserto.png\")");
                    ImagemTutorialD.setStyle("-fx-background-size: 300; -fx-background-image: url(\"resources/ValePedra.png\")");
                    ImagemTutorialD.setVisible(true);
                    ImagemTutorialE.setVisible(true);
                    ImagemTutorial.setVisible(true);
                    Tutorialpag.setText("Mapas(2/2)\n" +
"\n" +
"Cada casa do mapa so pode ser ocupado por 1 personagem, seja aliado ou inimigo");
                break;
                case 2:
                    ImagemTutorialD.setVisible(false);
                    ImagemTutorialE.setVisible(false);
                    ImagemTutorial.setStyle("-fx-background-size: 300; -fx-background-image: url(\"resources/Racas.png\")");
                    ImagemTutorial.setVisible(true);
                    Tutorialpag.setText("Personagens\n" +
"\n" +
"Cada usuario tem a possibilidade de criar 5 personagens, que podem possuir dentre as \n" +
"6 Racas e 7 Classes, tendo uma variacao de atributos com racas e mudanças de habilidades com as classes");
                    
                break;
                case 3:
                    ImagemTutorial.setStyle("-fx-background-size: 300; -fx-background-position: center; -fx-background-repeat: no-repeat; -fx-background-image: url(\"resources/Loja.png\")");
                    ImagemTutorial.setVisible(true);
                    Tutorialpag.setText("Loja\n" +
"\n" +
"Após cada fim de partida, o vencedor receberá 25LP (LapaCoin) e o perdedor 5LP.\n" +
"Liberando compras de novos equipamentos e consumiveis.");
                break;
                case 4:
                    ImagemTutorial.setVisible(false);
                    Tutorialpag.setText("Ataque\n" +
"\n" +
"Para realizar um ataque ou utilizar uma habilidade, necessita estar dentro do alcance de ataque,\n" +
"caso esteja fora de alcance deve-se andar as casas necessarias para alcancar o alcance de ataque\n" +
"Para atacar, selecione o seu personagem e o personagem alvo depois clique em atacar.");
                break;
                case 5:
                    ImagemTutorial.setVisible(true);
                    ImagemTutorial.setStyle("-fx-background-size: 300; -fx-background-position: center; -fx-background-repeat: no-repeat; -fx-background-image: url(\"resources/Atributos.png\")");
                    Tutorialpag.setText("Atributos\n" +
"\n" +
"Cada personagem possui atributos que influencia nos ataques, uso de habilidades e na defesa do jogador, sendo eles:\n" +
"\n" +
"Dano\n" +
"Defesa\n" +
"Vida\n" +
"Mana\n" +
"\n" +
"Sendo a formula de dano: dano base + (ATK do equipamento * bonus elemental) - defesa\n" +
"\n" +
"Lembrando que os atributos podem aumentar com base na raça, itens ou habilidade.");
                break;
                case 6:
                    ImagemTutorial.setStyle("-fx-background-size: 300; -fx-background-position: center; -fx-background-repeat: no-repeat; -fx-background-image: url(\"resources/Elementos.png\")");
                    ImagemTutorial.setVisible(true);
                    Tutorialpag.setText("Elementos\n" +
"\n" +
"As armaduras e armas do jogo possuem elementos, e eles acabam influenciando no dano recebido ou aplicado, como mostra na\n" +
"tabela abaixo:");
                break;
                case 7:
                    ImagemTutorial.setVisible(false);
                    Tutorialpag.setText("Habilidades\n" +
"\n" +
"Cada classe possui suas habilidades sendo elas unicas com caracteristicas diferentes, servem como ataques especiais para causar\n" +
"mais dano do que um ataque comum ou melhorar algum atributo de personagem ou causar algum status no inimigo.\n" +
"\n" +
"Cada Raçã possui habilidades de utilidade unicas também, podendo ser usadas a depender da situação para melhorar atributo.\n" +
"\n" +
"Habilidades normalmente requer algo para serem conjuradas, seja Mana ou Vida.");
                break;
                case 8:
                    Tutorialpag.setText("Status\n" +
"\n" +
"Algumas Habilidades possuem o ''status'', que é um estado que um personagem é submetido, sendo eles:\n" +
"\n" +
"Queimando: Causa 5 de dano fixo por 5 turno\n" +
"Stun: não consegue usar habilidades, atacar e andar por 1 turno\n" +
"Congelar: não consegue usar habilidades, atacar e andar por 1 turno\n" +
"Paralisia: não consegue usar habilidades, atacar e andar por 1 turno\n" +
"Armadilha: não consegue andar, porem consegue atacar se possuir alcance de uso de skill/ataque\n" +
"Maldição: Causa 10 de dano dark por 3 turnos\n" +
"\n" +
"Alguns status de habilidades são unicos, diferente desses, passando algum modificador de atributo.");
                break;
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImagemTutorial.setVisible(false);
        Tutorialpag.setText("Mapas(1/2)\n" +
"\n" +
"No jogo existe 3 mapas, sendo 10x10, 15x15 e 20x20 respectivamente,\n" +
"cada mapa, possui seu formato diferente com diferentes obstaculos que bloqueiam\n" +
"a passagem dos jogadores e seus posicionamentos");
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
}

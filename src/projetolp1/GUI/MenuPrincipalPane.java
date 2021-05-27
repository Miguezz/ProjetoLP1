package projetolp1.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuPrincipalPane extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // TODO: Testar outros fxml
        stage.setResizable(false);
        stage.setTitle("Aventuras no Lapaverso");
        Parent root = FXMLLoader.load(getClass().getResource("MenuPrincipalPane.fxml"));
        // root.setId("pane");
        Scene scene = new Scene(root);
        scene.getStylesheets().addAll(this.getClass().getResource("menuprincipalpane.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void main(String[] args) {
        launch(args);
    }

}

package fr.univartois.butinfo.ihm.spaceinvaders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import fr.ua.iutlens.sae.app.controller.StockEauController;
import fr.ua.iutlens.sae.app.controller.StockGlobal;

public class SpaceInvadersApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Il faut d'abord récupérer la description de la vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./view/stock-eau-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        StockEauController controller = fxmlLoader.getController();
//        StockGlobal stockGlobal = new StockGlobal();
//        controller.setGame(stockGlobal);
//        stockGlobal.setController(controller);
//        controller.setStage(stage);
//        // Ensuite, on la place dans une Scene...
//		Scene scene = new Scene(viewContent, 750, 500);
//        // que l'on place elle-même dans la fenêtre.
//        stage.setScene(scene);

        // On peut ensuite donner un titre à la fenêtre.
        stage.setTitle("Liste des Stockages d'Eau");

        
        // Enfin, on affiche la fenêtre.
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
package fr.ua.iutlens.sae.app.controller;

import java.io.IOException;

import fr.ua.iutlens.sae.app.model.EntrepriseVenteEau;
import fr.ua.iutlens.sae.app.model.IController;
import fr.ua.iutlens.sae.app.model.StockEau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class StocksEauController implements IController {

	private EntrepriseVenteEau entreprise;
	private Stage stage;
	
    @FXML
    private Label infosEau;

    @FXML
    private Label infosEntrepot;

    @FXML
    private Label infosQuantite;

    @FXML
    private ListView<StockEau> listeStocksEau;

    @FXML
    private Label labelTitre;

    @FXML
    void retour(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/accueil-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        IController controller = fxmlLoader.getController();
        controller.setEntreprise(entreprise);
        entreprise.setController(controller);
        controller.setLabelTitre(entreprise.getNom());
        controller.setStage(stage);
        
		Scene scene = new Scene(viewContent, 600, 200);

        stage.setScene(scene);

        stage.setTitle("Entreprise de vente d'eau");

        stage.show();
    }

    public void setLabelTitre(String nom) {
    	this.labelTitre.setText(labelTitre.getText() + nom);
    }
    
    public void setEntreprise(EntrepriseVenteEau entreprise) {
    	this.entreprise = entreprise;
    	System.out.println(entreprise.getStockGlobal());
    	System.out.println(entreprise.getStockGlobal().getTabStockEau());
    	listeStocksEau.getItems().addAll(entreprise.getStockGlobal().getTabStockEau());
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
}
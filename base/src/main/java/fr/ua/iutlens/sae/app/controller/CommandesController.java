package fr.ua.iutlens.sae.app.controller;

import java.io.IOException;

import fr.ua.iutlens.sae.app.model.Commande;
import fr.ua.iutlens.sae.app.model.EntrepriseVenteEau;
import fr.ua.iutlens.sae.app.model.IController;
import fr.ua.iutlens.sae.app.model.LigneDeCommande;
import fr.ua.iutlens.sae.app.model.StockEau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CommandesController implements IController {

	private EntrepriseVenteEau entreprise;
	private Stage stage;
	
    @FXML
    private Label infosEau;

    @FXML
    private Label infosQuantite;

    @FXML
    private ListView<Commande> listeCommandes;

    @FXML
    private ListView<LigneDeCommande> listeLignesCommande;
    
    @FXML
    private Label labelTitre;

    @FXML
    void retour(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/accueil-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        IController controller = fxmlLoader.getController();
        EntrepriseVenteEau entreprise = new EntrepriseVenteEau("012345","Livrais'O");
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
    	listeCommandes.getItems().addAll(entreprise.getCommandes());
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
}
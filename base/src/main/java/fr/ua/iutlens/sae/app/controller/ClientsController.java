package fr.ua.iutlens.sae.app.controller;

import java.io.IOException;

import fr.ua.iutlens.sae.app.model.Client;
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

public class ClientsController implements IController {

	private EntrepriseVenteEau entreprise;
	private Stage stage;
	
	@FXML
    private Label infosAdresse;

    @FXML
    private Label infosCode;

    @FXML
    private Label infosInscription;

    @FXML
    private Label infosMail;

    @FXML
    private Label infosPoints;

    @FXML
    private Label infosTelephone;

    @FXML
    private Label labelTitre;

    @FXML
    private ListView<Client> listeClients;

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
    	System.out.println(entreprise.getClients());
    	listeClients.getItems().addAll(entreprise.getClients());
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
}
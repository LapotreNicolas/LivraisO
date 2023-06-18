package fr.ua.iutlens.sae.app.controller;

import java.io.IOException;

import fr.ua.iutlens.sae.app.model.Client;
import fr.ua.iutlens.sae.app.model.EntrepriseVenteEau;
import fr.ua.iutlens.sae.app.model.IController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

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
    private Label infosTypeClient;

    @FXML
    private Label labelTitre;
    
    @FXML
    private Button supprimer;
    
    @FXML
    private Button ajouter;
    
    @FXML
    private ListView<Client> listeClients;

    @FXML
    void ajouterClique(ActionEvent event) {
    	if (ajouter.getText().equals("Ajouter")) {
    		ajouter.setText("Confirmer");
    		supprimer.setText("Annuler");
    	} else {
    		ajouter.setText("Ajouter");
    		supprimer.setText("Supprimer");
    	}
    }

    @FXML
    void supprimerClique(ActionEvent event) {
    	if (supprimer.getText().equals("Supprimer")) {
	    	entreprise.getClients().remove(listeClients.getSelectionModel().getSelectedItem());
	    	listeClients.setItems(entreprise.getClients());
	    	infosCode.setText(null);
	    	infosTypeClient.setText(null);
	    	infosInscription.setText(null);
	    	infosAdresse.setText(null);
	    	infosTelephone.setText(null);
	    	infosMail.setText(null);
	    	infosPoints.setText(null);
    	} else {
    		ajouter.setText("Ajouter");
    		supprimer.setText("Supprimer");
    	}
    }
    
    @FXML
    void afficherSelection(MouseEvent event) {
    	Client client = listeClients.getSelectionModel().getSelectedItem();
    	infosCode.setText(String.valueOf(client.getCode()));
    	infosTypeClient.setText(client.getAdresse().toString());
    	infosInscription.setText(client.getDateInscription());
    	infosAdresse.setText(client.getAdresse().toString());
    	infosTelephone.setText(client.getNumTelephone());
    	infosMail.setText(client.getAdresseMail());
    	infosPoints.setText(String.valueOf(client.getPtsFidelite()));
    }
    
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
    	listeClients.getItems().addAll(entreprise.getClients());
    	listeClients.setCellFactory(list -> {
    		return new ListCell<Client>() {
    			@Override
    			public void updateItem(Client client, boolean empty) {
    				super.updateItem(client, empty);
    				if (empty || (client == null)) {
    					setText(null);
    				} else {
    					setText("Code client : "+client.getCode());
    				}
    			}
    		};
    	});
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
}
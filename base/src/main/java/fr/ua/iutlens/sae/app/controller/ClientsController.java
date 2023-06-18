package fr.ua.iutlens.sae.app.controller;

import java.io.IOException;

import fr.ua.iutlens.sae.app.model.Adresse;
import fr.ua.iutlens.sae.app.model.Client;
import fr.ua.iutlens.sae.app.model.ClientEntreprise;
import fr.ua.iutlens.sae.app.model.ClientEtablissementPublic;
import fr.ua.iutlens.sae.app.model.ClientParticulier;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

/**
 * Classe qui gère les actions effectuées dans la vue clients-view
 * @author nicolas.lapotre
 */
public class ClientsController implements IController {

	private EntrepriseVenteEau entreprise;
	private Stage stage;
	
	@FXML
    private TextField ajoutAdresse;
	
    @FXML
    private TextField ajoutAdresse1;

    @FXML
    private TextField ajoutAdresse2;

    @FXML
    private TextField ajoutAdresse3;

    @FXML
    private TextField ajoutAdresse4;

    @FXML
    private TextField ajoutInscription;

    @FXML
    private TextField ajoutNom;
    
    @FXML
    private TextField ajoutMail;

    @FXML
    private TextField ajoutPoints;

    @FXML
    private TextField ajoutTelephone;

    @FXML
    private TextField ajoutTypeClient;
    
    @FXML
    private TextField ajoutDiffClient;
	
	@FXML
    private Label infosAdresse;

	@FXML
	private Label infosNom;
	
	@FXML
	private Label diffClient;
	
    @FXML
    private Label infosDiffClient;

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
    private Label erreur;
    
    @FXML
    private Button supprimer;
    
    @FXML
    private Button ajouter;
    
    @FXML
    private ListView<Client> listeClients;

    @FXML
    /**
     * Méthode qui permet d'ajouter un client à la liste
     * @param event le lancement de cette méthode
     */
    void ajouterClique(ActionEvent event) {
    	if (ajouter.getText().equals("Ajouter")) {
    		clearInfos();
    		ajout(true);
    		ajouter.setText("Confirmer");
    		supprimer.setText("Annuler");
    		diffClient.setText("Prenom / SIRET / Type d'établissement");
    	} else {
			String typeClient = ajoutTypeClient.getText();
			if (typeClient.equals("particulier") || typeClient.equals("Particulier")) {
				ClientParticulier client  = new ClientParticulier(ajoutInscription.getText(), new Adresse(ajoutAdresse.getText(), ajoutAdresse1.getText(), ajoutAdresse2.getText(), ajoutAdresse3.getText(), ajoutAdresse4.getText()), ajoutTelephone.getText(), ajoutMail.getText(), ajoutNom.getText(), ajoutDiffClient.getText());
				ajouteClient(client);
			} else if (typeClient.equals("entreprise") || typeClient.equals("Entreprise")) {
				ClientEntreprise client  = new ClientEntreprise(ajoutInscription.getText(), new Adresse(ajoutAdresse.getText(), ajoutAdresse1.getText(), ajoutAdresse2.getText(), ajoutAdresse3.getText(), ajoutAdresse4.getText()), ajoutTelephone.getText(), ajoutMail.getText(), ajoutNom.getText(), ajoutDiffClient.getText());
				ajouteClient(client);
			} else if (typeClient.equals("établissement publique") || typeClient.equals("etablissement publique") || typeClient.equals("Etablissement Publique") || typeClient.equals("Etablissement publique")) {
				ClientEtablissementPublic.Type type = null;
				if (ajoutDiffClient.getText().equals("EPA")) {
					type = ClientEtablissementPublic.Type.EPA;
				} else if (ajoutDiffClient.getText().equals("EPIC")) {
					type = ClientEtablissementPublic.Type.EPIC;
				} else if (ajoutDiffClient.getText().equals("EPSCT")) {
					type = ClientEtablissementPublic.Type.EPSCT;
				} 
				if (type != null) {
					ClientEtablissementPublic client  = new ClientEtablissementPublic(ajoutInscription.getText(), new Adresse(ajoutAdresse.getText(), ajoutAdresse1.getText(), ajoutAdresse2.getText(), ajoutAdresse3.getText(), ajoutAdresse4.getText()), ajoutTelephone.getText(), ajoutMail.getText(), ajoutNom.getText(), type);
					ajouteClient(client);
				} else {
					erreur.setText("Type d'etablissement inconnu (EPA, EPIC ou EPSCT)");
				}
			} else {
				erreur.setText("Type de client inconnu (Particulier, Entreprise ou Etablissement Publique)");
			}
		}
    }

    @FXML
    /**
     * Méthode qui permet de supprimer le client surligné de la liste
     * @param event le lancement de cette méthode
     */
    void supprimerClique(ActionEvent event) {
    	diffClient.setText(null);
    	if (supprimer.getText().equals("Supprimer")) {
	    	entreprise.getClients().remove(listeClients.getSelectionModel().getSelectedItem());
	    	listeClients.setItems(entreprise.getClients());
	    	clearInfos();
    	} else {
    		clearAjouts();
    		ajout(false);
    		ajouter.setText("Ajouter");
    		supprimer.setText("Supprimer");
    		erreur.setText(null);
    		afficherSelection(null);
    	}
    }
    
    @FXML
    /**
     * Méthode qui permet d'afficher les clients dans la liste
     * @param event le lancement de cette méthode
     */
    void afficherSelection(MouseEvent event) {
    	Client client = listeClients.getSelectionModel().getSelectedItem();
	    if (client != null) {
	    	if (client.getTypeClient() == "particulier") {
	    		infosTypeClient.setText("Particulier");
	    		diffClient.setText("Prenom du client :");
	    		ClientParticulier clientP = (ClientParticulier) client;
	    		infosDiffClient.setText(clientP.getPrenom());
	        	infosNom.setText(clientP.getNom());
	    	} else if (client.getTypeClient() == "entreprise") {
	    		infosTypeClient.setText("Entreprise");
	    		diffClient.setText("Siret du client :");
	    		ClientEntreprise clientE = (ClientEntreprise) client;
	    		infosDiffClient.setText(clientE.getSIRET());
	        	infosNom.setText(clientE.getNom());
	    	} else {
	    		infosTypeClient.setText("Etablissement publique");
	    		diffClient.setText("Type d'etablissement publique du client :");
	    		ClientEtablissementPublic clientEP = (ClientEtablissementPublic) client;
	    		infosDiffClient.setText(String.valueOf(clientEP.getType()));
	        	infosNom.setText(clientEP.getNom());
	    	}
	    	infosInscription.setText(client.getDateInscription());
	    	infosAdresse.setText(client.getAdresse().toString());
	    	infosTelephone.setText(client.getNumTelephone());
	    	infosMail.setText(client.getAdresseMail());
	    	infosPoints.setText(String.valueOf(client.getPtsFidelite()));
    	}
    }
    
    /**
     * Méthode qui ajoute un client (sais en paramètre) à la liste
     * @param client le client que l'on souhaite ajouter à la liste
     */
    public void ajouteClient(Client client) {
    	if (client != null) {
    		entreprise.getClients().add(client);
	    	listeClients.setItems(entreprise.getClients());
			clearAjouts();
			ajout(false);
			ajouter.setText("Ajouter");
			supprimer.setText("Supprimer");
    		diffClient.setText(null);
    		erreur.setText(null);
    	}
    }
    
    /**
     * Méthode qui efface l'ensemble des informations d'un client
     */
    public void clearInfos() {
    	infosNom.setText(null);
    	infosDiffClient.setText(null);
    	infosTypeClient.setText(null);
    	infosInscription.setText(null);
    	infosAdresse.setText(null);
    	infosTelephone.setText(null);
    	infosMail.setText(null);
    	infosPoints.setText(null);
    }
    
    /**
     * Méthode qui nettoie les cadres d'ajout de client
     */
    public void clearAjouts() {
    	ajoutDiffClient.setText(null);
    	ajoutNom.setText(null);
    	ajoutTypeClient.setText(null);
    	ajoutInscription.setText(null);
    	ajoutAdresse.setText(null);
    	ajoutAdresse1.setText(null);
    	ajoutAdresse2.setText(null);
    	ajoutAdresse3.setText(null);
    	ajoutAdresse4.setText(null);
    	ajoutTelephone.setText(null);
    	ajoutMail.setText(null);
    	ajoutDiffClient.setPrefWidth(0);
    	ajoutTypeClient.setPrefWidth(0);
    	ajoutInscription.setPrefWidth(0);
    	ajoutAdresse.setPrefWidth(0);
    	ajoutAdresse1.setPrefWidth(0);
    	ajoutAdresse3.setPrefWidth(0);
    	ajoutTelephone.setPrefWidth(0);
    	ajoutMail.setPrefWidth(0);
    }
    
    /**
     * Méthode qui affiche les champs d'informations pour ajouter un client
     * @param ajout vouloir ou non ajouter un client
     */
    public void ajout(boolean ajout) {
		infosDiffClient.setVisible(! ajout);
		infosNom.setVisible(! ajout);
		infosTypeClient.setVisible(! ajout);
		infosInscription.setVisible(! ajout);
		infosAdresse.setVisible(! ajout);
		infosTelephone.setVisible(! ajout);
		infosMail.setVisible(! ajout);
		infosPoints.setVisible(! ajout);
		ajoutNom.setVisible(ajout);
		ajoutDiffClient.setVisible(ajout);
		ajoutTypeClient.setVisible(ajout);
		ajoutInscription.setVisible(ajout);
		ajoutAdresse.setVisible(ajout);
		ajoutAdresse1.setVisible(ajout);
		ajoutAdresse2.setVisible(ajout);
		ajoutAdresse3.setVisible(ajout);
		ajoutAdresse4.setVisible(ajout);
		ajoutTelephone.setVisible(ajout);
		ajoutMail.setVisible(ajout);
		if (ajout) {
	    	ajoutDiffClient.setPrefWidth(300);
	    	ajoutNom.setPrefWidth(300);
	    	ajoutTypeClient.setPrefWidth(300);
	    	ajoutInscription.setPrefWidth(300);
	    	ajoutAdresse.setPrefWidth(50);
	    	ajoutAdresse1.setPrefWidth(130);
	    	ajoutAdresse3.setPrefWidth(100);
	    	ajoutTelephone.setPrefWidth(300);
	    	ajoutMail.setPrefWidth(300);
		}
    }
    
    @FXML
    /**
     * Méthode qui permet de retourner à la vue d'accueil
     * @param event action qui démarre le lancement de cette méthode
     * @throws IOException
     */
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
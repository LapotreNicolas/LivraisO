package fr.ua.iutlens.sae.app.controller;

import java.io.IOException;

import fr.ua.iutlens.sae.app.EntrepriseVenteEauApplication;
import fr.ua.iutlens.sae.app.model.EntrepriseVenteEau;
import fr.ua.iutlens.sae.app.model.IController;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.MenuButton;

/**
 * Classe qui gère les actions effectuées dans la vue accueil-view.
 * @author nicolas.lapotre
 * @see EntrepriseVenteEauApplication
 */
public class AccueilController implements IController {

	private EntrepriseVenteEau entreprise;
	private Stage stage;
	private String prochaineVue = null;
	private String titre;

    @FXML
    private MenuButton menu;

    @FXML
    private AnchorPane nom;

    @FXML
    private Label nomEntreprise;

    @FXML
    private Label labelTitre;
    
    @FXML
    /**
     * Méthode qui permet de séléctionner la vue de client pour pouvoir l'afficher plus tard.
     * @param event le dernier évènement déroulé sur la vue
     */
    void menuClients(ActionEvent event) {
    	menu.setText("Clients");
    	prochaineVue = "../view/clients-view.fxml";
    	titre = "Visualisation des clients de la societe";
    }

    @FXML
    /**
     * Méthode qui permet de séléctionner la vue des commandes pour pouvoir l'afficher plus tard.
     * @param event le dernier évènement déroulé sur la vue
     */
    void menuCommandes(ActionEvent event) {
    	menu.setText("Commandes");
    	prochaineVue = "../view/commandes-view.fxml";
    	titre = "Visualisation des commandes de la societe";
    }

    @FXML
    /**
     * Méthode qui permet de séléctionner la vue des Stocks d'eau pour pouvoir l'afficher plus tard.
     * @param event le dernier évènement déroulé sur la vue
     */
    void menuStock(ActionEvent event) {
    	menu.setText("Stocks d'eau");
    	prochaineVue = "../view/stocks-eau-view.fxml";
    	titre = "Visualisation des stocks d'eau de la societe";
    }

    @FXML
    /**
     * Méthode qui lance la prochaine vue selon le choix dans le menu déroulant dans la vue
     * @param event le dernier évènement déroulé sur la vue
     * @throws IOException
     */
    void visualiser(ActionEvent event) throws IOException {
    	if (prochaineVue != null) {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(prochaineVue));
            Parent viewContent = fxmlLoader.load();

            IController controller = fxmlLoader.getController();
            controller.setEntreprise(entreprise);
            entreprise.setController(controller);
            controller.setLabelTitre(entreprise.getNom());
            controller.setStage(stage);

    		Scene scene = new Scene(viewContent);

            stage.setScene(scene);

            stage.setTitle(titre);

            stage.show();
    	}
    }
    
    public void setLabelTitre(String nom) {
    	this.labelTitre.setText(labelTitre.getText() + nom);
    }

	public void setEntreprise(EntrepriseVenteEau entreprise) {
		this.entreprise = entreprise;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
}


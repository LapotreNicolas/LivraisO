package fr.ua.iutlens.sae.app.controller;

import java.io.IOException;

import fr.ua.iutlens.sae.app.model.Adresse;
import fr.ua.iutlens.sae.app.model.Eau;
import fr.ua.iutlens.sae.app.model.Entrepot;
import fr.ua.iutlens.sae.app.model.EntrepriseVenteEau;
import fr.ua.iutlens.sae.app.model.IController;
import fr.ua.iutlens.sae.app.model.StockEau;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Classe qui gère les actions se déroulant dans la vue stocks-eau-view
 * @author nicolas.lapotre
 */
public class StocksEauController implements IController {

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
	    private TextField ajoutEau;

	    @FXML
	    private TextField ajoutEau1;

	    @FXML
	    private TextField ajoutEau2;

	    @FXML
	    private TextField ajoutQuantite;
	    
	    @FXML
	    private TextField ajoutEntrepot;

	    @FXML
	    private TextField ajoutEntrepot1;

	    @FXML
	    private Button ajouter;

	    @FXML
	    private Label erreur;

	    @FXML
	    private Label infosAdresse;

	    @FXML
	    private Label infosEau;

	    @FXML
	    private Label infosEntrepot;

	    @FXML
	    private Label infosQuantite;

	    @FXML
	    private Label labelTitre;

	    @FXML
	    private ListView<StockEau> listeStocksEau;

	    @FXML
	    private Button supprimer;


    @FXML
    /**
     * Méthode qui permet d'ajouter une instance de stock dans la liste
     * @param event le lancement de cette méthode
     */
    void ajouterClique(ActionEvent event) {
    	if (ajouter.getText().equals("Ajouter")) {
    		clearInfos();
    		ajout(true);
    		ajouter.setText("Confirmer");
    		supprimer.setText("Annuler");
    	} else {
    		String prix = ajoutEau2.getText();
    		if (estNombreDecimal(prix)) {
    			double prixD = Double.parseDouble(prix);
    			String quantite = ajoutQuantite.getText();
    			if (estNombreEntier(quantite)) {
        			int quantiteI = Integer.parseInt(quantite);
        			String code = ajoutEntrepot.getText();
        			if (estNombreEntier(code)) {
        				int codeI = Integer.parseInt(code);
        				String categorie = ajoutEau1.getText();
        				if (categorie.equals("plate") || categorie.equals("Plate") || categorie.equals("PLATE")) {
        					StockEau stock = new StockEau(new Eau(ajoutEau.getText(), Eau.Categorie.EAU_PLATE, prixD), new Entrepot(codeI, ajoutEntrepot1.getText(), new Adresse(ajoutAdresse.getText(), ajoutAdresse1.getText(), ajoutAdresse2.getText(), ajoutAdresse3.getText(), ajoutAdresse4.getText())), quantiteI);
        					ajouteStock(stock);
        				} else if (categorie.equals("gazeuse") || categorie.equals("Gazeuse") || categorie.equals("GAZEUSE")) {
        					StockEau stock = new StockEau(new Eau(ajoutEau.getText(), Eau.Categorie.EAU_GAZEUSE, prixD), new Entrepot(codeI, ajoutEntrepot1.getText(), new Adresse(ajoutAdresse.getText(), ajoutAdresse1.getText(), ajoutAdresse2.getText(), ajoutAdresse3.getText(), ajoutAdresse4.getText())), quantiteI);
        					ajouteStock(stock);
        				} else {
        					erreur.setText("Categorie inconnue (Plate ou Gazeuse)");
        				}	
        			} else {
        				erreur.setText("Code d'entrepot non conforme. La code d'entrepot doit etre un nombre entier");
        			}
    			} else {
    				erreur.setText("Quantite non conforme. La quantite doit etre un nombre entier");
    			}
    		} else {
    			erreur.setText("Prix non conforme. Le prix doit etre un nombre decimal");
    		}
		}
    }

    @FXML
    /**
     * Méthode qui permet de retirer le stock d'eau sélectionné de la liste
     * @param event le lancement de cette méthode
     */
    void supprimerClique(ActionEvent event) {
    	if (supprimer.getText().equals("Supprimer")) {
	    	entreprise.getStockGlobal().getTabStockEau().remove(listeStocksEau.getSelectionModel().getSelectedItem());
	    	listeStocksEau.setItems(entreprise.getStockGlobal().getTabStockEau());
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
     * Méthode qui affiche les stocks d'eau dans la liste
     * @param event le lancement de cette méthode
     */
    void afficherSelection(MouseEvent event) {
    	StockEau stockEau = listeStocksEau.getSelectionModel().getSelectedItem();
	    if (stockEau != null) {
	    	infosEau.setText(stockEau.getEau().toString());
	    	infosQuantite.setText(String.valueOf(stockEau.getQuantite()));
	    	infosEntrepot.setText("Code : " + stockEau.getEntrepot().getCode() + ", Nom : " + stockEau.getEntrepot().getNom());
	    	infosAdresse.setText(stockEau.getEntrepot().getAdresse().toString());
    	}
    }
    
    /**
     * 
     * @param stockEau le stock d'eau que l'on souhaite ajouter
     */
    public void ajouteStock(StockEau stockEau) {
    	if (stockEau != null) {
    		entreprise.getStockGlobal().getTabStockEau().add(stockEau);
	    	listeStocksEau.setItems(entreprise.getStockGlobal().getTabStockEau());
			clearAjouts();
			ajout(false);
			ajouter.setText("Ajouter");
			supprimer.setText("Supprimer");
    		erreur.setText(null);
    	}
    }
    
    /**
     * Méthode qui efface l'ensemble des informations d'un client
     */
    public void clearInfos() {
    	infosEau.setText(null);
    	infosQuantite.setText(null);
    	infosEntrepot.setText(null);
    	infosAdresse.setText(null);
    }
    
    /**
     * Méthode qui nettoie les cadres d'ajout de client
     */
    public void clearAjouts() {
    	ajoutEau.setText(null);
    	ajoutEau1.setText(null);
    	ajoutEau2.setText(null);
    	ajoutQuantite.setText(null);
    	ajoutEntrepot.setText(null);
    	ajoutEntrepot1.setText(null);
    	ajoutAdresse.setText(null);
    	ajoutAdresse1.setText(null);
    	ajoutAdresse2.setText(null);
    	ajoutAdresse3.setText(null);
    	ajoutAdresse4.setText(null);
    	ajoutEau.setPrefWidth(0);
    	ajoutEau1.setPrefWidth(0);
    	ajoutEau2.setPrefWidth(0);
    	ajoutQuantite.setPrefWidth(0);
    	ajoutEntrepot.setPrefWidth(0);
    	ajoutEntrepot1.setPrefWidth(0);
    	ajoutAdresse.setPrefWidth(0);
    	ajoutAdresse1.setPrefWidth(0);
    	ajoutAdresse3.setPrefWidth(0);
    }
    
    /**
     * Méthode qui affiche les champs d'informations pour ajouter un client
     * @param ajout vouloir ou non ajouter un client
     */
    public void ajout(boolean ajout) {
    	infosEau.setVisible(! ajout);
    	infosQuantite.setVisible(! ajout);
    	infosEntrepot.setVisible(! ajout);
		infosAdresse.setVisible(! ajout);
    	ajoutEau.setVisible(ajout);
    	ajoutEau1.setVisible(ajout);
    	ajoutEau2.setVisible(ajout);
    	ajoutQuantite.setVisible(ajout);
    	ajoutEntrepot.setVisible(ajout);
    	ajoutEntrepot1.setVisible(ajout);	
		ajoutAdresse.setVisible(ajout);
		ajoutAdresse1.setVisible(ajout);
		ajoutAdresse2.setVisible(ajout);
		ajoutAdresse3.setVisible(ajout);
		ajoutAdresse4.setVisible(ajout);
		if (ajout) {
			ajoutEau.setPrefWidth(100);
	    	ajoutEau1.setPrefWidth(100);
	    	ajoutEau2.setPrefWidth(50);
	    	ajoutQuantite.setPrefWidth(100);
	    	ajoutEntrepot.setPrefWidth(100);
	    	ajoutEntrepot1.setPrefWidth(175);
	    	ajoutAdresse.setPrefWidth(50);
	    	ajoutAdresse1.setPrefWidth(130);
	    	ajoutAdresse3.setPrefWidth(100);
		}
    }
    
    /**
     * Méthode qui vérifie que le texte saisie est un nombre entier
     * @param text le texte à verifier
     * @return true si le texte est un nombre entier, false sinon
     */
    private boolean estNombreEntier(String text) {
    	return text.matches("[0-9]*");
    }
    
    /**
     * Méthode qui vérifie que le texte saisie est un nombre décimal
     * @param text le texte à verifier
     * @return true si le texte est un nombre décimal, false sinon
     */
    private boolean estNombreDecimal(String text) {
		boolean resteVirgule = true;
    	for (char c : text.toCharArray()) {
    		if (! (""+c).matches("[0-9]*")) {
    			if (resteVirgule && (""+c).equals(".")) {
    				resteVirgule = false;
    			} else {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    @FXML
    /**
     * Méthode qui permet de retourner à la vue précédente.
     * @param event le lancement de cette méthode
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
    	listeStocksEau.getItems().addAll(entreprise.getStockGlobal().getTabStockEau());
    	listeStocksEau.setCellFactory(list -> {
    		return new ListCell<StockEau>() {
    			@Override
    			public void updateItem(StockEau stock, boolean empty) {
    				super.updateItem(stock, empty);
    				if (empty || (stock == null)) {
    					setText(null);
    				} else {
    					setText("Numero stock d'eau : "+ stock.getCode());
    				}
    			}
    		};
    	});
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
}
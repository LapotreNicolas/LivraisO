package fr.ua.iutlens.sae.app.controller;

import java.io.IOException;

import fr.ua.iutlens.sae.app.model.Adresse;
import fr.ua.iutlens.sae.app.model.Commande;
import fr.ua.iutlens.sae.app.model.Eau;
import fr.ua.iutlens.sae.app.model.Entrepot;
import fr.ua.iutlens.sae.app.model.EntrepriseVenteEau;
import fr.ua.iutlens.sae.app.model.IController;
import fr.ua.iutlens.sae.app.model.LigneDeCommande;
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
 * Classe qui gère les actions effectuées dans la vue commandes-view
 * @author nicolas.lapotre
 */
public class CommandesController implements IController {

	private EntrepriseVenteEau entreprise;
	private Stage stage;
	
	@FXML
    private TextField ajoutEau;

    @FXML
    private TextField ajoutEau1;

    @FXML
    private TextField ajoutEau2;

    @FXML
    private TextField ajoutQuantite;

    @FXML
    private Button ajouterLigne;

    @FXML
    private Button ajouterCommande;
    
    @FXML
    private Label erreur;

    @FXML
    private Label infosEau;

    @FXML
    private Label infosEau1;

    @FXML
    private Label infosQuantite;

    @FXML
    private Label infosQuantite1;

    @FXML
    private Label labelTitre;

    @FXML
    private ListView<Commande> listeCommandes;

    @FXML
    private ListView<LigneDeCommande> listeLignesCommande;

    @FXML
    private Button supprimerCommande;
    
    @FXML
    private Button supprimerLigne;

    @FXML
    /**
     * Méthode qui permet d'ajouter une instance de commande dans la liste
     * @param event le lancement de cette méthode
     */
    void ajouterCliqueCommande(ActionEvent event) {
    	entreprise.getCommandes().add(new Commande());
    	listeCommandes.setItems(entreprise.getCommandes());
		clearAjouts();
		ajout(false);
		ajouterLigne.setText("Ajouter");
		supprimerLigne.setText("Supprimer");
		erreur.setText(null);
    }
    
    @FXML
    /**
     * Méthode qui permet de retirer la ligne de commnande sélectionné de la liste
     * @param event le lancement de cette méthode
     */
    void supprimerCliqueCommande(ActionEvent event) {
		entreprise.getCommandes().remove(listeCommandes.getSelectionModel().getSelectedItem());
    	listeCommandes.setItems(entreprise.getCommandes());
    	clearInfos();
    }
    
    @FXML
    /**
     * Méthode qui permet d'ajouter une instance de ligne dans la liste
     * @param event le lancement de cette méthode
     */
    void ajouterCliqueLigne(ActionEvent event) {
    	if (ajouterLigne.getText().equals("Ajouter")) {
    		clearInfos();
    		ajout(true);
    		ajouterLigne.setText("Confirmer");
    		supprimerLigne.setText("Annuler");
    	} else {
    		String prix = ajoutEau2.getText();
    		if (estNombreDecimal(prix)) {
    			double prixD = Double.parseDouble(prix);
    			String quantite = ajoutQuantite.getText();
    			if (estNombreEntier(quantite)) {
        			int quantiteI = Integer.parseInt(quantite);
    				String categorie = ajoutEau1.getText();
    				if (categorie.equals("plate") || categorie.equals("Plate") || categorie.equals("PLATE")) {
    					LigneDeCommande ligne = new LigneDeCommande(new Eau(ajoutEau.getText(), Eau.Categorie.EAU_PLATE, prixD), quantiteI);
    					ajouteLigne(ligne);
    				} else if (categorie.equals("gazeuse") || categorie.equals("Gazeuse") || categorie.equals("GAZEUSE")) {
    					LigneDeCommande ligne = new LigneDeCommande(new Eau(ajoutEau.getText(), Eau.Categorie.EAU_GAZEUSE, prixD), quantiteI);
    					ajouteLigne(ligne);
    				} else {
    					erreur.setText("Categorie inconnue (Plate ou Gazeuse)");
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
     * Méthode qui permet de retirer la ligne de commnande sélectionné de la liste
     * @param event le lancement de cette méthode
     */
    void supprimerCliqueLigne(ActionEvent event) {
    	if (supprimerLigne.getText().equals("Supprimer")) {
    		listeCommandes.getSelectionModel().getSelectedItem().getCommandes().remove(listeLignesCommande.getSelectionModel().getSelectedItem());
	    	listeLignesCommande.setItems(listeCommandes.getSelectionModel().getSelectedItem().getCommandes());
	    	clearInfos();
    	} else {
    		clearAjouts();
    		ajout(false);
    		ajouterLigne.setText("Ajouter");
    		supprimerLigne.setText("Supprimer");
    		erreur.setText(null);
    		afficherSelectionLigne(null);
    	}
    }
    
    @FXML
    /**
     * Méthode qui affiche les lignes de commande dans la liste
     * @param event le lancement de cette méthode
     */
    void afficherSelectionCommande(MouseEvent event) {
    	Commande commande = listeCommandes.getSelectionModel().getSelectedItem();
	    if (commande != null) {
	    	listeLignesCommande.setItems(commande.getCommandes());
	    	listeLignesCommande.setCellFactory(list -> {
	    		return new ListCell<LigneDeCommande>() {
	    			@Override
	    			public void updateItem(LigneDeCommande ligne, boolean empty) {
	    				super.updateItem(ligne, empty);
	    				if (empty || (ligne == null)) {
	    					setText(null);
	    				} else {
	    					setText("Numero commande : "+ ligne.hashCode());
	    				}
	    			}
	    		};
	    	});
    	}
    }
    
    @FXML
    /**
     * Méthode qui affiche la ligne de commande dans la liste
     * @param event le lancement de cette méthode
     */
    void afficherSelectionLigne(MouseEvent event) {
    	LigneDeCommande ligne = listeLignesCommande.getSelectionModel().getSelectedItem();
	    if (ligne != null) {
	    	infosEau.setText(ligne.getEau().toString());
	    	infosQuantite.setText(String.valueOf(ligne.getQuantite()));
    	}
    }
    

    
    /**
     * 
     * @param stockEau le stock d'eau que l'on souhaite ajouter
     */
    public void ajouteLigne(LigneDeCommande ligne) {
    	if (ligne != null) {
    		listeCommandes.getSelectionModel().getSelectedItem().getCommandes().add(ligne);
	    	listeLignesCommande.setItems(listeCommandes.getSelectionModel().getSelectedItem().getCommandes());
			clearAjouts();
			ajout(false);
			ajouterLigne.setText("Ajouter");
			supprimerLigne.setText("Supprimer");
    		erreur.setText(null);
    	}
    }
    
    /**
     * Méthode qui efface l'ensemble des informations d'une lignes
     */
    public void clearInfos() {
    	infosEau.setText(null);
    	infosQuantite.setText(null);
    }
    
    /**
     * Méthode qui nettoie les cadres d'ajout des lignes
     */
    public void clearAjouts() {
    	ajoutEau.setText(null);
    	ajoutEau1.setText(null);
    	ajoutEau2.setText(null);
    	ajoutQuantite.setText(null);
    	ajoutEau.setPrefWidth(0);
    	ajoutEau1.setPrefWidth(0);
    	ajoutEau2.setPrefWidth(0);
    	ajoutQuantite.setPrefWidth(0);
    }
    
    /**
     * Méthode qui affiche les champs d'informations pour ajouter une ligne
     * @param ajout vouloir ou non ajouter une ligne
     */
    public void ajout(boolean ajout) {
    	infosEau.setVisible(! ajout);
    	infosQuantite.setVisible(! ajout);
    	ajoutEau.setVisible(ajout);
    	ajoutEau1.setVisible(ajout);
    	ajoutEau2.setVisible(ajout);
    	ajoutQuantite.setVisible(ajout);
		if (ajout) {
			ajoutEau.setPrefWidth(100);
	    	ajoutEau1.setPrefWidth(100);
	    	ajoutEau2.setPrefWidth(50);
	    	ajoutQuantite.setPrefWidth(100);
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
    	listeCommandes.getItems().addAll(entreprise.getCommandes());
    	listeCommandes.setCellFactory(list -> {
    		return new ListCell<Commande>() {
    			@Override
    			public void updateItem(Commande commande, boolean empty) {
    				super.updateItem(commande, empty);
    				if (empty || (commande == null)) {
    					setText(null);
    				} else {
    					setText("Numero commande : "+ commande.hashCode());
    				}
    			}
    		};
    	});
    }
    
    public void setStage(Stage stage) {
    	this.stage = stage;
    }
}
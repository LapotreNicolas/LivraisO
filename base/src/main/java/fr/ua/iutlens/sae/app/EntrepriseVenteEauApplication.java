package fr.ua.iutlens.sae.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import fr.ua.iutlens.sae.app.model.Adresse;
import fr.ua.iutlens.sae.app.model.ClientEntreprise;
import fr.ua.iutlens.sae.app.model.ClientEtablissementPublic;
import fr.ua.iutlens.sae.app.model.ClientParticulier;
import fr.ua.iutlens.sae.app.model.Commande;
import fr.ua.iutlens.sae.app.model.Eau;
import fr.ua.iutlens.sae.app.model.Employe;
import fr.ua.iutlens.sae.app.model.Entrepot;
import fr.ua.iutlens.sae.app.model.EntrepriseVenteEau;
import fr.ua.iutlens.sae.app.model.IController;
import fr.ua.iutlens.sae.app.model.LigneDeCommande;
import fr.ua.iutlens.sae.app.model.StockEau;

/**
 * Classe qui permet l'initialisation et le lancement de l'application 
 * @author nicolas.lapotre
 * @see Application
 */
public class EntrepriseVenteEauApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./view/accueil-view.fxml"));
        Parent viewContent = fxmlLoader.load();

        IController controller = fxmlLoader.getController();
        EntrepriseVenteEau entreprise = new EntrepriseVenteEau("012345","Livrais'O");
        Eau eau1 = new Eau("Vitel", Eau.Categorie.EAU_PLATE, 2.5);
        Eau eau2 = new Eau("Cristaline", Eau.Categorie.EAU_PLATE, 2.0);
        Adresse adresse1 = new Adresse("13", "Rue de la Pomme", "92044", "Levallois Perret", "Hauts-de-Seine");
        Adresse adresse2 = new Adresse("15", "Rue de Roeux", "62369", "Gavrelle", "Pas-de-Calais");
        Adresse adresse3 = new Adresse("15 Bis", "Rue de ", "31555", "Toulouse", "Haute-Garonne");
        Adresse adresse4 = new Adresse("20", "Rue Alphonse Daudet", "62753", "Saint-Laurent-Blangy", "Pas-de-Calais");
        Adresse adresse5 = new Adresse("122", "Rue d'Arras", "62399", "Habarcq", "Pas-de-Calais");
        Adresse adresse6 = new Adresse("13 Ter", "Rue Lamartine", "62041", "Arras", "Pas-de-Calais");
        Entrepot entrepot1 = new Entrepot(1234, "Seno", adresse6);
        Entrepot entrepot2 = new Entrepot(9876, "Ones", adresse1);
        StockEau stockEau1 = new StockEau(eau1, entrepot2, 120);
        StockEau stockEau2 = new StockEau(eau2, entrepot1, 90);
        StockEau stockEau3 = new StockEau(eau1, entrepot2, 150);
        StockEau stockEau4 = new StockEau(eau1, entrepot1, 30);
        ClientEntreprise client1 = new ClientEntreprise("07/03/2023", adresse2, "0123456789", "mujer@mail.com", "Mujer", "0123");        
        ClientParticulier client2 = new ClientParticulier("13/05/2023", adresse3, "0963852741", "louis@mail.com", "XIV", "louis");        
        ClientEtablissementPublic client3 = new ClientEtablissementPublic("12/12/2012", adresse4, "0612121212", "dooze@mail.com", "Dooze", ClientEtablissementPublic.Type.EPIC);        
        ClientEntreprise client4 = new ClientEntreprise("06/09/2023", adresse5, "0666420689", "doom@mail.com", "Doom", "666");
        LigneDeCommande ligne1 = new LigneDeCommande(eau2, 10);
        LigneDeCommande ligne2 = new LigneDeCommande(eau1, 26);
        LigneDeCommande ligne3 = new LigneDeCommande(eau2, 21);
        LigneDeCommande ligne4 = new LigneDeCommande(eau1, 14);
        LigneDeCommande ligne5 = new LigneDeCommande(eau1, 9);
        Commande commande1 = new Commande();
        commande1.ajouterCommande(ligne5);
        commande1.ajouterCommande(ligne1);
        commande1.ajouterCommande(ligne2);
        Commande commande2 = new Commande();
        commande2.ajouterCommande(ligne3);
        commande2.ajouterCommande(ligne5);
        commande2.ajouterCommande(ligne4);
        Commande commande3 = new Commande();
        commande3.ajouterCommande(ligne2);
        commande3.ajouterCommande(ligne1);
        commande3.ajouterCommande(ligne4);
        Commande commande4 = new Commande();
        commande4.ajouterCommande(ligne3);
        commande4.ajouterCommande(ligne1);
        commande4.ajouterCommande(ligne5);
        Employe employe1 = new Employe("Iorka", "Yves", Employe.Contrat.CDI, 2111.04);
        Employe employe2 = new Employe("Nam", "Exort", Employe.Contrat.CDD, 3106.04);
        Employe employe3 = new Employe("The Incendiary", "GralfJord", Employe.Contrat.CDD, 1109.04);
        entreprise.embaucher(employe1);
        entreprise.embaucher(employe2);
        entreprise.embaucher(employe3);
        entreprise.enregistrerClient(client3);
        entreprise.enregistrerClient(client1);
        entreprise.enregistrerClient(client2);
        entreprise.enregistrerClient(client4);
        entreprise.achatStock(stockEau4);
        entreprise.achatStock(stockEau2);
        entreprise.achatStock(stockEau3);
        entreprise.achatStock(stockEau1);
        entreprise.enregistrerCommande(commande1);
        entreprise.enregistrerCommande(commande2);
        entreprise.enregistrerCommande(commande3);
        entreprise.enregistrerCommande(commande4);
        
        controller.setEntreprise(entreprise);
        entreprise.setController(controller);
        controller.setLabelTitre(entreprise.getNom());
        controller.setStage(stage);
        
		Scene scene = new Scene(viewContent, 600, 200);

        stage.setScene(scene);

        stage.setTitle("Entreprise de vente d'eau");

        stage.show();
    }

    /**
     * Méthode qui démarre l'application de gestion de l'entreprise
     * @param args lance l'application
     */
    public static void main(String[] args) {
        launch();
    }
}
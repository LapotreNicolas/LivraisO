package fr.ua.iutlens.sae.app.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Test {
    public static void main(String[] args) {
        Eau eau1 = new Eau("Vitel", Eau.Categorie.EAU_PLATE, 2.5);
        Eau eau2 = new Eau("Cristaline", Eau.Categorie.EAU_PLATE, 2.0);
        Adresse adresse1 = new Adresse("13", "Rue de la Pomme", "92044", "Levallois Perret", "Hauts-de-Seine");
        Adresse adresse2 = new Adresse("15", "Rue de Roeux", "62369", "Gavrelle", "Pas-de-Calais");
        Adresse adresse3 = new Adresse("15 Bis", "Rue de ", "31555", "Toulouse", "Haute-Garonne");
        Adresse adresse4 = new Adresse("20", "Rue Alphonse Daudet", "62753", "Saint-Laurent-Blangy", "Pas-de-Calais");
        Adresse adresse5 = new Adresse("122", "Rue d'Arras", "62399", "Habarcq", "Pas-de-Calais");
        Adresse adresse6 = new Adresse("13 Ter", "Rue Lamartine", "62041", "Arras", "Pas-de-Calais");
        Adresse adresse7 = new Adresse("51", "Rue de la Plage", "80649", "Quend", "Somme");
        Entrepot entrepot1 = new Entrepot(1234, "Seno", adresse7);
        Entrepot entrepot2 = new Entrepot(9876, "Ones", adresse1);
        StockEau stockEau1 = new StockEau(eau1, entrepot2, 120);
        StockEau stockEau2 = new StockEau(eau2, entrepot1, 90);
        StockEau stockEau3 = new StockEau(eau1, entrepot2, 150);
        StockEau stockEau4 = new StockEau(eau1, entrepot1, 30);
        StockGlobal stockGlobal = new StockGlobal();
        ClientEntreprise client1 = new ClientEntreprise("07/03/2023", adresse2, "0123456789", "mujer@mail.com", "Mujer", "0123");        
        ClientParticulier client2 = new ClientParticulier("13/05/2023", adresse3, "0963852741", "louis@mail.com", "XIV", "louis");        
        ClientEtablissementPublic client3 = new ClientEtablissementPublic("12/12/2012", adresse4, "0612121212", "dooze@mail.com", "Dooze", ClientEtablissementPublic.Type.EPIC);        
        ClientEntreprise client4 = new ClientEntreprise("06/09/2023", adresse5, "0666420689", "doom@mail.com", "Doom", "666");
        LigneDeCommande ligne1 = new LigneDeCommande(eau2, 10);
        LigneDeCommande ligne2 = new LigneDeCommande(eau1, 26);
        LigneDeCommande ligne3 = new LigneDeCommande(eau2, 21);
        LigneDeCommande ligne4 = new LigneDeCommande(eau1, 14);
        LigneDeCommande ligne5 = new LigneDeCommande(eau1, 9);
        ObservableList<LigneDeCommande> tabLignes21 = FXCollections.observableArrayList(ligne2,ligne1);
        Commande cmd1 = new Commande();
        System.out.println(eau1);
        System.out.println(eau2);
        System.out.println(adresse1);
        System.out.println(adresse7);
        System.out.println(entrepot1);
        System.out.println(entrepot2);
        System.out.println(stockEau1);
        System.out.println(stockEau2);
        System.out.println(stockEau3);
        System.out.println(stockEau4);
        System.out.println(stockGlobal);
        stockGlobal.ajouter(stockEau1);
        System.out.println(stockGlobal);
        stockGlobal.ajouter(stockEau2);
        System.out.println(stockGlobal);
        stockGlobal.ajouter(stockEau3);
        System.out.println(stockGlobal);
        stockGlobal.ajouter(stockEau4);
        System.out.println(stockGlobal);
        try {
        	stockGlobal.reduireQuantite(0,21);
        } catch (Exception e) {
        	
        }
        System.out.println(stockGlobal);
        stockGlobal.supprimer(stockEau4);
        System.out.println(stockGlobal);
        System.out.println(client1);
        System.out.println(client2);
        System.out.println(client3);
        System.out.println(client4);
        client1.setAdresse(adresse6);
        System.out.println(client1);
        System.out.println(ligne4);
        System.out.println(ligne5);
        System.out.println(ligne3);
        System.out.println(tabLignes21);
        System.out.println(cmd1);
        cmd1.ajouterCommande(ligne4);
        cmd1.ajouterCommande(ligne5);
        cmd1.ajouterCommandes(tabLignes21);
        cmd1.ajouterCommande(ligne3);
        System.out.println(cmd1);
    }
}

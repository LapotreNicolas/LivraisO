package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EntrepriseVenteEau {
    public static final int MAX_EMPLOYES=250;
    public static final int MAX_ENTREPOT=20;
    private final String SIRET;
    private String nom;
    private int nbEmployes;
    private ObservableList<Employe> employes;
    private StockGlobal stockGlobal; // pour les vues
    private ObservableList<Client> clients; // pour les vues
    private ObservableList<Commande> commandes; // pour les vues
    private double disponibilites;
    private boolean endette;
    
    @Override
	public int hashCode() {
		return Objects.hash(SIRET, disponibilites, employes, endette, stockGlobal, nbEmployes, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntrepriseVenteEau other = (EntrepriseVenteEau) obj;
		return Objects.equals(SIRET, other.SIRET);
	}



	public EntrepriseVenteEau(String siret,String nom, ObservableList<Employe> employes) {
        this.SIRET = siret;
        this.nom = nom;
        this.nbEmployes = employes.size();
        this.employes = employes;
        this.stockGlobal = new StockGlobal();
        this.clients = FXCollections.observableArrayList();
        this.commandes = FXCollections.observableArrayList();
        this.disponibilites=0;
        this.endette=false;
    }

    public EntrepriseVenteEau(String siret, String nom){
        this(siret,nom,FXCollections.observableArrayList());
    }

    // GETTERS

    public String getSIRET() {
        return SIRET;
    }

    public String getNom() {
        return nom;
    }

    public int getNbEmployes() {
        return nbEmployes;
    }

    public boolean getEndette() {
    	return endette;
    }
    //SETTERS

    public void setNom(String nom) {
        this.nom = nom;
    }

    //Méthodes

    public void embaucher(Employe employe){
        this.employes.add(employe);
        nbEmployes++;
    }

    public int rechercheEmploye(Employe employe){
        for(int i=0; i<this.nbEmployes;i++) {
            if (this.employes.get(i).equals(employe)) {
                return i;
            }
        }
        return -1;
    }

    public void licencier(Employe employe){
        if (rechercheEmploye(employe)>=0){
            this.employes.remove(employe);
            nbEmployes--;
        }
    }

    /* Réduit les disponibilités de l'entreprise du montant du virement
     * @param virement le montant du virement effectué
     */
    public void effectueVirement(double virement){
        this.disponibilites-=virement;
        if(this.disponibilites < 0){
            this.endette = true;
        }
    }

    /* Augmente les disponibilités de l'entreprise du montant du virement
     * @param virement le montant du virement reçu
     */
    public void recoisVirement(double virement){
        disponibilites+=virement;
        if(this.endette && disponibilites>=0){
            this.endette = false;
        }
    }

    public void enregistrerClient(Client client){
        this.clients.add(client);
    }

    public int rechercheClient(Client client){
        for(int i=0 ; i< this.clients.size() ;i++) {
            if (this.clients.get(i).equals(client)) {
                return i;
            }
        }
        return -1;
    }

    public void supprimerClient(Client client){
        if (rechercheClient(client)>=0){
            this.clients.remove(client);
        }
    }    

    public void enregistrerCommande(Commande commande){
        this.commandes.add(commande);
    }

    public int rechercheCommande(Commande commande){
        for(int i=0 ; i< commandes.size() ;i++) {
            if (this.commandes.get(i).equals(commande)) {
                return i;
            }
        }
        return -1;
    }

    public void supprimerCommande(Commande commande){
        if (rechercheCommande(commande)>=0){
            this.commandes.remove(commande);
        }
    }
    
    public void achatStock(StockEau stockEau) {
    	this.stockGlobal.ajouter(stockEau);
    }
    
    public int rechercherStock(StockEau stockEau) {
    	return this.stockGlobal.recherche(stockEau);
    }
    
    public void venteStock(int indice, int quantite) throws Exception {
    	try {
    		this.stockGlobal.reduireQuantite(indice, quantite);
    	} catch (Exception e) {
    		
    	}
    }
    
    public void supprimerStock(StockEau stockEau) {
    	this.stockGlobal.supprimer(stockEau);
    }
    /* Méthode qui renvoie l'ensemble des attributs de l'objet de la classe EntrepriseVenteEau
     * @return une chaine de caractères qui correspond à l'ensemble des attributs de l'objet désigné
     */
    @Override
    public String toString(){
        String string = "Entreprise : " + this.nom + "\nSIRET : " + this.SIRET + "\nPossède " + this.nbEmployes+" Employés\nListe des employés :";
        if (nbEmployes == 0) {
        	string += "\n\tpas d'employé";
        } else {
        	for (Employe employe : employes) {
        		string += "\n\t- " + employe.toString();
        	}
        }
        string += "\n" + this.stockGlobal.toString() + "\nListe des clients :";
        if (clients.size() == 0) {
        	string += "\n\tpas de client";
        } else {
        	for (Client client : clients) {
        		string += "\n\t- " + client.toString();
        	}
        }
        string += "\nListe des commandes :";
        if (nbEmployes == 0) {
        	string += "\n\tpas de commande";
        } else {
        	for (Commande commande : commandes) {
        		string += "\n\t- " + commande.toString();
        	}
        }
        return string + "\n" + this.disponibilites+" € en disponibilités\nEndetté ? "+this.endette;
    }
}

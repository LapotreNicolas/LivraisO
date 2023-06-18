package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe qui crée des instances de d'entreprises proposant comme service la vente d'eau.
 * @author nicolas.lapotre
 */
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
	/**
	 * Méthode qui vérifie la similarité entre l'instance qui l'appelle et l'objet entré en paramètre.
	 * @param obj L'objet comparé à l'instance qui appelle la fonction
	 */
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

	/**
	 * Constructeur d'instances de la classe.
	 * @param siret     le code siret de l'entreprise
	 * @param nom       le nom de l'entreprise
	 * @param employes  la liste des employés de l'entreprise
	 */
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

    /**
     * Méthode qui ajoute un employé (saisi en paramètre) au tableau d'employe
     * @param employe l'intance de la classe employé que l'on souhaite ajouter au tableau
     * @see Employe
     */
    public void embaucher(Employe employe){
        this.employes.add(employe);
        nbEmployes++;
    }

    /**
     * Méthode qui recherche un employé (saisi en paramètre) dans le tableau d'employés et renvois son index de position ou -1 s'il n'existe pas. 
     * @param employe l'employé que l'on recherche dans le tableau
     * @return l'index de position de l'empoyé dans le tableau, ou -1 s'il n'existe pas
     * @see Employe
     */
    public int rechercheEmploye(Employe employe){
        for(int i=0; i<this.nbEmployes;i++) {
            if (this.employes.get(i).equals(employe)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Méthode qui retire un employé sais en paramètre du tableau d'employés.
     * @param employe l'employé que l'on souhaite retirer du tableau
     * @see Employe
     */
    public void licencier(Employe employe){
        if (rechercheEmploye(employe)>=0){
            this.employes.remove(employe);
            nbEmployes--;
        }
    }

    /** Réduit les disponibilités de l'entreprise du montant du virement
     * @param virement le montant du virement effectué
     */
    public void effectueVirement(double virement){
        this.disponibilites-=virement;
        if(this.disponibilites < 0){
            this.endette = true;
        }
    }

    /** Augmente les disponibilités de l'entreprise du montant du virement
     * @param virement le montant du virement reçu
     */
    public void recoisVirement(double virement){
        disponibilites+=virement;
        if(this.endette && disponibilites>=0){
            this.endette = false;
        }
    }

    /**
     * Méhtode qui ajoute un client sais en paramètre au tableaux de clients
     * @param client le client à ajouter dans le tableau de clients "clients"
     * @see Client
     */
    public void enregistrerClient(Client client){
        this.clients.add(client);
    }

    /**
     * Méthode qui recherche un clietn saisi en paramètre dans le tableau de clients et renvois son index de position (s'il existe).
     * @param client
     * @return l'index de position du client recherché dans le tableau. si l'index est -1, le client n'existe pas
     * @see Client
     */
    public int rechercheClient(Client client){
        for(int i=0 ; i< this.clients.size() ;i++) {
            if (this.clients.get(i).equals(client)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Méthode qui retire un client sais en paramètre du tableau de clients.
     * @param client le client que l'on souhaite retirer du tableau.
     * @see Client
     */
    public void supprimerClient(Client client){
        if (rechercheClient(client)>=0){
            this.clients.remove(client);
        }
    }    

    /**
     * Méthode qui sert à enregistrer un commande saisie en paramètre dans le tableau de commandes.
     * @param commande la commande que l'on souhaite enregistrer dans le tableau de commandes
     * @see Commande
     */
    public void enregistrerCommande(Commande commande){
        this.commandes.add(commande);
    }

    /**
     * Méthode qui recherche une commande (saisie en paramètre) dans le tableau de commande et renvoie son index de position, ou -1 s'il n'existe pas
     * @param commande la commande recherchée dans le tableau des commandes
     * @return l'index de position de la commande dans le tableau, ou -1 s'il n'existe pas
     * @see Commande
     */
    public int rechercheCommande(Commande commande){
        for(int i=0 ; i< commandes.size() ;i++) {
            if (this.commandes.get(i).equals(commande)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Méthode qui retire une commande saisie en paramètre du tableau de commandes.
     * @param commande que l'on veux retirer du tableau de commandes
     * @see Commande
     */
    public void supprimerCommande(Commande commande){
        if (rechercheCommande(commande)>=0){
            this.commandes.remove(commande);
        }
    }
    
    /**
     * Méthode qui ajoute un stock d'eau dans le tableau de stock d'eau de l'instance.
     * @param commande que l'on veux ajouter dans le tableau de commandes
     * @see StockEau
     */
    public void achatStock(StockEau stockEau) {
    	this.stockGlobal.ajouter(stockEau);
    }
    
    /**
     * Méthode qui recherche un stock d'eau dans le tableau de l'instance et renvoie l'index de sa position dans le tableau, ou -1 s'il n'existe pas.
     * @param commande que l'on recherche dans le tableau
     * @return l'index de la position du stock eau recherché dans le tableau, ou -1 s'il n'existe pas.
     * @see StockEau
     */
    public int rechercherStock(StockEau stockEau) {
    	return this.stockGlobal.recherche(stockEau);
    }
    
    /**
     * Méthode qui retire une commande saisie en paramètre du tableau de commandes.
     * @param commande que l'on veux retirer du tableau de commandes
     * @see StockEau
     */
    public void venteStock(int indice, int quantite) throws Exception {
    	try {
    		this.stockGlobal.reduireQuantite(indice, quantite);
    	} catch (Exception e) {
    		
    	}
    }
    
    /**
     * Méthode qui retire un stock d'eau entré en paramètre du tableau.
     * @param stockEau le stock d'eau que l'on veux retirer du tableau
     * @see StockEau
     */
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

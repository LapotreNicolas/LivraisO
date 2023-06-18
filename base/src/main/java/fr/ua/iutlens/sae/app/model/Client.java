package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

/**
 * Classe abstraite qui est utilisée par définir les points communs entre les différents clients
 * @see ClientEntreprise
 * @see ClientEtablissementPublic
 * @see ClientParticulier
 * @author jules.langagne
 */
public abstract class Client{

	private static int compteur = 0;
    private int code;
    private String dateInscription;
    private Adresse adresse;
    private String numTelephone;
    private String adresseMail;
    protected int ptsFidelite;
    protected double resteAchatFidel;

    //CONSTRUCTEURS
    
    protected Client(String dateInscrisption, Adresse adresse, String numTel, String mail){
        compteur ++;
        this.code = compteur;
        this.dateInscription = dateInscrisption;
        this.adresse = adresse;
        this.numTelephone = numTel;
        this.adresseMail = mail;
        this.ptsFidelite = 0;
        this.resteAchatFidel = 0;
    }
    
    //GETTERS
    
    public int getCode() {return this.code;}

    public String getDateInscription(){return this.dateInscription;}

    public Adresse getAdresse(){return this.adresse;}

    public String getNumTelephone(){return this.numTelephone;}

    public String getAdresseMail(){return this.adresseMail;}

    public int getPtsFidelite(){return this.ptsFidelite;}

    public double getResteAchatFidel(){return this.resteAchatFidel;}
    
    public abstract String getTypeClient();
    
    //SETTERS
    
    public void setAdresse(Adresse adresse){this.adresse = adresse;}

    public void setNumTelephone(String numTel){this.numTelephone = numTel;}

    public void setAdresseMail(String mail){this.adresseMail = mail;}

    //Méthodes
    
    /** En cas de remboursement, retire les points de fidélité équivalents au compte du client. 
     * @param points le nombre de points de fidélité à retirer
     * @see Paiement
     */
    public void retraitPointsFidelite(int points){
    	this.ptsFidelite = this.ptsFidelite - points;
    	if(ptsFidelite < 0) {
    		ptsFidelite = 0;
    	}
    }

    /** Lors d'un achat ajoute le nombre de points de fidélité equivalents au compte du client 
     * @param achat le prix de l'achat
     */
    public abstract void ajoutPointsFidelite(double achat);
<<<<<<< HEAD
    
    /* Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe Client
=======

    /** Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe Client
>>>>>>> main
     * @return l'ensemble des attributs de l'objet de la classe Client
     */
    @Override
    public String toString(){
        return "\n------------------------------------\n\tCode : "+this.code+"\tInscrit en : "+this.dateInscription+"\tMail : "+this.adresseMail+"\n\tTelephone : "+this.numTelephone+"\tAdresse : "+this.adresse+"\n\tPoints de fidélité : "+this.ptsFidelite;
    }
}

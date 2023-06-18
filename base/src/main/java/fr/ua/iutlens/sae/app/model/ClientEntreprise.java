package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

/**
 * Classe héritant de la classe abstraite Client. Définit les Entreprises qui font appel aux services de l'entreprise.
 * @see Client
 * @author timeo.quehen
 */
public class ClientEntreprise extends Client{
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(SIRET, TRANCHE_ACHAT, nom);
		return result;
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
		ClientEntreprise other = (ClientEntreprise) obj;
		return Objects.equals(SIRET, other.SIRET) && Objects.equals(nom, other.nom);
	}

	private String nom;
    private final String SIRET;
    private static final int TRANCHE_ACHAT = 1000;

    //CONSTRUCTEUR
    
    public ClientEntreprise(String dateInscription ,Adresse adresse, String numTel, String mail, String nom, String siret){
        super(dateInscription,adresse,numTel,mail);
        this.nom=nom;
        this.SIRET=siret;
    }

    //SETTERS
    
    /**
     * Méthode qui renvois le nom de l'instance qui l'appelle.
     * @return String
     */
    public String getNom(){return this.nom;}

    /**
     * Méthode qui renvois le code SIRET de l'instance qui l'appelle
     * @return String
     */
    public String getSIRET(){return this.SIRET;}
    
    /**
     * Méthode qui renvois le type de client qu'est client entreprise. A chque fois : "entreprise"
     */
    public String getTypeClient(){
        return "entreprise";
    }

    //Méthodes
    
    /**
     * Méthode qui modifie le compte fidèlité du client lorsqu'il effectue un achat (saisi en paramètre) selon le montant dépensé
     * A chaque fois que la Tranche d'achat est atteinte, les points de fidèlités sont incrémentés.
     * @param achat le montant de l'achat
     */
    public void ajoutPointsFidelite(double achat){
        achat += resteAchatFidel;
        while(achat >= TRANCHE_ACHAT){
            ptsFidelite += 10;
            achat -= TRANCHE_ACHAT;
        }
        resteAchatFidel = achat;
    }

    @Override
    /**
     * Méthode qui transcrit les attributs de l'instance qui appelle la fonction en chaine de caractères
     * @return une chaine de caractères qui correspond aux attributs de l'instance quia appelle la fonction 
     */
    public String toString(){
        return "\n\tClient Entreprise"+super.toString()+"\n\t Nom : "+this.nom+"\tSIRET : "+this.SIRET;
    }
}

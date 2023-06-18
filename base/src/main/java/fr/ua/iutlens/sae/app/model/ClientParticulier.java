package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

/**
 * Classe héritant de la classe abstraite Client. Définit les particuliers qui font appel aux services de l'entreprise
 * @see Client
 * @author timeo.quehen
 */
public class ClientParticulier extends Client{
    private String nom;
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(TRANCHE_ACHAT, nom, prenom);
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientParticulier other = (ClientParticulier) obj;
		return Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom);
	}

	private String prenom;
    private static final int TRANCHE_ACHAT = 100;

    //CONSTRUCTEURS
    
    public ClientParticulier(String dateInscription, Adresse adresse, String numTel, String mail, String nom, String prenom){
        super(dateInscription,adresse,numTel,mail);
        this.nom=nom;
        this.prenom=prenom;
    }

    //GETTERS
    
    public String getNom(){return this.nom;}

    public String getPrenom(){return this.prenom;}

    public String getTypeClient(){
        return "particulier";
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
        return "\n\tClient Particulier"+super.toString()+"\n\t Nom : "+this.nom+"\tPrénom : "+this.prenom;
    }
}

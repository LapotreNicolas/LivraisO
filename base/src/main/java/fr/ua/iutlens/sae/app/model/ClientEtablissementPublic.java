package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

/**
 * Classe héritant de la classe abstraite Client. Définit les Etablissements publics qui font appel aux services de l'entreprise
 * @see Client
 * @author timeo.quehen
 */
public class ClientEtablissementPublic extends Client{
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(TRANCHE_ACHAT, nom, type);
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
		ClientEtablissementPublic other = (ClientEtablissementPublic) obj;
		return Objects.equals(nom, other.nom) && type == other.type;
	}

	private String nom;
    public enum Type {EPIC,EPA,EPSCT}
    private final Type type;
    private static final int TRANCHE_ACHAT = 500;

    //CONSTRUCTEURS
    
    public ClientEtablissementPublic(String dateInscription ,Adresse adresse, String numTel, String mail, String nom, Type type){
        super(dateInscription,adresse,numTel,mail);
        this.nom=nom;
        this.type = type;
    }

    //GETTERS
    
    public String getNom(){return this.nom;}

    public Type getType(){return this.type;}


    public String getTypeClient(){
        return "établissement publique";
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
        return "\n\tClient Etablissement Publique"+super.toString()+" Publique\n\tNom : "+this.nom+"\ttype : "+this.type;
    }
}

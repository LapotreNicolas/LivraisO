package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

/**
 * Classe qui génère des instances de lignes de commandes
 * @author nicolas.lapotre
 */
public class LigneDeCommande {
	private static int compteur = 0;
    private int code;
    private Eau eau;
    private int quantite;

    //CONSTRUCTEUR
    
    @Override
	public int hashCode() {
		return Objects.hash(eau, quantite);
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
		LigneDeCommande other = (LigneDeCommande) obj;
		return Objects.equals(eau, other.eau) && quantite == other.quantite;
	}

	/**
	 * Constructeur de la classe LigneDeCommande
     * @param  eau la marque d'eau commandée,quantite nombre de bouteilles de la commande
     * @return les attributs eau et quantite
     * @see eau
     */
    public LigneDeCommande(Eau eau, int quantite) {
    	this.code = compteur++;
        this.eau = eau;
        this.quantite = quantite;
    }
    
    //GETTERS
    public int getCode() {
		return this.code;
	}
    
    public Eau getEau(){
        return eau;
    }
    public int getQuantite(){
        return quantite;
    }

    //Méthode
    
    @Override
    /**
     * Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe Entrepot
     * @return l'ensemble des attributs de l'objet de la classe LigneDeCommande
     */
    public String toString() {
        return "LigneDeCommande{" +
                "eau=" + eau.toString() +
                ", quantite=" + quantite +
                '}';
    }
}
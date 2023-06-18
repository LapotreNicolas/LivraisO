package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

/**
 * Classe qui génère des instances d'eau.
 * @author nicolas.lapotre
 */
public class Eau {

    @Override
	public int hashCode() {
		return Objects.hash(catEau, identifiant, marque, prix);
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
		Eau other = (Eau) obj;
		return  identifiant == other.getIdentifiant();
	}

	private static int comptId = 0;
    private int identifiant;
    private String marque;
    public enum Categorie {EAU_PLATE, EAU_GAZEUSE}
    private Categorie catEau;
    private double prix;

    /**
     * Le constructeur de la classe Eau.
     * Chaque objet possède comme attribut un identifiant, une marque, une catégorie et un prix.
     * L'identifiant s'auto-incrémente.  
     * @param marque la marque de l'eau
     * @param catEau la catégorie de l'eau (EAU_PLATE / EAU_GAZEUSE)
     * @prama prix   le prix de l'eau (de type double)
     */
    public Eau(String marque,Categorie catEau, double prix){
        this.marque = marque;
        this.catEau = catEau;
        this.prix = prix;
        this.identifiant = comptId++;
    }

    // Getters
    
    /**
     * Renvoie l'identifiant de l'objet de la classe Eau
     * @return l'identifiant de l'objet
     */
    public int getIdentifiant(){
        return identifiant;
    }
    
    /**
     * Renvoie la marque de l'objet de la classe Eau
     * @return la marque de l'objet
     */
    public String getMarque(){
        return marque;
    }
    
    /**
     * Renvoie la catégorie de l'objet de la classe Eau
     * @return la catégorie de l'objet
     */
    public Categorie getCatEau(){
        return catEau;
    }
    
    /**
     * Renvoie le prix de l'objet de la classe Eau
     * @return le prix de l'objet
     */
    public double getPrix(){
        return prix;
    }

    // Setter
    
    /**
     * Modifie le prix de l'objet de la classe Eau
     * @param prix le nouveau prix de l'objet
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    /**
     * Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe Eau
     * @return l'ensemble des attributs de l'objet de la classe Eau
     */
    public String toString() {
        return "marque : " + marque + ", categorie : " + catEau + ", prix : " + prix;
    }
}

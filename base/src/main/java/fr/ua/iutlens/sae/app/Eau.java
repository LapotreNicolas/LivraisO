package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class Eau {

    private static int comptId = 0;
    private int identifiant;
    private String marque;
    public enum Categorie {EAU_PLATE, EAU_GAZEUSE};
    private Categorie catEau;
    private double prix;

    public Eau(String marque,Categorie catEau, double prix){
        this.marque = marque;
        this.catEau = catEau;
        this.prix = prix;
        this.identifiant = comptId++;
    }

    // Getters
    public int getIdentifiant(){
        return identifiant;
    }
    public String getMarque(){
        return marque;
    }
    public Categorie getCatEau(){
        return catEau;
    }
    public double getPrix(){
        return prix;
    }

    // Setter

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Equal

    public boolean equals(Eau eau) {
        return this.identifiant == eau.getIdentifiant();
    }

    @Override
    public String toString() {
        return "marque : " + marque + ", catégorie : " + catEau + ", prix : " + prix;
    }

	@Override
	public int hashCode() {
		return Objects.hash(catEau, identifiant, marque, prix);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eau other = (Eau) obj;
		return catEau == other.catEau && identifiant == other.identifiant && Objects.equals(marque, other.marque)
				&& Double.doubleToLongBits(prix) == Double.doubleToLongBits(other.prix);
	}
}

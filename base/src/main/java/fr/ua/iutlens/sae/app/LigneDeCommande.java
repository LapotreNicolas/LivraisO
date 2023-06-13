package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class LigneDeCommande {
    private Eau eau;
    private int quantite;

    //CONSTRUCTEUR
    
    @Override
	public int hashCode() {
		return Objects.hash(eau, quantite);
	}

	@Override
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

	/* Constructeur de la classe LigneDeCommande
     * @param  eau la marque d'eau commandée,quantite nombre de bouteilles de la commande
     * @return les attributs eau et quantite
     * @see eau
     */
    public LigneDeCommande(Eau eau, int quantite) {
        this.eau = eau;
        this.quantite = quantite;
    }
    
    //GETTERS
    
    public Eau getEau(){
        return eau;
    }
    public int getQuantite(){
        return quantite;
    }

    //Méthode
    
    @Override
    public String toString() {
        return "LigneDeCommande{" +
                "eau=" + eau +
                ", quantite=" + quantite +
                '}';
    }
}
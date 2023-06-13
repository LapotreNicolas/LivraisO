package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class LigneDeCommande {
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

	private Eau eau;
    private int quantite;

    public LigneDeCommande(Eau eau, int quantite) {
        this.eau = eau;
        this.quantite = quantite;
    }
    public Eau getEau(){
        return eau;
    }
    public int getQuantite(){
        return quantite;
    }

    @Override
    public String toString() {
        return "eau : " + eau + ", quantite : " + quantite;
    }
}
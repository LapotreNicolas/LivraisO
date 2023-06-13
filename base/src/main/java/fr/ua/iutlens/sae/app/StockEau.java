package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class StockEau{
    @Override
	public int hashCode() {
		return Objects.hash(eau, entrepot, quantite);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockEau other = (StockEau) obj;
		return Objects.equals(eau, other.eau) && Objects.equals(entrepot, other.entrepot) && quantite == other.quantite;
	}

	private Eau eau;
    private Entrepot entrepot;
    private int quantite;

    public StockEau(Eau eau, Entrepot entrepot, int quantite){
        this.eau = eau;
        this.entrepot = entrepot;
        this.quantite = quantite;
    }

    public Eau getEau(){return this.eau;}

    public Entrepot getEntrepot(){return this.entrepot;}

    public int getQuantite(){return this.quantite;}

    public void setEntrepot(Entrepot entrepot){
        this.entrepot = entrepot;
    }

    public void setQuantite(int quantite){
        this.quantite = quantite;
    }

    public boolean equals(StockEau stockEau) {
        return (this.eau.equals(stockEau.getEau()) && this.entrepot.equals(stockEau.getEntrepot()));
    }

    @Override
    public String toString(){
        return "Stock de "+this.quantite+" caisses de "+this.eau+" dans l'entrepôt "+this.entrepot+".";
    }
}

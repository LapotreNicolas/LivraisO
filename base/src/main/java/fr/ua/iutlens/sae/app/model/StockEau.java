package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

/**
 * Classe qui génère des instances de stock d'eau stockée dans un entrepot
 * @author timeo.quehen
 * @see Eau
 * @see Entrepot
 */
public class StockEau{
	
    @Override
	public int hashCode() {
		return Objects.hash(eau, entrepot, quantite);
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
		StockEau other = (StockEau) obj;
		return Objects.equals(eau, other.eau) && Objects.equals(entrepot, other.entrepot) && quantite == other.quantite;
	}
	
	private static int compteur = 0;
    private int code;
	private Eau eau;
    private Entrepot entrepot;
    private int quantite;

    //CONSTRUCTEURS
    
    public StockEau(Eau eau, Entrepot entrepot, int quantite){
    	this.code = compteur++;
        this.eau = eau;
        this.entrepot = entrepot;
        this.quantite = quantite;
    }

    //GETTERS
    public int getCode() {
		return this.code;
	}
    
    public Eau getEau(){return this.eau;}

    public Entrepot getEntrepot(){return this.entrepot;}

    public int getQuantite(){return this.quantite;}

    //SETTERS
    
    public void setEntrepot(Entrepot entrepot){
        this.entrepot = entrepot;
    }

    public void setQuantite(int quantite){
        this.quantite = quantite;
    }

    //Méthodes

    @Override
    /**
     * Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe StockEau
     * @return l'ensemble des attributs de l'objet de la classe StockEau
     */
    public String toString(){
        return "Stock de "+this.quantite+" caisses de "+this.eau+" dans l'entrepôt "+this.entrepot+".";
    }
}

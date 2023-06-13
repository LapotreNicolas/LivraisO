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

    //CONSTRUCTEURS
    
    public StockEau(Eau eau, Entrepot entrepot, int quantite){
        this.eau = eau;
        this.entrepot = entrepot;
        this.quantite = quantite;
    }

    //GETTERS
    
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
    
    /* Méthode qui compare l'identifiant de l'objet Eau avec l'identifiant d'un second objet entré en paramètre 
     * @param eau Un objet de la classe Eau
     * @return un booléen répondant à la question : "Les deux identifiants des Eau sont-ils les mêmes ?"
     * @see Eau
     */
    public boolean equals(StockEau stockEau) {
        return (this.eau.equals(stockEau.getEau()) && this.entrepot.equals(stockEau.getEntrepot()));
    }

    /* Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe StockEau
     * @return l'ensemble des attributs de l'objet de la classe StockEau
     */
    @Override
    public String toString(){
        return "Stock de "+this.quantite+" caisses de "+this.eau+" dans l'entrepôt "+this.entrepot+".";
    }
}

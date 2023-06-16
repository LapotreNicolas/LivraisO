package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockGlobal {
    public static final int MAX_STOCK_EAU = 100;
    private ObservableList<StockEau> tabStockEau;
    private int position;

    //CONSTRUCTEURS
    
    public StockGlobal() {
        this.tabStockEau = FXCollections.observableArrayList();
        this.position = 0;
    }

    public ObservableList<StockEau> getTabStockEau() {return this.tabStockEau;}

    //Méthodes
    
    /* Méthode qui recherche l'identifiant de l'objet stockEau dans le tableau de stock.
     * Une fois trouvé, il est renvoyé. Sinon, renvoie -1
     * @param stockEau l'objet recherché de la classe StockEau
     * @return la position de l'objet recherché dans le tableau. s'il n'est pas présent, renvoie -1
     * @see StockEau
     */
    public int recherche(StockEau stockEau) {
        int i = position-1;
        while (i > -1 && ! this.tabStockEau.get(i).equals(stockEau)) i--;
        return i;
    }

    /* Méthode qui ajoute un objet StockEau au tableau de StockGlobal. S'il n'est pas présent, est ajouté à la fin.
     * Sinon la quantité est modifié, en ajoitant la quantité de l'objet en paramètre.
     * @param stockEau l'objet que l'on souhaite ajouter
     */
    public void ajouter(StockEau stockEau) {
        int indice = this.recherche(stockEau);
        if (indice == -1) this.tabStockEau.add(position++, stockEau); // Si l'identifiant est absent
        else this.tabStockEau.get(indice).setQuantite(this.tabStockEau.get(indice).getQuantite() + stockEau.getQuantite());
    }

    /* Recherche et supprime du tableau l'objet StockEau saisi en paramètre
     * @param stockEau un objet de la classe Stockeau
     */
    public void supprimer(StockEau stockEau) {
        int indice = recherche(stockEau);
        position--;
        for (int i = indice ; i < position ; i++) this.tabStockEau.add(i, stockEau);
    }

    /* Réduit la quantité du StockEau à l'indice i saisi en paramètre d'une quantité également saisie en paramètre. 
     * @param indice          un indice du tableau de StockGlobal
     * @param quantiteEnMoins la quantite à retirer du stock à l'indice i
     */
    public void reduireQuantite(int indice, int quantiteEnMoins) throws Exception {
        int quantiteRestante = this.tabStockEau.get(indice).getQuantite() - quantiteEnMoins;
        if (quantiteRestante < 0) throw new Exception("Quantité du stock d'eau inférieur à la quantité à retirer !"); //empêcher la quantité négative
        else this.tabStockEau.get(indice).setQuantite(quantiteRestante);
    }

    /* Trie le tableau selon booléen saisi en paramètre. Possède une surcharge pour effectuer un tri croissant par défaut.
     * @param croissante le façon de trier le tableau : si true, le trie en ordre croissant. Si false, le trie en ordre décroissant.
     */
    public void trier(boolean croissante) {
        int j;
        for (int i = 0 ; i < position ; i++) {
        	StockEau tmp = this.tabStockEau.get(i);
        	this.tabStockEau.remove(tmp);
            j = i;
            while (j > 0 && (this.tabStockEau.get(j-1).getQuantite() > tmp.getQuantite() && croissante || (this.tabStockEau.get(j-1).getQuantite() < tmp.getQuantite() && ! croissante))) {
            	this.tabStockEau.remove(j,--j);
            }
            tabStockEau.add(j, tmp);
        }
    }
    
    public void trier() {
        trier(true);
    }

    @Override
	public int hashCode() {
		return Objects.hash(tabStockEau);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockGlobal other = (StockGlobal) obj;
		return Objects.equals(tabStockEau, other.tabStockEau);
	}

	/* Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe StockGlobal
     * @return l'ensemble des attributs de l'objet de la classe StockGlobal
     */
    @Override
    public String toString() {
        String informations = "Tableau des Stocks d'Eau :";
        if (position == 0) informations += "\n\tpas de stock";
        else {
            for (int i = 0 ; i < position ; i++) informations += "\n\t- " + this.tabStockEau.get(i).toString();
        }
        return informations;
    }
}
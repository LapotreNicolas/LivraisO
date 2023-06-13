package fr.ua.iutlens.sae.app;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StockGlobal {
    private static final int MAX_STOCK_EAU = 100;
    private ObservableList<StockEau> tabStockEau;
    private static int position = 0;

    public StockGlobal() {
        this.tabStockEau = FXCollections.observableArrayList();
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

	public ObservableList<StockEau> getTabStockEau() {return this.tabStockEau;}

    public int recherche(StockEau stockEau) {
        int i = position-1;
        while (i > -1 && ! this.tabStockEau.get(i).equals(stockEau)) i--;
        return i;
    }

    public void ajouter(StockEau stockEau) {
        int indice = this.recherche(stockEau);
        if (indice == -1) {
        	this.tabStockEau.add(stockEau);
        	position++;
    	} else {
        	this.tabStockEau.get(indice).setQuantite(this.tabStockEau.get(indice).getQuantite() + stockEau.getQuantite());
        }
    }

    public void supprimer(StockEau stockEau) {
        int indice = recherche(stockEau);
        position--;
        for (int i = indice ; i < position ; i++) this.tabStockEau.add(i, tabStockEau.get(i+1));
    }


    public void reduireQuantite(int indice, int quantiteEnMoins) {
        int quantiteRestante = this.tabStockEau.get(indice).getQuantite() - quantiteEnMoins;
        if (quantiteRestante < 0) quantiteRestante = 0;
        this.tabStockEau.get(indice).setQuantite(quantiteRestante);
    }

    public void trier(boolean croissante) {
        int j;
        for (int i = 0 ; i < position ; i++) {
            j = i;
            while (j > 0 && (this.tabStockEau.get(j-1).getQuantite() > this.tabStockEau.get(j).getQuantite() || croissante)) {
                StockEau tmp = this.tabStockEau.get(j);
                this.tabStockEau.add(j, tabStockEau.get(j-1));
                this.tabStockEau.add(--j, tmp);
            }
        }
    }

    public void trier() {
        trier(true);
    }

    @Override
    public String toString() {
        String informations = "Tableau des Stocks d'Eau :";
        if (position == 0) informations += "\n\tpas de stock";
        else {
            for (int i = 0 ; i < position ; i++) informations += "\n\t- " + this.tabStockEau.get(i);
        }
        return informations;
    }
}
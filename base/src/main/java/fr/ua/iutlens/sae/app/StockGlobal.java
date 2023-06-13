package fr.ua.iutlens.sae.app;

public class StockGlobal {
    private static final int MAX_STOCK_EAU = 100;
    private StockEau[] tabStockEau;
    private static int position = 0;

    public StockGlobal() {
        this.tabStockEau = new StockEau[MAX_STOCK_EAU];
    }

    public StockEau[] getTabStockEau() {return this.tabStockEau;}

    public int recherche(StockEau stockEau) {
        int i = position-1;
        while (i > -1 && ! this.tabStockEau[i].equals(stockEau)) i--;
        return i;
    }

    public void ajouter(StockEau stockEau) {
        int indice = this.recherche(stockEau);
        if (indice == -1) this.tabStockEau[position++] = stockEau;
        else this.tabStockEau[indice].setQuantite(this.tabStockEau[indice].getQuantite() + stockEau.getQuantite());
    }

    public void supprimer(StockEau stockEau) {
        int indice = recherche(stockEau);
        position--;
        for (int i = indice ; i < position ; i++) this.tabStockEau[i] = this.tabStockEau[i+1];
    }


    public void reduireQuantite(int indice, int quantiteEnMoins) {
        int quantiteRestante = this.tabStockEau[indice].getQuantite() - quantiteEnMoins;
        if (quantiteRestante < 0) quantiteRestante = 0;
        this.tabStockEau[indice].setQuantite(quantiteRestante);
    }

    public void trier(boolean croissante) {
        int j;
        for (int i = 0 ; i < position ; i++) {
            j = i;
            while (j > 0 && (this.tabStockEau[j-1].getQuantite() > this.tabStockEau[j].getQuantite() || croissante)) {
                StockEau tmp = this.tabStockEau[j];
                this.tabStockEau[j] = this.tabStockEau[j-1];
                this.tabStockEau[--j] = tmp;
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
            for (int i = 0 ; i < position ; i++) informations += "\n\t- " + this.tabStockEau[i];
        }
        return informations;
    }
}
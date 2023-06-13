package fr.ua.iutlens.sae.app;

public class StockEau{
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

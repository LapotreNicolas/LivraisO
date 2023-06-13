package fr.ua.iutlens.sae.app;

public class LigneDeCommande {
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
package fr.ua.iutlens.sae.app;

public class Entrepot {
    private int code;
    private String nom;
    private Adresse adresse;
    public Entrepot(int code, String nom, Adresse adresse){
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
    }
    public int getCode(){
        return code;
    }
    public String getNom(){
        return nom;
    }
    public Adresse getAdresse(){
        return adresse;
    }

    public boolean equals(Entrepot entrepot) {
        return this.code == entrepot.getCode();
    }

    @Override
    public String toString() {
        return "code : " + code + ", nom : " + nom + ", adresse : " + adresse;
    }
}

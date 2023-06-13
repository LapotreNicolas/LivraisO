package fr.ua.iutlens.sae.app;

import java.util.Objects;

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
	@Override
	public int hashCode() {
		return Objects.hash(adresse, code, nom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrepot other = (Entrepot) obj;
		return Objects.equals(adresse, other.adresse) && code == other.code && Objects.equals(nom, other.nom);
	}
}

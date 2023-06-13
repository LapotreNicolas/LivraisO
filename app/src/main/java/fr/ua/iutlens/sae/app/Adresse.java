package fr.ua.iutlens.sae.app;

public class Adresse {
    private String num;
    private String voie;
    private Commune commune;
    public Adresse(String num, String voie, String insee, String nom, String nomDepartement) {
        this.num = num;
        this.voie = voie;
        this.commune = new Commune(insee, nom, nomDepartement);
    }
    private static class Commune{
        private String insee;
        private String nom;
        private String nomDepartement;
        public Commune(String insee, String nom, String nomDepartement){
            this.insee = insee;
            this.nom = nom;
            this.nomDepartement = nomDepartement;
        }
    }
    public String getAdresse(){
        return num;
    }
    public String getVoie(){
        return voie;
    }
    public Commune getCommune() {
        return commune;
    }
    public String getInsee(){
        return commune.insee;
    }
    public String getNom(){
        return commune.nom;
    }
    public String getNomDepartement(){
        return commune.nomDepartement;
    }

    @Override
    public String toString() {
        return "num : " + num + ", voie : " + voie;
    }
}

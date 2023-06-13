package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class Adresse {
    @Override
	public int hashCode() {
		return Objects.hash(commune, num, voie);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(commune, other.commune) && Objects.equals(num, other.num)
				&& Objects.equals(voie, other.voie);
	}

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
        @Override
		public int hashCode() {
			return Objects.hash(insee, nom, nomDepartement);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Commune other = (Commune) obj;
			return Objects.equals(insee, other.insee) && Objects.equals(nom, other.nom)
					&& Objects.equals(nomDepartement, other.nomDepartement);
		}
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

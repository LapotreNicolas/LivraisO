package fr.ua.iutlens.sae.app.model;

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
    /* Constructeur d'objets appartenant à la classe Adresse.
     * @param num            le numéro dans la rue 
     * @param voie           la rue de l'adresse
     * @param insee          le code insee de la commune
     * @param nom            le nom de la commune
     * @param nomDepartement le nom du département de la commune
     * @see Commune
     */
    public Adresse(String num, String voie, String insee, String nom, String nomDepartement) {
        this.num = num;
        this.voie = voie;
        this.commune = new Commune(insee, nom, nomDepartement);
    }

    protected static class Commune{
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
        /* Constructeur de la sous-classe Commune
         * @param insee          le code insee de la commune
         * @param nom            le nom de la commune
     	 * @param nomDepartement le nom du département de la commune
     	 * @see Adresse
         */
        public Commune(String insee, String nom, String nomDepartement){
            this.insee = insee;
            this.nom = nom;
            this.nomDepartement = nomDepartement;
        }
        
        //Méthode
        
        /* Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe Commune
         * @return l'ensemble des attributs de l'objet de la classe Commune
         */
        @Override
        public String toString() {
        	return "Insee : "+this.insee+" nom : "+this.nom+" nom du département : "+this.nomDepartement;
        }
    }
    
    //GETTERS
    
    /* Renvois un String correspondant au numéro de rue de l'adresse
     * @return le numéro de rue de l'adresse
     */
    public String getNum(){
        return num;
    }
    
    /* Renvois un String correspondant à la rue de l'adresse
     * @return la rue de l'adresse
     */
    public String getVoie(){
        return voie;
    }
    
    /* Renvois une instance de Commune correspondant à la commune de l'adresse
     * La commune est une sous-classe de la classe Adresse qui est définie par son insee, son nom et son département
     * @return les attributs de la commune, instance de la sous-classe Commune de la classe Adresse
     */
    public Commune getCommune() {
        return commune;
    }
    
    /* Renvois un String correspondant à l'insee (identifiant) de la commune
     * @return l'insee de la commune
     */
    public String getInsee(){
        return commune.insee;
    }
    
    /* Renvois un String correspondant au nom de la commune
     * @return le nom de la commune
     */
    public String getNom(){
        return commune.nom;
    }
    
    /* Renvois un String correspondant au nom du département de la commune
     * @return le nom du département de la commune
     */
    public String getNomDepartement(){
        return commune.nomDepartement;
    }

    //Méthodes
    
    /* Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe Adresse
     * @return l'ensemble des attributs de l'objet de la classe Adresse
     */
    @Override
    public String toString() {
        return "num : " + num + ", voie : " + voie +" Commune :"+commune.insee+commune.nom+commune.nomDepartement;
    }
}

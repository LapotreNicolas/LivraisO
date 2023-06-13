package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class Entrepot {
    private int code;
    private String nom;
    private Adresse adresse;
    
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

	/* Constructeur de la classe Entrepot, il initalise pour chaque instance son code, son nom et son adresse selon les valeurs saisies.
     * @param code le code (identifiant) de l'entrepot
     * @param nom le nom de l'entrepot
     * @param adresse l'adresse de l'entrepot. l'adresse est une instance de la classe Adresse
     * @see Adresse
     */
    public Entrepot(int code, String nom, Adresse adresse){
        this.code = code;
        this.nom = nom;
        this.adresse = adresse;
    }
    
    //GETTERS
    
    /* Méthode qui renvois un entier code, correspondant au code de l'entrepot
     * @return le code de l'entrepot
     */
    public int getCode(){
        return code;
    }
    
    /* Méthode qui renvois un String correspondant au nom de l'entreprise
     * @return le nom de l'entreprise
     */
    public String getNom(){
        return nom;
    }
    
    /* Méthode qui renvois l'adresse de l'entrepot (sa localisation) 
     * @return l'adresse de l'entrepot. L'adresse est une instance de la classe Adresse.
     * @see Adresse
     */
    public Adresse getAdresse(){
        return adresse;
    }
    
    //Méthodes

    /* Méthode qui compare le code de l'entrepot actuel avec le code d'un second entrepot entré en paramètre 
     * @param entrepot Un objet de la classe Entrepot
     * @return un booléen répondant à la question : "Les deux codes des entrepots sont-ils les mêmes ?"
     */
    public boolean equals(Entrepot entrepot) {
        return this.code == entrepot.getCode();
    }

    /* Une méthode toString qui renvoie, sous forme de chaine de caractères l'ensemble des attributs de l'objet de la classe Entrepot
     * @return l'ensemble des attributs de l'objet de la classe Entrepot
     */
    @Override
    public String toString() {
        return "code : " + code + ", nom : " + nom + ", adresse : " + adresse;
    }
}

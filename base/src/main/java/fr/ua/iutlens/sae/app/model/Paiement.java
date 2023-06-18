package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

/**
 * Classe qui génère des instance de paiement et leur méthode.
 * @author timeo.quehen
 * @see MethodePaiement
 */
public class Paiement{
    private double montant;
    private MethodePaiement methodePaie;
    //CONSTRUCTEURS
    public Paiement(double montant, MethodePaiement methodePaie){
        this.montant = montant;
        this.methodePaie = methodePaie;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(methodePaie, montant);
	}

	@Override
	/**
	 * Méthode qui vérifie la similarité entre l'instance qui l'appelle et l'objet entré en paramètre.
	 * @param obj L'objet comparé à l'instance qui appelle la fonction
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paiement other = (Paiement) obj;
		return Objects.equals(methodePaie, other.methodePaie)
				&& Double.doubleToLongBits(montant) == Double.doubleToLongBits(other.montant);
	}

	//GETTERS
	
    public double getMontant(){
        return this.montant;
    }

    public MethodePaiement getMethodePaie(){
        return this.methodePaie;
    }
    
    //SETTERS
    
    public void setMethodePaie(MethodePaiement methodePaie){
        this.methodePaie = methodePaie;
    }

    public void setMontant(double montant){
        this.montant = montant;
    }
    
    //Méthode
    
    @Override
    /**
     * Affiche l'ensemble des attributs de l'objet Employé désigné
     * @return Une chaine de caractères String représentant l'ensemble des attributs de l'objet désigné.
     */
    public String toString() {
        return "Paiement{" +
                "montant=" + montant +
                ", methodePaie=" + methodePaie.toString() +
                '}';
    }
}

package fr.ua.iutlens.sae.app.model;

/**
 * Classe qui hérite des méthode de l'interface TraitementPaiement. Elle gère les paiements simples, AKA simple décrémentation.
 * @author jules.langagne
 * @see TraitementPaiement
 */
public class PaiementSimple implements TraitementPaiement {
	
	public PaiementSimple() {}
	
    @Override
    /**
	 * Méthode qui exécute un paiement
     * @param p le paiement que l'on doit exécuter
     * @see Paiement
     */
    public void executePaiement(Paiement p){
        System.out.println("Le paiement de "+ p.getMontant() + "€ a été effectué.");
    }
    
    @Override
    /**
     * Rembourse la somme appopriée suite à l'achet
     * @param p le paiement que l'on doit rembourser
     * @see Paiement
     */
    public void remboursement(Paiement p){
        System.out.println("Le remboursement de "+ p.getMontant() + "€ a été effectué.");
    }
}
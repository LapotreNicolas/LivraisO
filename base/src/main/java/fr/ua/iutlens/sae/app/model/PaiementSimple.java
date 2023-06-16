package fr.ua.iutlens.sae.app.model;

public class PaiementSimple implements TraitementPaiement {
	/* Exécute le paiement
     * @param p le paiement que l'on doit exécuter
     * @see Paiement
     */
	public PaiementSimple() {}
	
    @Override
    public void executePaiement(Paiement p){
        System.out.println("Le paiement de "+ p.getMontant() + "€ a été effectué.");
    }
    /* Rembourse la somme appopriée suite à l'achet
     * @param p le paiement que l'on doit rembourser
     * @see Paiement
     */
    @Override
    public void remboursement(Paiement p){
        System.out.println("Le remboursement de "+ p.getMontant() + "€ a été effectué.");
    }
}
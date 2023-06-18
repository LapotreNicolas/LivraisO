package fr.ua.iutlens.sae.app.model;

/**
 * Interface qui définit les méthodes à implémenter dans les classes de gestion de paiement.
 * @author timeo.quehen
 */
public interface TraitementPaiement{
	
	/**
	 * crée la méthode permettant d'effectuer le paiement
     * @param p le paiement que l'on doit exécuter
     * @see Paiement
     */
    void executePaiement(Paiement p);
    
    /**
     * crée la méthode permettant de rembourser le paiement
     * @param p le paiement que l'on doit rembourser
     * @see Paiement
     */
    void remboursement(Paiement p);
}

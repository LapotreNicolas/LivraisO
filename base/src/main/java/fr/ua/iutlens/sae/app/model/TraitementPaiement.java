package fr.ua.iutlens.sae.app.model;

public interface TraitementPaiement{
	/* crée la méthode permettant d'effectuer le paiement
     * @param p le paiement que l'on doit exécuter
     * @see Paiement
     */
    void executePaiement(Paiement p);
    /* crée la méthode permettant de rembourser le paiement
     * @param p le paiement que l'on doit rembourser
     * @see Paiement
     */
    void remboursement(Paiement p);
}

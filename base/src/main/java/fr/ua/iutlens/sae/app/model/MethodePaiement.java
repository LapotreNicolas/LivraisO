package fr.ua.iutlens.sae.app.model;

public abstract class MethodePaiement{
	/* crée la méthode permettant de payer
     * @param montant la somme que l'on doit payer
     */
    public abstract void payer(double montant);
    /* crée la méthode permettant de rembourser 
     * @param montant la somme à rembourser
     */
    public abstract void rembourser(double montant);
}

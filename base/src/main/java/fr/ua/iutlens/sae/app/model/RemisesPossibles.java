package fr.ua.iutlens.sae.app.model;

/**
 * Interface qui définit les méthodes à implémenter pour les remises d'achats.
 * @author timeo.quehen
 */
public interface RemisesPossibles {
	
	/**
	 * Crée la méthode appliquant la remise sur un achat
     * @param client le client affecté par la remise
     */
    double montantDeLaRemise(Client client);
    
    /**
     * Crée la méthode calculant le nombre de bouteilles offertes à un client
     * @param nbBouteilles le nombre de bouteilles achetées par un client, client le client qui achète les bouteilles
     */
    int nombreBouteillesGratuites(int nbBouteilles, Client client);
}


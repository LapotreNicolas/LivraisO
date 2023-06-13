package fr.ua.iutlens.sae.app;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class Commande implements RemisesPossibles {
    private static final int MAX_COMMANDES = 100;
    private ObservableList<LigneDeCommande> commandes;
    private int pos;

    //CONSTRUCTEUR
    
    public Commande() {
        this.commandes = FXCollections.observableArrayList();
        this.pos = 0;
    }

    //Méthodes
    /* Ajoute une commande
     * @param commande la commande à ajouter
     */
    public void ajouterCommande(LigneDeCommande commande) {
        this.commandes.add(commande);
        pos++;
    }
    /* Ajoutes plusieurs commandes
     * @param commandes le tableau de commandes à ajouter
     */
    public void ajouterCommandes(ObservableList<LigneDeCommande> commandes) {
        if (commandes.size() + pos < MAX_COMMANDES) {
            for (LigneDeCommande commande : commandes) {
                this.commandes.add(commande);
                pos++;
            }
        }
    }
    /* Modifie la ligne de commande précisée
     * @param position position de la ligne de commande demandée, ligneDeCommande la commande qu'il faut modifier
     */
    public void modifierCommande(int position, LigneDeCommande commande) {
        if (position<pos) {
            this.commandes.add(position, commande);
        }
    }
    /* Calcule la remise appliquée sur un achat 
     * @param client le client affecté par la remise
     * @return solde la remise appliquée sur l'achat du client
     * @see client
     */
    @Override
    public double montantDeLaRemise(Client client) {
        double solde = 1;
        int pts = client.getPtsFidelite();
        if (pts >= 100) {
            if (client.getTypeClient().equals("particulier")) {
                solde = 1 - (pts / 10000.0);
                if (solde<0.9) solde = 0.9;
            } else {
                solde = 1 - (pts/100000.0);
                if (solde < 0.9) solde = 0.9;
            }
        }
        return solde;
    }
    
    /* méthode calculant le nombre de bouteilles offertes à un client
     * @param nbBouteilles le nombre de bouteilles achetées par un client, client le client qui achète les bouteilles
     * @return remise le nombre de bouteilles offertes au client
     * @see client
     */
    @Override
    public int nombreBouteillesGratuites(int nbBouteilles,Client client) {
        int remise=0;
        if (client.getTypeClient().equals("particulier")) {
            remise = nbBouteilles / 12;
        } else if (client.getTypeClient().equals("établissement public")) {
            remise = nbBouteilles / 60;
        } else if (client.getTypeClient().equals("entreprise")) {
            remise = nbBouteilles / 120;
        }
        return remise;
    }

    /* Calcul le montant total de la remise et le renvois
     * @param client le client effectuant l'achat
     * @return le montant total
     * @see Client
     */
    public double montantTotal(Client client) {
        double prixTotal = 0;
        for (int i = 0; i < this.commandes.size(); i++) {
            prixTotal += this.commandes.get(i).getEau().getPrix() * (this.commandes.get(i).getQuantite()-nombreBouteillesGratuites(this.commandes.get(i).getQuantite(),client));
        }
        return (prixTotal*(montantDeLaRemise(client)));
    }
@Override
    public String toString() {
        String informations = "Tableau des Commandes :";
        if (pos == 0) informations += "\n\tpas de commande";
        else {
            for (int i = 0 ; i < pos ; i++) informations += "\n\t- " + this.commandes.get(i).toString();
        }
        return informations;
    }

@Override
public int hashCode() {
	return Objects.hash(commandes);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Commande other = (Commande) obj;
	return Objects.equals(commandes, other.commandes);
}
}

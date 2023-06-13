package fr.ua.iutlens.sae.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Commande implements RemisesPossibles {
    private static final int MAX_COMMANDES = 100;
    private ObservableList<LigneDeCommande> commandes;
    private static int pos;

    public Commande() {
        this.commandes = FXCollections.observableArrayList();
    }

    public void ajouterCommande(LigneDeCommande commande) {
        if (this.pos < MAX_COMMANDES) {
        	this.commandes.add(commande);
        	pos++;
        }
    }

    public void ajouterCommandes(ObservableList<LigneDeCommande> commandes) {
        if (commandes.size() + pos <= MAX_COMMANDES) {
            for (LigneDeCommande commande : commandes) {
                this.commandes.add(commande);
                pos++;
            }
        }
    }

    public void modifierCommande(int position, LigneDeCommande commande) {
        if (position < pos) {
        	this.commandes.add(position, commande);
        }
    }

    public double montantDeLaRemise(Client client) {
        double solde = 1;
        int pts = client.getPtsFidelite();
        if (pts >= 100) {
            if (client.getTypeClient() == "particulier") {
                solde = 1- (pts / 10000);
                if (solde<0.9) solde = 0.9;
            } else {
                solde = 1- (pts/100000);
                if (solde < 0.9) solde = 0.9;
            }
        }
        return solde;
    }

    public int nombreBouteillesGratuites(int nbBouteilles,Client client) {
        int remise=0;
        if (client.getTypeClient() == "particulier") {
            remise = nbBouteilles / 12;
        } else if (client.getTypeClient() == "établissement public") {
            remise = nbBouteilles / 60;
        } else if (client.getTypeClient() == "entreprise") {
            remise = nbBouteilles / 120;
        }
        return remise;
    }

    public double montantTotal(Client client) {
        double prixTotal = 0;
        for (int i = 0; i < this.commandes.size(); i++) {
            prixTotal += this.commandes.get(i).getEau().getPrix() * (this.commandes.get(i).getQuantite()-nombreBouteillesGratuites(this.commandes.get(i).getQuantite(),client));
        }
        return prixTotal - (prixTotal*(montantDeLaRemise(client)));
    }

    @Override
    public String toString() {
        String informations = "Tableau des Commandes :";
        if (pos == 0) informations += "\n\tpas de commande";
        else {
            for (int i = 0 ; i < pos ; i++) informations += "\n\t- " + this.commandes.get(i);
        }
        return informations;
    }
}
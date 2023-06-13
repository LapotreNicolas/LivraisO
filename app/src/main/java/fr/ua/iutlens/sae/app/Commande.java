package fr.ua.iutlens.sae.app;

public class Commande implements RemisesPossibles {
    private static final int MAX_COMMANDES = 100;
    private LigneDeCommande[] commandes;
    private static int pos;

    public Commande() {
        this.commandes = new LigneDeCommande[MAX_COMMANDES];
    }

    public void ajouterCommande(LigneDeCommande commande) {
        this.commandes[pos++] = commande;
    }

    public void ajouterCommandes(LigneDeCommande[] commandes) {
        if (commandes.length + pos < MAX_COMMANDES) {
            for (LigneDeCommande commande : commandes) {
                this.commandes[pos++] = commande;
            }
        }
    }

    public void modifierCommande(int position, LigneDeCommande commande) {
        if (position<pos) {
            this.commandes[position]=commande;
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
        for (int i = 0; i < this.commandes.length; i++) {
            prixTotal += this.commandes[i].getEau().getPrix() * (this.commandes[i].getQuantite()-nombreBouteillesGratuites(this.commandes[i].getQuantite(),client));
        }
        return prixTotal - (prixTotal*(montantDeLaRemise(client)));
    }

    @Override
    public String toString() {
        String informations = "Tableau des Commandes :";
        if (pos == 0) informations += "\n\tpas de commande";
        else {
            for (int i = 0 ; i < pos ; i++) informations += "\n\t- " + this.commandes[i];
        }
        return informations;
    }
}
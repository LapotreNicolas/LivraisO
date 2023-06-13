package fr.ua.iutlens.sae.app;

public class PaiementSimple implements TraitementPaiement {

    @Override
    public void executePaiement(Paiement p){
        System.out.println("Le paiement de "+ p.getMontant() + "€ a été effectué.");
    }
    @Override
    public void remboursement(Paiement p){
        System.out.println("Le remboursement de "+ p.getMontant() + "€ a été effectué.");
    }
}
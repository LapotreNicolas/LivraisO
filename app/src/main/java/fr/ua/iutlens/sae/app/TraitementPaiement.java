package fr.ua.iutlens.sae.app;

public interface TraitementPaiement{
    void executePaiement(Paiement p);
    void remboursement(Paiement p);
}

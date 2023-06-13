package fr.ua.iutlens.sae.app;

public abstract class MethodePaiement{
    public abstract void payer(double montant);
    public abstract void rembourser(double montant);
}

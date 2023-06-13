package fr.ua.iutlens.sae.app;

public class Paiement{
    private double montant;
    private MethodePaiement methodePaie;

    public Paiement(double montant, MethodePaiement methodePaie){
        this.montant = montant;
        this.methodePaie = methodePaie;
    }

    public double getMontant(){
        return this.montant;
    }

    public MethodePaiement getMethodePaie(){
        return this.methodePaie;
    }

    public void setMethodePaie(MethodePaiement methodePaie){
        this.methodePaie = methodePaie;
    }

    public void setMontant(double montant){
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "montant=" + montant +
                ", methodePaie=" + methodePaie +
                '}';
    }
}

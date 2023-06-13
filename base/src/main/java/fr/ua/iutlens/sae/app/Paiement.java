package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class Paiement{
    @Override
	public int hashCode() {
		return Objects.hash(methodePaie, montant);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paiement other = (Paiement) obj;
		return Objects.equals(methodePaie, other.methodePaie)
				&& Double.doubleToLongBits(montant) == Double.doubleToLongBits(other.montant);
	}

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

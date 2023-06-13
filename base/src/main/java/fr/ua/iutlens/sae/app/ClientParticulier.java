package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class ClientParticulier extends Client{
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(TRANCHE_ACHAT, nom, prenom);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientParticulier other = (ClientParticulier) obj;
		return TRANCHE_ACHAT == other.TRANCHE_ACHAT && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom);
	}

	private String nom;
    private String prenom;
    private final int TRANCHE_ACHAT = 100;

    public ClientParticulier(String dateInscription, Adresse adresse, String numTel, String mail, String nom, String prenom){
        super(dateInscription,adresse,numTel,mail);
        this.nom=nom;
        this.prenom=prenom;
    }

    public String getNom(){return this.nom;}

    public String getPrenom(){return this.prenom;}

    public void ajoutPointsFidelite(double achat){
        achat += resteAchatFidel;
        while(achat >= TRANCHE_ACHAT){
            ptsFidelite += 10;
            achat -= TRANCHE_ACHAT;
        }
        resteAchatFidel = achat;
    }

    public String getTypeClient(){
        return "particulier";
    }

    @Override
    public String toString(){
        return "\n\tClient Particulier"+super.toString()+"\n\tNom : "+this.nom+"\tPrénom : "+this.prenom;
    }
}

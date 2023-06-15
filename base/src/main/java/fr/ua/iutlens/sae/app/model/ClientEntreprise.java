package fr.ua.iutlens.sae.app.model;

import java.util.Objects;

public class ClientEntreprise extends Client{
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(SIRET, TRANCHE_ACHAT, nom);
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
		ClientEntreprise other = (ClientEntreprise) obj;
		return Objects.equals(SIRET, other.SIRET) && Objects.equals(nom, other.nom);
	}

	private String nom;
    private final String SIRET;
    private static final int TRANCHE_ACHAT = 1000;

    //CONSTRUCTEUR
    
    public ClientEntreprise(String dateInscription ,Adresse adresse, String numTel, String mail, String nom, String siret){
        super(dateInscription,adresse,numTel,mail);
        this.nom=nom;
        this.SIRET=siret;
    }

    //SETTERS
    
    public String getNom(){return this.nom;}

    public String getSIRET(){return this.SIRET;}
    
    public String getTypeClient(){
        return "entreprise";
    }

    //Méthodes
    
    public void ajoutPointsFidelite(double achat){
        achat += resteAchatFidel;
        while(achat >= TRANCHE_ACHAT){
            ptsFidelite += 10;
            achat -= TRANCHE_ACHAT;
        }
        resteAchatFidel = achat;
    }

    @Override
    public String toString(){
        return "\n\tClient Entreprise"+super.toString()+"\n\t Nom : "+this.nom+"\tSIRET : "+this.SIRET;
    }
}

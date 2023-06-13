package fr.ua.iutlens.sae.app;

import java.util.Objects;

public class ClientEtablissementPublic extends Client{
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(TRANCHE_ACHAT, nom, type);
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
		ClientEtablissementPublic other = (ClientEtablissementPublic) obj;
		return TRANCHE_ACHAT == other.TRANCHE_ACHAT && Objects.equals(nom, other.nom) && type == other.type;
	}

	private String nom;
    public enum Type {EPIC,EPA,EPSCT};
    private final Type type;
    private final int TRANCHE_ACHAT = 500;

    public ClientEtablissementPublic(String dateInscription ,Adresse adresse, String numTel, String mail, String nom, Type type){
        super(dateInscription,adresse,numTel,mail);
        this.nom=nom;
        this.type = type;
    }

    public String getNom(){return this.nom;}

    public Type getType(){return this.type;}

    public void ajoutPointsFidelite(double achat){
        achat += resteAchatFidel;
        while(achat >= TRANCHE_ACHAT){
            ptsFidelite += 10;
            achat -= TRANCHE_ACHAT;
        }
        resteAchatFidel = achat;
    }

    public String getTypeClient(){
        return "établissement publique";
    }

    @Override
    public String toString(){
        return "\n\tClient Etablissement Publique"+super.toString()+"Publique\n\tNom : "+this.nom+"\ttype : "+this.type;
    }
}

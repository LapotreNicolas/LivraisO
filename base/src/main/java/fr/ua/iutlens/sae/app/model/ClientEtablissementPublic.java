package fr.ua.iutlens.sae.app.model;

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
		return Objects.equals(nom, other.nom) && type == other.type;
	}

	private String nom;
    public enum Type {EPIC,EPA,EPSCT}
    private final Type type;
    private static final int TRANCHE_ACHAT = 500;

    //CONSTRUCTEURS
    
    public ClientEtablissementPublic(String dateInscription ,Adresse adresse, String numTel, String mail, String nom, Type type){
        super(dateInscription,adresse,numTel,mail);
        this.nom=nom;
        this.type = type;
    }

    //GETTERS
    
    public String getNom(){return this.nom;}

    public Type getType(){return this.type;}


    public String getTypeClient(){
        return "établissement publique";
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
        return "\n\tClient Etablissement Publique"+super.toString()+" Publique\n\tNom : "+this.nom+"\ttype : "+this.type;
    }
}

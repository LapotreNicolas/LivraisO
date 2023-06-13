package fr.ua.iutlens.sae.app;

public class ClientEtablissementPublic extends Client{
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

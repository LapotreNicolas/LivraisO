package fr.ua.iutlens.sae.app;

public class ClientParticulier extends Client{
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

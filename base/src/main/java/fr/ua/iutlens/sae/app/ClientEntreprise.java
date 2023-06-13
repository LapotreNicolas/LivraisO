package fr.ua.iutlens.sae.app;

public class ClientEntreprise extends Client{
    private String nom;
    private final String SIRET;
    private final int TRANCHE_ACHAT = 1000;

    public ClientEntreprise(String dateInscription ,Adresse adresse, String numTel, String mail, String nom, String siret){
        super(dateInscription,adresse,numTel,mail);
        this.nom=nom;
        this.SIRET=siret;
    }

    public String getNom(){return this.nom;}

    public String getSIRET(){return this.SIRET;}

    public void ajoutPointsFidelite(double achat){
        achat += resteAchatFidel;
        while(achat >= TRANCHE_ACHAT){
            ptsFidelite += 10;
            achat -= TRANCHE_ACHAT;
        }
        resteAchatFidel = achat;
    }

    public String getTypeClient(){
        return "entreprise";
    }

    @Override
    public String toString(){
        return "\n\tClient Entreprise"+super.toString()+"\n\tNom : "+this.nom+"\tSIRET : "+this.SIRET;
    }
}

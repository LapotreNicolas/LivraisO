package fr.ua.iutlens.sae.app;

public abstract class Client{
    private static int compteur = 0;
    private int code;
    private String dateInscription;
    private Adresse adresse;
    private String numTelephone;
    private String adresseMail;
    protected int ptsFidelite;
    protected double resteAchatFidel;

    public Client(String dateInscrisption, Adresse adresse, String numTel, String mail){
        compteur ++;
        this.code = compteur;
        this.dateInscription = dateInscrisption;
        this.adresse = adresse;
        this.numTelephone = numTel;
        this.adresseMail = mail;
        this.ptsFidelite = 0;
        this.resteAchatFidel = 0;
    }
    public int getCode() {return this.code;}

    public String getDateInscription(){return this.dateInscription;}

    public Adresse getAdresse(){return this.adresse;}

    public String getNumTelephone(){return this.numTelephone;}

    public String getAdresseMail(){return this.adresseMail;}

    public int getPtsFidelite(){return this.ptsFidelite;}

    public double getResteAchatFidel(){return this.resteAchatFidel;}

    public void setAdresse(Adresse adresse){this.adresse = adresse;}

    public void setNumTelephone(String numTel){this.numTelephone = numTel;}

    public void setAdresseMail(String mail){this.adresseMail = mail;}

    public void retraitPointsFidelite(int points){this.ptsFidelite = this.ptsFidelite - points;}

    public abstract void ajoutPointsFidelite(double achat);

    public abstract String getTypeClient();

    @Override
    public String toString(){
        return "\n------------------------------------\n\tCode : "+this.code+"\tInscrit en : "+this.dateInscription+"\tMail : "+this.adresseMail+"\n\tTelephone : "+this.numTelephone+"\tAdresse : "+this.adresse+"\n\tPoints de fidélité : "+this.ptsFidelite;
    }
}

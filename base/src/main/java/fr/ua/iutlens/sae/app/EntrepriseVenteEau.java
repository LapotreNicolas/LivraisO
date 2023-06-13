package fr.ua.iutlens.sae.app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EntrepriseVenteEau {
    private static final int MAX_EMPLOYES=250;
    private static final int MAX_ENTREPOT=20;
    private final String SIRET;
    private String nom;
    private int nbEmployes;
    private ObservableList<Employe> employes;
    private ObservableList<Entrepot> entrepots;
    double disponibilites;
    boolean endette;


    public EntrepriseVenteEau(String siret,String nom, int nbEmployes) {
        this.SIRET = siret;
        this.nom = nom;
        this.nbEmployes = nbEmployes;
        this.employes = FXCollections.observableArrayList();
        this.entrepots = FXCollections.observableArrayList();
        this.disponibilites=0;
        this.endette=false;
    }

    public EntrepriseVenteEau(String siret, String nom){
        this(siret,nom,1);
    }

    // GETTERS

    public String getSIRET() {
        return SIRET;
    }

    public String getNom() {
        return nom;
    }

    public int getNbEmployes() {
        return nbEmployes;
    }

    //SETTERS

    public void setNom(String nom) {
        this.nom = nom;
    }

    //Méthodes

    public void Embaucher(Employe employe){
    	if (nbEmployes < MAX_EMPLOYES) {	
    		this.employes.add(employe);
        	nbEmployes++;
    	}
    }

    public int rechercheEmployer(Employe employe){
        for(int i=0; i<this.nbEmployes;i++) {
            if (this.employes.get(i).equals(employe.getId())){
                return i;
            };
        }
        return -1;
    }

    public void Licencier(Employe employe){
        if (rechercheEmployer(employe)>=0){
            this.employes.add(rechercheEmployer(employe), this.employes.get(nbEmployes));
        }
    }

    /* Réduit les disponibilités de l'entreprise du montant du virement
     * @param virement le montant du virement effectué
     */
    public void EffectueVirement(double virement){
        this.disponibilites-=virement;
        if(this.disponibilites < 0){
            this.endette = true;
        }
    }

    /* Augmente les disponibilités de l'entreprise du montant du virement
     * @param virement le montant du virement reçu
     */
    public void recoisVirement(double virement){
        disponibilites+=virement;
        if(this.endette && disponibilites>=0){
            this.endette = false;
        }
    }

    /* Méthode qui renvoie l'ensemble des attributs de l'objet de la classe EntrepriseVenteEau
     * @return une chaine de caractères qui correspond à l'ensemble des attributs de l'objet désigné
     */
    @Override
    public String toString(){
        return "Entreprise "+this.nom+" SIRET : "+this.SIRET+". Possède "+this.nbEmployes+" Employés, "+this.disponibilites+" € en disponibilités. Endetté ? "+this.endette;
    }
}

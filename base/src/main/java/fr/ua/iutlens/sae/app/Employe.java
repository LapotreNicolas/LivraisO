package fr.ua.iutlens.sae.app;

public class Employe {
    public int compteur;
    private int id;
    private String nom;
    private String prenom;
    public enum Contrat {CDI,CDD}
    private Contrat contrat;
    private double salaire;

    //CONSTRUCTEURS

    public Employe(String nom,String prenom,Contrat contrat,double salaire){
        compteur++;
        this.id = compteur;
        this.nom = nom;
        this.prenom = prenom;
        this.contrat = contrat;
        this.salaire = salaire;
    }

    //GETTERS

    public int getId(){return this.id;}
    public String getNom(){return this.nom;}
    public String getPrenom(){return this.prenom;}
    public Contrat getContrat(){return this.contrat;}
    public double getSalaire(){return this.salaire;}

    //SETTERS

    public void setSalaire(double salaire){
        this.salaire = salaire;
    }

    //Méthodes

    /* Permet d'augmenter le salaire d'un employé désigné d'une prime
     * @param prime la valeur que gagne le salaire de l'employé
     */
    public void augmentation(double prime){
        this.salaire += prime;
    }

    /* Permet la réduction du salaire d'un employé défini
     * @param reduc la valeur que perd le salaire de l'employé
     */
    public void reduction(double reduc){
        this.salaire -= reduc;
        if (salaire < 0){
            salaire = 0;
        }
    }

    public boolean equals(int id){
        return this.id==id;
    }

    /* Affiche l'ensemble des attributs de l'objet Employé désigné
     * @return Une chaine de caractères String représentant l'ensemble des attributs de l'objet désigné.
     */
    @Override
    public String toString(){
        return "Employé n°"+this.id+" Nom : "+this.nom+" Prénom : "+this.prenom+" Contrat : "+this.contrat+" Salaire : "+this.salaire;
    }
}
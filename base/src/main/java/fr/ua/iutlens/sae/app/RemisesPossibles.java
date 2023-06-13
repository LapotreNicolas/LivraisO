package fr.ua.iutlens.sae.app;

public interface RemisesPossibles {

    double montantDeLaRemise(Client client);

    int nombreBouteillesGratuites(int nbBouteilles, Client client);
}

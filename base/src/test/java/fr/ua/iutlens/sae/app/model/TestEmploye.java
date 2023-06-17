package fr.ua.iutlens.sae.app.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ua.iutlens.sae.app.model.Client;
import fr.ua.iutlens.sae.app.model.Commande;
import fr.ua.iutlens.sae.app.model.Eau;
import fr.ua.iutlens.sae.app.model.LigneDeCommande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author nicolas.lapotre
 *
 */

class TestEmploye {

	Employe employe;
	
	@BeforeEach
	public void initEmploye() {
		employe = new Employe("Iorka","Yves",Employe.Contrat.CDI,2111.04);
	}
	
	@AfterEach
	public void delEmploye() {
		employe = null;
	}
	
	@Test
	public void testGettersEtSetter() {
		// When
		int id = employe.getId();
		String nom = employe.getNom();
		String prenom = employe.getPrenom();
		Employe.Contrat contrat = employe.getContrat();
		double salaireAvantSetter = employe.getSalaire();
		employe.setSalaire(2404.68);
		double salaireApresSetter = employe.getSalaire();
		
		// Then
		assertEquals(6, id);
		assertEquals("Iorka", nom);
		assertEquals("Yves", prenom);
		assertEquals(Employe.Contrat.CDI, contrat);
		assertEquals(2111.04, salaireAvantSetter);
		assertEquals(2404.68, salaireApresSetter);
	}
	
	@Test
	public void testAugmentation() {
		// Given
		double prime = 666.13;
		double reduction1 = 420.69;
		double reduction2 = Integer.MAX_VALUE;
		
		// When
		employe.reduction(reduction1);
		double salairePremiereReduction = employe.getSalaire();
		employe.augmentation(prime);
		double salaireAugmentation = employe.getSalaire();
		employe.reduction(reduction2);
		double salaireDeuxiemeReduction = employe.getSalaire();

		// Then
		assertEquals(1690.35, salairePremiereReduction);
		assertEquals(2356.48, salaireAugmentation);
		assertEquals(0, salaireDeuxiemeReduction);
	}
	
	@Test	
	public void testToString() {
		// When
		String string = employe.toString();
		
		// Then
		assertEquals("Employé n°0 | Nom : Iorka | Prénom : Yves | Contrat : CDI | Salaire : 2111.04", string);
	}
	
	@Test
	void testToHash() {
		// Given
		Employe employe2 = new Employe("Nam", "Exort", Employe.Contrat.CDD, 3106.04);

		// When
		int hash1 = employe.hashCode();
		int hash2 = employe2.hashCode();
		
		// Then
		assertNotEquals(hash1, hash2);
	}
	
	@Test
    void testEquals() {
        // Given
        Employe employe2 = new Employe("The Incendiary", "GralfJord", Employe.Contrat.CDD, 1109.04);

        // When
        boolean equals11 = employe.equals(employe);
        boolean equals12 = employe.equals(employe2);
        boolean equals1 = employe.equals(null);
        boolean equals1int = employe.equals(64);
        
        // Then
        assertTrue(equals11);
        assertFalse(equals12);
        assertFalse(equals1);
        assertFalse(equals1int);
    }
}

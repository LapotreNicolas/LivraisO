package fr.ua.iutlens.sae.app.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

class TestPaiement {

	Paiement paiement;
	
	@Mock
	MethodePaiement methodePaiement;
	
	@Mock
	MethodePaiement methodePaiement2;
	
	@BeforeEach
	void initPaiement() {
		paiement = new Paiement(666.13, methodePaiement);
	}
	
	@AfterEach
	void delPaiement() {
		paiement = null;
	}
	
	@Test
	void testGettersSetters() {
		// When
		double montant = paiement.getMontant();
		MethodePaiement methode = paiement.getMethodePaie();
		paiement.setMontant(420.69);
		paiement.setMethodePaie(methodePaiement2);
		double montantSetter = paiement.getMontant();
		MethodePaiement methodeSetter = paiement.getMethodePaie();
		
		// Then
		assertEquals(666.13, montant);
		assertEquals(methodePaiement, methode);
		assertEquals(420.69, montantSetter);
		assertEquals(methodePaiement2, methodeSetter);
	}
	
	@Test
	void testToString() {
		// Given
		when(methodePaiement.toString()).thenReturn("Espèces")
		
		// When 
		String string = paiement.toString();
		
		// Then
		assertEquals("Paiement{montant=666.13, methodePaie=Espèces}")
	}
	
	@Test
	void testToHash() {
		// Given
		Paiement paiement2 = new Paiement(666.13, methodePaiement);
		Paiement paiement3 = new Paiement(420.69, methodePaiement2);
		
		// When
		int hash1 = paiement.hashCode();
		int hash2 = paiement2.hashCode();
		int hash3 = paiement3.hashCode();
		
		// Then
		assertEquals(hash1, hash2);
		assertNotEquals(hash1, hash3);
		assertNotEquals(hash2, hash3);
	}
	
	@Test
    void testEquals() {
        // Given
		Paiement paiement2 = new Paiement(420.69, methodePaiement);
		Paiement paiement3 = new Paiement(666.13, methodePaiement2);
		Paiement paiement4 = new Paiement(666.13, methodePaiement);
		
        // When
        boolean equals11 = paiement.equals(paiement);
        boolean equals12 = paiement.equals(paiement2);
        boolean equals23 = paiement.equals(paiement3);
        boolean equals34 = paiement.equals(paiement4);
        boolean equals1 = paiement.equals(null);
        boolean equals1string = paiement.equals("coucou");
        
        // Then
        assertTrue(equals11);
        assertTrue(equals12);
        assertFalse(equals23);
        assertFalse(equals34);
        assertFalse(equals1);
        assertFalse(equals1string);
    }
}

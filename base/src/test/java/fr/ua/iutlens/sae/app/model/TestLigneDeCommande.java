package fr.ua.iutlens.sae.app.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ua.iutlens.sae.app.model.Eau;
import fr.ua.iutlens.sae.app.model.LigneDeCommande;

/**
 * 
 * @author nicolas.lapotre
 *
 */

@ExtendWith(MockitoExtension.class)
class TestLigneDeCommande {

	LigneDeCommande ligne;
	
	@Mock
	Eau eau;
	
	@Mock
	Eau eau2;
	
	@BeforeEach
	void initLigne() {
		ligne = new LigneDeCommande(eau, 120);
	}
	
	@AfterEach
	void delLigne() {
		ligne = null;
	}

	@Test
	void testGetEau() {
		// Given
		LigneDeCommande ligne = new LigneDeCommande(eau, 120);
		
		// When
		Eau eauGet = ligne.getEau(); 
		
		// Then
		assertEquals(eau, eauGet);
	}

	@Test
	void testGetQuantite() {
		// Given
		LigneDeCommande ligne = new LigneDeCommande(eau, 120);
		
		// When
		int quantite = ligne.getQuantite(); 
		
		// Then
		assertEquals(120, quantite);
		}
		
		@Test
		void testToString() {
			// Given
			when(eau.toString()).thenReturn("eau");
			
			// When
			String string = ligne.toString(); 
			
			// Then
			assertEquals("LigneDeCommande{eau=eau, quantite=120}", string);
		}
		
		@Test
		void testToHash() {
			// Given
			LigneDeCommande ligne2 = new LigneDeCommande(eau, 120);
			LigneDeCommande ligne3 = new LigneDeCommande(eau, 10);
			
			// When
			int hash1 = ligne.hashCode();
			int hash2 = ligne2.hashCode();
			int hash3 = ligne3.hashCode();
			
			// Then
			assertEquals(hash1, hash2);
			assertNotEquals(hash1, hash3);
			assertNotEquals(hash2, hash3);
		}
		
		@Test
		void testToEquals() {
			// Given
			LigneDeCommande ligne2 = new LigneDeCommande(eau, 120);
			LigneDeCommande ligne3 = new LigneDeCommande(eau2, 10);
			LigneDeCommande ligne4 = new LigneDeCommande(eau2, 120);
			
			// When
			boolean equals11 = ligne.equals(ligne);
			boolean equals12 = ligne.equals(ligne2);
			boolean equals23 = ligne2.equals(ligne3);
			boolean equals34 = ligne3.equals(ligne4);
			boolean equals1 = ligne.equals(null);
			boolean equals1eau = ligne.equals(eau);
			
			// Then
			assertTrue(equals11);
			assertTrue(equals12);
			assertFalse(equals23);
			assertFalse(equals34);
			assertFalse(equals1);
			assertFalse(equals1eau);
		}
}

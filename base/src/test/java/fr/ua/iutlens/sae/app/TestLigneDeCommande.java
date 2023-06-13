package fr.ua.iutlens.sae.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class TestLigneDeCommande {

	LigneDeCommande ligne;
	
	@Mock
	Eau eau;
	
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
		assertEquals("eau : eau, quantite : 120", string);
	}
}

package fr.ua.iutlens.sae.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author nicolas.lapotre
 *
 */

@ExtendWith(MockitoExtension.class)
class TestEntrepot {

	Entrepot entrepot;
	
	@Mock
	Adresse adresse;
	
	@Mock
	Adresse adresse2;
	
	@BeforeEach
	void initEntrepot() {
		entrepot = new Entrepot(420, "Valva", adresse);
	} 
	
	@AfterEach
	void delEntrepot() {
		entrepot = null;
	}
	
	@Test
	void testToHash() {
		// Given
		Entrepot entrepot2 = new Entrepot(420, "Valva", adresse);
		Entrepot entrepot3 = new Entrepot(666, "ValvO", adresse2);
		
		// When
		int hash1 = entrepot.hashCode();
		int hash2 = entrepot2.hashCode();
		int hash3 = entrepot3.hashCode();
		
		// Then
		assertEquals(hash1, hash2);
		assertNotEquals(hash1, hash3);
		assertNotEquals(hash2, hash3);
	}
	
	@Test
    void testEquals() {
        // Given
        Entrepot entrepot2 = new Entrepot(666,"ValvO", adresse2);
        Entrepot entrepot3 = new Entrepot(420,"Valva", adresse);
        
        // When
        boolean equals11 = entrepot.equals(entrepot);
        boolean equals12 = entrepot.equals(entrepot2);
        boolean equals1 = entrepot.equals(null);
        boolean equals1adresse = entrepot.equals(adresse);
        boolean equals13 = entrepot.equals(entrepot3);
        
        // Then
        assertTrue(equals11);
        assertFalse(equals12);
        assertFalse(equals1);
        assertFalse(equals1adresse);
        assertTrue(equals13);
    }
	
	@Test
	void testGetters() {
		// When
		int code = entrepot.getCode();
		String nom = entrepot.getNom();
		Adresse addr = entrepot.getAdresse();
		
		// Then
		assertEquals(420, code);
		assertEquals("Valva", nom);
		assertEquals(adresse, addr);
	}
	
	@Test
	void testToString() {
		// Given 
		when(adresse.toString()).thenReturn("adresse");
		
		// When
		String string = entrepot.toString();
		
		// Then
		assertEquals("code : 420, nom : Valva, adresse : adresse", string);
	}
}
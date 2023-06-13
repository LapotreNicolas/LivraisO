/**
 * 
 */
package fr.ua.iutlens.sae.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

/**
 * @author jules.langagne
 *
 */
@ExtendWith(MockitoExtension.class)
class TestClientParticulier {
	
	 @Mock
	 Adresse adresseLambda;
	 
	 ClientParticulier clientParticulierTest;
	 
	 @BeforeEach
	 void createClient() {
	 clientParticulierTest = new ClientParticulier("07/06/2023", this.adresseLambda, "0606060606","ClientParticulierTest@mail.com","Doe","John");
	 }
	
	/**
	 * Depuis la class ClientParticulier, verifie la method getNom 
	 */
	@Test
	void testGetNom() {
		// WHen
		String nomClientParticulier = clientParticulierTest.getNom();
		// Then
		assertEquals("Doe", nomClientParticulier);
	}
	
	/**
	 * Depuis la class ClientParticulier, verifie la method getPrenom
	 */
	@Test
	void testGetPrenom() {
		// WHen
		String prenomClientParticulier = clientParticulierTest.getPrenom();
		// Then
		assertEquals("John", prenomClientParticulier);
	}
	
	/**
	 * Depuis la class ClientParticulier, verifie la method getTypeClient
	 */
	@Test
	void testGetTypeClient() {
		// WHen
		String typeClientParticulier = clientParticulierTest.getTypeClient();
		// Then
		assertEquals("particulier",typeClientParticulier);
	}
	
	@Test
	void testAjoutPointsFidelite() {
		// Given
		double achat=100;
		
		// THen
		clientParticulierTest.ajoutPointsFidelite(achat);
		
	}
}
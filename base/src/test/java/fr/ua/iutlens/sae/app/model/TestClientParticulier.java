package fr.ua.iutlens.sae.app.model;

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
	 * Depuis la class {@link ClientParticulier}
	 * <br>
	 * Verifie la methode {@link ClientParticulier#getNom()}
	 */
	@Test
	void testGetNom() {
		// WHen
		String nomClientParticulier = clientParticulierTest.getNom();
		// Then
		assertEquals("Doe", nomClientParticulier);
	}
	
	/**
	 * Depuis la class {@link ClientParticulier}
	 * <br>
	 * Vérifie la methode {@link ClientParticulier#getPrenom()}
	 */
	@Test
	void testGetPrenom() {
		// WHen
		String prenomClientParticulier = clientParticulierTest.getPrenom();
		// Then
		assertEquals("John", prenomClientParticulier);
	}
	
	/**
	 * Depuis la class {@link ClientParticulier}
	 * <br>
	 * Vérifie la methode {@link ClientParticulier#getTypeClient()}
	 */
	@Test
	void testGetTypeClient() {
		// WHen
		String typeClientParticulier = clientParticulierTest.getTypeClient();
		// Then
		assertEquals("particulier",typeClientParticulier);
	}
	
	/**
	 * Depuis la class {@link ClientParticluier}
	 * <br>
	 * Verifie la methode {@link ClientParticulier#ajoutPointsFidelite(double)}
	 * en verifiant le calcul
	 */
	@Test
	void testAjoutPointsFidelite() {
		// Given
		double achat=100;
		
		// WHen
		clientParticulierTest.ajoutPointsFidelite(achat);
		int ptsFidelite = clientParticulierTest.getPtsFidelite();
		
		// Then
		assertEquals(10, ptsFidelite);
		
	}
	
	/**
	 * Depuis la class {@link ClientParticulier}
	 * <br>
	 * Vérifie le résultat de la méthode surchargée {@link ClientParticulier#toString()}
	 */
	@Test
	void testToString() {
		// WHen
		String stringResult = clientParticulierTest.toString();
		
		// Then
		assertEquals("", stringResult);
	}
	
	@Test
	void testToHash() {
		// 
	}
	
	@Test
	void testEquals() {
		//
	}
}
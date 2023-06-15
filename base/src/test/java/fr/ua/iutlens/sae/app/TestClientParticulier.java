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
	 * @see ClientParticulier
	 * {@link fr.ua.iutlens.sae.app.ClientParticulier#getNom()}
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
	 * @see ClientParticulier
	 * {@link fr.ua.iutlens.sae.app.ClientParticulier#getPrenom()}
	 */
	@Test
	void testGetPrenom() {
		// WHen
		String prenomClientParticulier = clientParticulierTest.getPrenom();
		// Then
		assertEquals("John", prenomClientParticulier);
	}
	
	/**
<<<<<<< HEAD
	 * Depuis la class ClientParticulier, vérifie la method getTypeClient
=======
	 * Depuis la class ClientParticulier, verifie la method getTypeClient
	 * @see ClientParticulier
	 * {@link fr.ua.iutlens.sae.app.ClientParticulier#getTypeClient()}
>>>>>>> 6eff67c5b3d4811ae76507f621a4cb05a3962ee3
	 */
	@Test
	void testGetTypeClient() {
		// WHen
		String typeClientParticulier = clientParticulierTest.getTypeClient();
		// Then
		assertEquals("particulier",typeClientParticulier);
	}
	
	/**
	 * Depuis la class ClientParticluier, verifie la method ajoutPointsFidelite
	 * en securisant le calcul
	 * @see ClientParticulier
	 * {@link fr.ua.iutlens.sae.app.ClientParticulier#ajoutPointsFidelite(double)}
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
}
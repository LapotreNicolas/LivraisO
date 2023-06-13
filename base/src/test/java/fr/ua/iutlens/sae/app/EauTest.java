package fr.ua.iutlens.sae.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ua.iutlens.sae.app.Eau.Categorie;

/**
 * Classe Test ayant pour objectif de tester la classe Eau.java
 * @author timeo.quehen
 * @see Eau
 */
@ExtendWith(MockitoExtension.class)
class EauTest {

	Eau e1 = new Eau("marque1",Eau.Categorie.EAU_PLATE,5.0);
	Eau e2 = new Eau("marque2",Eau.Categorie.EAU_GAZEUSE,7.0);
	
	@Test
	/**
	 * Fonction qui teste la méthode "getIndentifiant" de la classe Eau
	 * @see Eau
	 * @see getIdentifiant
	 */
	void getIdentifiantTest() {
		//Given
		
		//When
		int id = e1.getIdentifiant();
		
		//Then
		assertEquals(0, id);
		
}
	
	@Test
	/**
	 * Fonction qui teste la méthode "getMarque" de la classe Eau
	 * @see Eau
	 * @see getMarque
	 */
	void getMarqueTest() {
		//Given
		
		//When
		String marque = e1.getMarque();
		
		//Then
		assertEquals("marque1", marque);
		
	}
	

	@Test
	/**
	 * Fonction qui teste la méthode "getCatEau" de la classe Eau
	 * @see Eau
	 * @see getCatEau
	 */
	void getCatEauTest() {
		//Given
		
		//When
		Eau.Categorie catEau = e1.getCatEau();
		
		//Then
		assertEquals(Eau.Categorie.EAU_PLATE, catEau);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "getPrix" de la classe Eau
	 * @see Eau
	 * @see getPrix
	 */
	void getPrixTest() {
		//Given
		
		//When
		double prix = e1.getPrix();
		
		//Then
		assertEquals(5.0, prix);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "setPrix" de la classe Eau
	 * @see Eau
	 * @see setPrix
	 */
	void setPrixTest() {
		//Given
		
		//When
		e1.setPrix(15.0);
		
		//Then
		assertEquals(15.0,e1.getPrix());
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Eau
	 * @see Eau
	 * @see equals
	 */
	void equalsTest() {
		//Given
		
		//When
		boolean egalite = e2.equals(e1);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Eau
	 * @see Eau
	 * @see equals
	 */
	void equalsTest2() {
		//Given
		
		//When
		boolean egalite = e1.equals(e1);
		
		//Then
		assertEquals(true, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Eau
	 * @see Eau
	 * @see equals
	 */
	void equalsTest3() {
		//Given
		
		//When
		boolean egalite = e1.equals(12);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Eau
	 * @see Eau
	 * @see equals
	 */
	void equalsTest4() {
		//Given
		
		//When
		boolean egalite = e1.equals(null);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	void testToHash() {
		// Given
		Eau e3 = new Eau("marque4",Categorie.EAU_PLATE,3.0);
		
		// When
		int hash1 = e1.hashCode();
		int hash2 = e2.hashCode();
		int hash3 = e3.hashCode();
		
		// Then
		assertNotEquals(hash1, hash3);
		assertNotEquals(hash2, hash3);
	}
	
	@Test
	void toStringTest() {
		// Given
		Eau e3 = new Eau("marque4",Categorie.EAU_PLATE,3.0);
		
		// When
		String ts = e3.toString();
		
		// Then
		assertEquals("marque : marque4, catégorie : EAU_PLATE, prix : 3.0",ts);
	}
	
}

package fr.ua.iutlens.sae.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Classe Test ayant pour objectif de tester la classe Eau.java
 * @author timeo.quehen
 * @see Adresse
 */
class AdresseTest {

	Adresse a1 = new Adresse("15","rue Dubois","0123","Arras","Pas-de-Calais");
	Adresse a2 = new Adresse("25","rue Dubois","0123","Arras","Pas-de-Calais");
	Adresse a3 = new Adresse("15","rue DeRang","0123","Arras","Pas-de-Calais");
	Adresse a4 = new Adresse("15","rue Dubois","4567","Arras","Pas-de-Calais");
	Adresse a5 = new Adresse("15","rue Dubois","0123","Lens","Pas-de-Calais");
	Adresse a6 = new Adresse("15","rue Dubois","0123","Arras","Haute-Savoir");
	Adresse a7 = new Adresse("15","rue Dubois","0123","Arras","Pas-de-Calais");
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest() {
		//Given
		
		//When
		boolean egalite = a2.equals(a1);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest2() {
		//Given
		
		//When
		boolean egalite = a1.equals(a1);
		
		//Then
		assertEquals(true, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest3() {
		//Given
		
		//When
		boolean egalite = a1.equals(12);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest4() {
		//Given
		
		//When
		boolean egalite = a1.equals(null);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest5() {
		//Given
		
		//When
		boolean egalite = a3.equals(a1);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest6() {
		//Given
		
		//When
		boolean egalite = a4.equals(a1);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest7() {
		//Given
		
		//When
		boolean egalite = a7.equals(a1);
		
		//Then
		assertEquals(true, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest8() {
		//Given
		
		//When
		boolean egalite = a1.getCommune().equals(a1.getCommune());
		
		//Then
		assertEquals(true, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest9() {
		//Given
		
		//When
		boolean egalite = a1.getCommune().equals(null);
		
		//Then
		assertEquals(false, egalite);
		
	}
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe Adresse
	 * @see Adresse
	 * @see equals
	 */
	void equalsTest10() {
		//Given
		
		//When
		boolean egalite = a1.getCommune().equals(12);
		
		//Then
		assertEquals(false, egalite);
		
	}

}

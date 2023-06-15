package fr.ua.iutlens.sae.app.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ua.iutlens.sae.app.model.Eau;
import fr.ua.iutlens.sae.app.model.Entrepot;
import fr.ua.iutlens.sae.app.model.StockEau;

/**
 * Classe Test ayant pour objectif de tester la classe StockEau.java
 * @author timeo.quehen
 * @see StockEau
 */
@ExtendWith(MockitoExtension.class)
class StockEauTest {

	@Mock
	Eau o1;
	
	@Mock
	Eau o2;
	
	@Mock
	Eau o3;
	
	@Mock
	Entrepot e1;
	
	@Mock
	Entrepot e2;
	
	@Mock
	Entrepot e3;
	
	StockEau se1 = new StockEau(o1, e1, 10);
	StockEau se2 = new StockEau(o2, e2, 20); //tout diff
	StockEau se3 = new StockEau(o3,e3,30); //eau diff
	StockEau se4 = new StockEau(o1,e2,20); //entreprise diff
	StockEau se5 = new StockEau(o1,e1,10); //tout pareil
	StockEau se6 = new StockEau(o1,e1,69); // quantité diff
	
	@Test
	/**
	 * Fonction qui teste la méthode "equals" de la classe StockEau
	 * @see StockEau
	 * @see equals
	 */
	void equalsTest() {
		//Given
		
		//When
		boolean egalite1 = se1.equals(se2);
		boolean egalite2 = se1.equals(se3);
		boolean egalite3 = se2.equals(se3);
		boolean egalite4 = se1.equals(se1);
		boolean egalite5 = se1.equals(12);
		boolean egalite6 = se1.equals(null);
		boolean egalite7 = se1.equals(se4);
		boolean egalite8 = se1.equals(se5);
		boolean egalite9 = se1.equals(se6);
		
		//Then
		assertEquals(false, egalite1);
		assertEquals(false, egalite2);
		assertEquals(false, egalite3);
		assertEquals(true, egalite4);
		assertEquals(false, egalite5);
		assertEquals(false, egalite6);
		assertEquals(false, egalite7);
		assertEquals(true, egalite8);
		assertEquals(false, egalite9);
		
	}

/**
 *      when(o1.equals(o1)).thenReturn(true);
		when(o1.equals(o2)).thenReturn(false);
		when(o1.equals(o3)).thenReturn(true);
		
		when(e1.equals(e1)).thenReturn(true);
		when(e1.equals(e2)).thenReturn(false);
		when(e1.equals(e3)).thenReturn(true);
		
		when(e2.equals(e3)).thenReturn(false);
		when(o2.equals(o3)).thenReturn(true);	
 */
	
}

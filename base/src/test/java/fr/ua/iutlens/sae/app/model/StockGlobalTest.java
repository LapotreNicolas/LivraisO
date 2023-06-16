package fr.ua.iutlens.sae.app.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ua.iutlens.sae.app.model.StockEau;
import fr.ua.iutlens.sae.app.model.StockGlobal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * 
 * @author timeo.quehen
 *
 */
@ExtendWith(MockitoExtension.class)
class StockGlobalTest {

    StockGlobal sg;
      
    @Mock
    StockEau se;
    
    @Mock
    StockEau se2;

    @Mock
    StockEau se3;
    
    @BeforeEach
    void initS() {
        sg = new StockGlobal();
    }
    
    @AfterEach
    void delS() {
        sg = null;
    }
    
    @Test
    void testGetter() {
    	// Given
    	ObservableList<StockEau> listeSE = FXCollections.observableArrayList();;
    	listeSE.add(se);
    	listeSE.add(se3);
    	listeSE.add(se2);
    	
    	// When
    	sg.ajouter(se);
    	sg.ajouter(se3);
    	sg.ajouter(se2);
    	ObservableList<StockEau> liste = sg.getTabStockEau();
    	
    	// Then
    	assertEquals(listeSE, liste);
    }
    
    @Test
    void testReduireQuantite() {
        // Given
        when(se.getQuantite()).thenReturn(30);
        sg.ajouter(se);
        
        // When
        try {
        	sg.reduireQuantite(0, 20);
        } catch (Exception e) {
        	
        }
    }
    
    @Test
    void testAjouterSupprimer() {
    	// Given
    	when(se.getQuantite()).thenReturn(30);
    	ObservableList<StockEau> listeSE = FXCollections.observableArrayList();;
    	listeSE.add(se);
    	listeSE.add(se3);
    	
    	// When
    	sg.ajouter(se);
    	sg.ajouter(se2);
    	sg.ajouter(se3);
    	sg.supprimer(se2);
    	sg.ajouter(se);
    	ObservableList<StockEau> liste = sg.getTabStockEau();
    	
    	// Then
    	assertEquals(listeSE, liste);
    }
    
    @Test
    void testTrierCroissant() {
    	// Given
    	when(se.getQuantite()).thenReturn(30);
    	when(se2.getQuantite()).thenReturn(50);
    	when(se3.getQuantite()).thenReturn(10);
    	ObservableList<StockEau> listeSE = FXCollections.observableArrayList();;
    	listeSE.add(se3);
    	listeSE.add(se);
    	listeSE.add(se2);
    	
    	// When
    	sg.ajouter(se);
    	sg.ajouter(se2);
    	sg.ajouter(se3);
    	sg.trier();
    	ObservableList<StockEau> listeTrier = sg.getTabStockEau();
    	
    	// Then
    	assertEquals(listeSE, listeTrier);
    }
    
    @Test
    void testTrierDeroissant() {
    	// Given
    	when(se.getQuantite()).thenReturn(13);
    	when(se2.getQuantite()).thenReturn(420);
    	when(se3.getQuantite()).thenReturn(68);
    	ObservableList<StockEau> listeSE = FXCollections.observableArrayList();;
    	listeSE.add(se2);
    	listeSE.add(se3);
    	listeSE.add(se);
    	
    	// When
    	sg.ajouter(se);
    	sg.ajouter(se2);
    	sg.ajouter(se3);
    	sg.trier(false);
    	ObservableList<StockEau> listeTrier = sg.getTabStockEau();
    	
    	// Then
    	assertEquals(listeSE, listeTrier);
    }
    
    @Test
    void testReduireQuantiteException() {
        // Given
        sg.ajouter(se);
        when(se.getQuantite()).thenReturn(10);
        
        // When Then
        assertThrows(Exception.class, () -> sg.reduireQuantite(0, 20));
    }

	@Test
	void testToString() {
		// Given
		when(se.toString()).thenReturn("Stock d'Eau");
		when(se2.toString()).thenReturn("Stock d'Eau 2");
		when(se3.toString()).thenReturn("Stock d'Eau 3");
    	sg.ajouter(se);
    	sg.ajouter(se2);
    	sg.ajouter(se3);	
		
		// When 
		String string = sg.toString();
		
		// Then
		assertEquals("Tableau des Stocks d'Eau :\n\t- Stock d'Eau\n\t- Stock d'Eau 2\n\t- Stock d'Eau 3", string);
	}
    
    @Test
	void testToStringVide() {		
		// When 
		String string = sg.toString();
		
		// Then
		assertEquals("Tableau des Stocks d'Eau :\n\tpas de stock", string);
	}
    
	@Test
	void testToHash() {
		// Given
		StockGlobal sg2 = new StockGlobal();
		StockGlobal sg3 = new StockGlobal();
        sg.ajouter(se);
        sg.ajouter(se2);
        sg2.ajouter(se);
        sg2.ajouter(se2);
        sg3.ajouter(se2);
        sg3.ajouter(se);
        
		// When
		int hash1 = sg.hashCode();
		int hash2 = sg2.hashCode();
		int hash3 = sg3.hashCode();
		
		// Then
		assertEquals(hash1, hash2);
		assertNotEquals(hash1, hash3);
		assertNotEquals(hash2, hash3);
	}
	
	@Test
    void testEquals() {
        // Given
		StockGlobal sg2 = new StockGlobal();
		StockGlobal sg3 = new StockGlobal();
		sg.ajouter(se);
        sg.ajouter(se2);
        sg2.ajouter(se);
        sg2.ajouter(se2);
        sg3.ajouter(se2);
        sg3.ajouter(se);
        
        // When
        boolean equals11 = sg.equals(sg);
        boolean equals12 = sg.equals(sg2);
        boolean equals13 = sg.equals(sg3);
        boolean equals1 = sg.equals(null);
        boolean equals1true = sg.equals(true);
        
        // Then
        assertTrue(equals11);
        assertTrue(equals12);
        assertFalse(equals13);
        assertFalse(equals1);
        assertFalse(equals1true);
    }
}
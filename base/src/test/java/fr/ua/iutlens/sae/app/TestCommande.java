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
class TestCommande {

	Commande cmd;
	
	@Mock
	LigneDeCommande ligne1;

	@Mock
	LigneDeCommande ligne2;
	
	@Mock
	LigneDeCommande ligne3;
	
	@Mock
	Client client;
	
	@Mock
	Client client2;
	
	@Mock
    Eau eau1;

    @Mock
    Eau eau2;
	
	@BeforeEach
	void initLigne() {
		cmd = new Commande();
	}
	
	@AfterEach
	void delLigne() {
		cmd = null;
	}
	
	@Test
	void testAjouterCommande() {		
		// When
		cmd.ajouterCommande(ligne1);
	}

	@Test
	void testAjouterCommandes() {
		// Given
		ObservableList<LigneDeCommande> liste = FXCollections.observableArrayList(ligne1 , ligne2, ligne3);
		
		// When
		cmd.ajouterCommandes(liste);
	}
	
	@Test
	void testModifierCommande() {
		// Given
		cmd.ajouterCommande(ligne1);
		
		// When
		cmd.modifierCommande(0, ligne2);
	}
	
	@Test
	void testMontantDeLaRemiseParticulier() {
		// Given
		when(client.getPtsFidelite()).thenReturn(10000);
		when(client.getTypeClient()).thenReturn("particulier");
		when(client2.getPtsFidelite()).thenReturn(100);
		when(client2.getTypeClient()).thenReturn("particulier");
		
		// When
		double solde = cmd.montantDeLaRemise(client);
		double solde2 = cmd.montantDeLaRemise(client2);
		
		// Then
		assertEquals(0.9, solde);
		assertEquals(0.99, solde2);
	}
	
	@Test
	void testMontantDeLaRemiseAutre() {
		// Given
		when(client.getPtsFidelite()).thenReturn(1000);
		when(client.getTypeClient()).thenReturn("établissement publique");
		when(client2.getPtsFidelite()).thenReturn(100000);
		when(client2.getTypeClient()).thenReturn("établissement publique");
		
		// When
		double solde = cmd.montantDeLaRemise(client);
		double solde2 = cmd.montantDeLaRemise(client2);
		
		// Then
		assertEquals(0.99, solde);
		assertEquals(0.9, solde2);	
	}
	
	@Test
	void testMontantDeLaRemise10() {
		// Given
		when(client.getPtsFidelite()).thenReturn(10);

		// When
		double solde = cmd.montantDeLaRemise(client);
		
		// Then
		assertEquals(1.0, solde);	
	}
	
	@Test
	void testToHash() {
		// Given
		Commande cmd2 = new Commande();
		Commande cmd3 = new Commande();
		cmd.ajouterCommande(ligne1);
		cmd2.ajouterCommande(ligne1);
		cmd3.ajouterCommande(ligne2);
		
		// When
		int hash1 = cmd.hashCode();
		int hash2 = cmd2.hashCode();
		int hash3 = cmd3.hashCode();
		
		// Then
		assertEquals(hash1, hash2);
		assertNotEquals(hash1, hash3);
		assertNotEquals(hash2, hash3);
	}
	
	@Test
    void testEquals() {
        // Given
        Commande cmd2 = new Commande();
        Commande cmd3 = new Commande();
        Commande cmd4 = new Commande();
        cmd.ajouterCommande(ligne1);
        cmd2.ajouterCommande(ligne1);
        cmd3.ajouterCommande(ligne2);
        
        // When
        boolean equals11 = cmd.equals(cmd);
        boolean equals12 = cmd.equals(cmd2);
        boolean equals23 = cmd2.equals(cmd3);
        boolean equals34 = cmd3.equals(cmd4);
        boolean equals1 = cmd.equals(null);
        boolean equals1ligne = cmd.equals(ligne1);
        
        // Then
        assertTrue(equals11);
        assertTrue(equals12);
        assertFalse(equals23);
        assertFalse(equals34);
        assertFalse(equals1);
        assertFalse(equals1ligne);
    }
	
	@Test
	void testToString() {
		// Given
		cmd.ajouterCommande(ligne1);
		Commande cmd2 = new Commande();
		when(ligne1.toString()).thenReturn("ligne1");
		
		// When
		String string = cmd.toString();
		String string2 = cmd2.toString();
		
		// Then
		assertEquals("Tableau des Commandes :\n\t- ligne1", string);
		assertEquals("Tableau des Commandes :\n\tpas de commande", string2);
	}
	
	@Test
    void testNombreBouteillesGratuites1() {
        // Given
        when(client.getTypeClient()).thenReturn("particulier");
        when(client2.getTypeClient()).thenReturn("établissement public");
        
        // When
        int nbBouteilles = cmd.nombreBouteillesGratuites(50, client);
        int nbBouteilles2 = cmd.nombreBouteillesGratuites(200, client2);
        
        // Then
        assertEquals(4, nbBouteilles);
        assertEquals(3, nbBouteilles2);
    }
    
    @Test
    void testNombreBouteillesGratuites2() {
        // Given
        when(client.getTypeClient()).thenReturn("entreprise");
        when(client2.getTypeClient()).thenReturn("mouchoir");
        
        // When
        int nbBouteilles = cmd.nombreBouteillesGratuites(300, client);
        int nbBouteilles2 = cmd.nombreBouteillesGratuites(5, client2);
        
        // Then
        assertEquals(2, nbBouteilles);
        assertEquals(0, nbBouteilles2);
    }
    
    @Test
    void testMontantTotal() {
        // Given
        cmd.ajouterCommande(ligne1);
        cmd.ajouterCommande(ligne2);
        when(ligne1.getEau()).thenReturn(eau1);
        when(eau1.getPrix()).thenReturn(3.0);
        when(ligne1.getQuantite()).thenReturn(50);
        when(ligne2.getEau()).thenReturn(eau2);
        when(eau2.getPrix()).thenReturn(4.5);
        when(ligne2.getQuantite()).thenReturn(30);
        when(client.getTypeClient()).thenReturn("particulier");
        when(client.getPtsFidelite()).thenReturn(69);
        
        // When
        double total = cmd.montantTotal(client);
        
        // Then
        assertEquals(264.0, total);
    }
}

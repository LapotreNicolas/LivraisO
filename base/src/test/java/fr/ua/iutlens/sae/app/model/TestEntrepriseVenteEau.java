package fr.ua.iutlens.sae.app.model;

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
class TestEntrepriseVenteEau {

	EntrepriseVenteEau entreprise;
	
	@Mock
	Employe employe;
	
	@Mock
	Employe employe2;
	
	@Mock
	Employe employe3;

	@Mock
	Client client;

	@Mock
	Client client2;
	
	@Mock
	Client client3;

	@Mock
	Commande commande;

	@Mock
	Commande commande2;
	
	@Mock
	Commande commande3;
	
	@Mock
	StockEau stockEau;

	@Mock
	StockEau stockEau2;
	
	@Mock
	StockEau stockEau3;
	
	@BeforeEach
	void initEntreprise() {
		entreprise = new EntrepriseVenteEau("2404","Livrais'O");
	}
	
	@AfterEach
	void delEntreprise() {
		entreprise = null;
	}
	
	@Test
	void testGettersEtSetter() {
		// Given
		String nouveauNom = "SudO";
		
		// When
		String siret = entreprise.getSIRET();
		String nom = entreprise.getNom();
		entreprise.setNom(nouveauNom);
		String nom2 = entreprise.getNom();
		int nbEmploye = entreprise.getNbEmployes();
		boolean endette = entreprise.getEndette();
		
		
		// Then
		assertEquals("2404", siret);
		assertEquals("Livrais'O", nom);
		assertEquals(nouveauNom, nom2);
		assertEquals(0, nbEmploye);
	}
	
	@Test
	void testEmployes() {		
		// When
		int nb = entreprise.getNbEmployes();
		entreprise.embaucher(employe);
		entreprise.embaucher(employe2);
		entreprise.embaucher(employe3);
		int nb2 = entreprise.getNbEmployes();
		entreprise.licencier(employe2);
		int nb3 = entreprise.getNbEmployes();
		
		// Then
		assertEquals(0, nb);
		assertEquals(3, nb2);
		assertEquals(2, nb3);
	}

	@Test
	void testStock() {
		when(stockEau.getQuantite()).thenReturn(100);
		
		// When
		entreprise.achatStock(stockEau);
		entreprise.achatStock(stockEau2);
		entreprise.achatStock(stockEau3);
		int indice = entreprise.rechercherStock(stockEau);
		try {
			entreprise.venteStock(indice, 50);
		} catch (Exception e) {}
		entreprise.supprimerStock(stockEau2);
	}
	
	@Test
	void testClients() {		
		// When
		entreprise.enregistrerClient(client);
		entreprise.enregistrerClient(client2);
		entreprise.enregistrerClient(client3);
		entreprise.supprimerClient(client2);
	}
	
	@Test
	void testCommandes() {		
		// When
		entreprise.enregistrerCommande(commande);
		entreprise.enregistrerCommande(commande2);
		entreprise.enregistrerCommande(commande3);
		entreprise.supprimerCommande(commande2);
	}
	
	@Test
	void testVirements() {
		// When
		boolean endette = entreprise.getEndette();
		entreprise.recoisVirement(1.0);
		boolean endette2 = entreprise.getEndette();
		entreprise.effectueVirement(123.45);
		boolean endette3 = entreprise.getEndette();
		entreprise.effectueVirement(420.69);
		boolean endette4 = entreprise.getEndette();
		entreprise.recoisVirement(666.13);
		boolean endette5 = entreprise.getEndette();
		
		// Then
		assertFalse(endette);
		assertFalse(endette2);
		assertTrue(endette3);
		assertTrue(endette4);
		assertFalse(endette5);
	}
	
	@Test
	void testToString() {
		// Given
		when(employe.toString()).thenReturn("Employé");
		when(stockEau.toString()).thenReturn("Stock d'Eau");
		when(client.toString()).thenReturn("Client");
		when(commande.toString()).thenReturn("Commande");
    	entreprise.embaucher(employe);
    	entreprise.achatStock(stockEau);
    	entreprise.enregistrerClient(client);
    	entreprise.enregistrerCommande(commande);	
		
		// When 
		String string = entreprise.toString();
		
		// Then
		assertEquals("Entreprise : Livrais'O\nSIRET : 2404\nPossède 1 Employés\nListe des employés :\n\t- Employé\nTableau des Stocks d'Eau :\n\t- Stock d'Eau\nListe des clients :\n\t- Client\nListe des commandes :\n\t- Commande\n0.0 € en disponibilités\nEndetté ? false", string);
	}
    
    @Test
	void testToStringVide() {
		// When 
		String string = entreprise.toString();
		
		// Then
		assertEquals("Entreprise : Livrais'O\nSIRET : 2404\nPossède 0 Employés\nListe des employés :\n\tpas d'employé\nTableau des Stocks d'Eau :\n\tpas de stock\nListe des clients :\n\tpas de client\nListe des commandes :\n\tpas de commande\n0.0 € en disponibilités\nEndetté ? false", string);
	}
    
	@Test
	void testToHash() {
		// Given
		ObservableList<Employe> employes = FXCollections.observableArrayList(employe, employe2, employe3);
		EntrepriseVenteEau entreprise2 = new EntrepriseVenteEau("2404","Livrais'O");
		EntrepriseVenteEau entreprise3 = new EntrepriseVenteEau("2111","SudO",employes);
        
		// When
		int hash1 = entreprise.hashCode();
		int hash2 = entreprise2.hashCode();
		int hash3 = entreprise3.hashCode();
		
		// Then
		assertEquals(hash1, hash2);
		assertNotEquals(hash1, hash3);
		assertNotEquals(hash2, hash3);
	}
	
	@Test
    void testEquals() {
        // Given
		ObservableList<Employe> employes = FXCollections.observableArrayList(employe, employe2, employe3);
		EntrepriseVenteEau entreprise2 = new EntrepriseVenteEau("2404","SudO",employes);
		EntrepriseVenteEau entreprise3 = new EntrepriseVenteEau("2111","Livrais'O");
        
        // When
        boolean equals11 = entreprise.equals(entreprise);
        boolean equals12 = entreprise.equals(entreprise2);
        boolean equals13 = entreprise.equals(entreprise3);
        boolean equals1 = entreprise.equals(null);
        boolean equals1client = entreprise.equals(client);
        
        // Then
        assertTrue(equals11);
        assertTrue(equals12);
        assertFalse(equals13);
        assertFalse(equals1);
        assertFalse(equals1client);
    }
}

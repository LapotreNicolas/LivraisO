package fr.ua.iutlens.sae.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import javax.annotation.MatchesPattern;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
	
	
}

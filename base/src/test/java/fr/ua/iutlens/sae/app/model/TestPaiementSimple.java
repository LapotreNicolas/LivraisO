package fr.ua.iutlens.sae.app.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.ua.iutlens.sae.app.model.Client;
import fr.ua.iutlens.sae.app.model.Commande;
import fr.ua.iutlens.sae.app.model.Eau;
import fr.ua.iutlens.sae.app.model.LigneDeCommande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * @author nicolas.lapotre
 *
 */
@ExtendWith(MockitoExtension.class)
class TestPaiementSimple {

	PaiementSimple paiementSimple = new PaiementSimple();
	
	@Mock
	Paiement paiement;
	
	@Test
	void testExecutePaiement() {
		// Given
		when(paiement.getMontant()).thenReturn(666.13);
		
		// When
		paiementSimple.executePaiement(paiement);
	}

	@Test
	void testRemboursement() {
		// Given
		when(paiement.getMontant()).thenReturn(420.69);
		
		// When
		paiementSimple.remboursement(paiement);
	}
}

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

class TestPaiementSimple {

	PaiementSimple paiementSimple;
	
	@Mock
	Paiement paiement;
	
	@Test
	void testExecutePaiement() {
		// When
		paiementSimple.executePaiement(paiement);
	}

	@Test
	void testExecutePaiement() {
		// When
		paiementSimple.remboursement(paiement);
	}
}

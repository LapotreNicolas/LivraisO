package fr.ua.iutlens.sae.app.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.Mock;

/**
 * Classe de test pour la classe ClientEtablissementPublic
 * 
 * @author jules
 *
 */
@ExtendWith(MockitoExtension.class)
public class TestClientEtablissementPublic {
	
    @Mock
	Adresse adresseLambda;
    
    private ClientEtablissementPublic client1;
    private ClientEtablissementPublic client2;
    private ClientEtablissementPublic client3;
    
    @BeforeEach
    public void setUp() {
    	// Crée les instances de ClientEtablissementPublic pour les tests
        client1 = new ClientEtablissementPublic("12/05/2021", adresseLambda, "0605124200", "John.Doe@mail.com",
                "Doe", ClientEtablissementPublic.Type.EPIC);
        client2 = new ClientEtablissementPublic("15/06/2023", adresseLambda, "0606060606", "System32@mail.com",
                "System32", ClientEtablissementPublic.Type.EPA);
        client3 = new ClientEtablissementPublic("12/05/2021", adresseLambda, "0605124200", "John.Doe@mail.com",
                "Doe", ClientEtablissementPublic.Type.EPIC);
    }

    /**
     * Depuis la classe {@link ClientEtablissementPublic}
     * <br>
     * Vérifie la méthode {@link ClientEtablissementPublic#getNom()}
     */
    @Test
    public void testGetNom() {
    	// Récupère le nom du client1
    	String nom = client1.getNom();
    	
    	// Vérifie que le nom correspond à celui attendu
        assertEquals("Doe", nom);
        assertNotEquals("System32", nom);
    }

    /**
     * Depuis la classe {@link ClientEtablissementPublic}
     * <br>
     * Vérifie la méthode {@link ClientEtablissementPublic#getType()}
     */
    @Test
    public void testGetType() {
    	// Récupère le type du client1
    	ClientEtablissementPublic.Type type = client1.getType();
    	
    	// Vérifie que le type correspond à celui attendu
        assertEquals(ClientEtablissementPublic.Type.EPIC, type);
        assertNotEquals(ClientEtablissementPublic.Type.EPA, type);
    }

    /**
     * Depuis la classe {@link ClientEtablissementPublic}
     * <br>
     * Vérifie la méthode {@link ClientEtablissementPublic#getTypeClient()}
     */
    @Test
    public void testGetTypeClient() {
    	// Récupère le type client du client1
    	String typeClient = client1.getTypeClient();
    	
    	// Vérifie que le type client correspond à celui attendu
        assertEquals("établissement publique", typeClient);
    }

    /**
     * Depuis la classe {@link ClientEtablissementPublic}
     * <br>
     * Vérifie la méthode {@link ClientEtablissementPublic#ajoutPointsFidelite(double)}
     */
    @Test
    public void testAjoutPointsFidelite() {
    	// When 	
        client1.ajoutPointsFidelite(1000);
        int ptsFidelite = client1.getPtsFidelite();
        
        // Then
        assertEquals(20, ptsFidelite);
    }

    /**
     * Depuis la classe {@link ClientEtablissementPublic}
     * <br>
     * Vérifie le résultat de la méthode surchargée {@link ClientEtablissementPublic#toString()}
     */
    @Test
    public void testToString() {
    	// When
        String expected = "\n\tClient Etablissement Publique\n------------------------------------\n\tCode : 32	Inscrit en : 12/05/2021	Mail : John.Doe@mail.com\n\tTelephone : 0605124200	Adresse : adresseLambda\n\tPoints de fidélité : 0 Publique\n\tNom : Doe	type : EPIC";
        String stringResult = client1.toString();
        
        // Then
        assertEquals(expected, stringResult);
    }
    
    /**
     * Depuis la classe {@link ClientEtablissementPublic}
     * <br>
     * Vérifie l'égalité entre les instances de ClientEtablissementPublic
     */
    @Test
    public void testEquals() {
        // Vérifie que deux instances identiques ne sont pas considérées comme égales (à cause de l'attiribut code)
        assertNotEquals(client1, client2);

        // Vérifie que l'égalité est réflexive
        assertEquals(client1, client1);
    }
    
    /**
     * Depuis la classe {@link ClientEtablissementPublic}
     * <br>
     * Vérifie le hashCode des instances de ClientEtablissementPublic
     */
    @Test
    public void testHashCode() {
        // Vérifie que le hashCode est différent malgré les mêmes attributs pour les deux instances (à cause de l'attribut code)
        assertNotEquals(client1.hashCode(), client3.hashCode());
    }
}

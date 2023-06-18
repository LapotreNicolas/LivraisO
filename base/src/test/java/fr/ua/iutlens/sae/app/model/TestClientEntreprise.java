package fr.ua.iutlens.sae.app.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Classe de test pour la classe ClientEntreprise
 * 
 * @author jules
 *
 */
@ExtendWith(MockitoExtension.class)
class TestClientEntreprise {

    private ClientEntreprise client1;
    private ClientEntreprise client2;
    private ClientEntreprise client3;

    @Mock
    Adresse adresse1;
    
    @Mock
    Adresse adresse2;
    
    @Mock
    Adresse adresse3;
    
    @BeforeEach
    void setUp() {
    	client1 = new ClientEntreprise("12/05/2021", adresse1, "0605124200", "john.doe@mail.com", "Doe Company", "123456789");
        client2 = new ClientEntreprise("12/05/2021", adresse1, "0605124200", "john.doe@mail.com", "Doe Company", "123456789");
        client3 = new ClientEntreprise("15/06/2023", adresse2, "0606060606", "system32@mail.com", "System32 Corp", "987654321");
    }

    /**
     * Depuis la classe {@link ClientEntreprise}
     * <br>
     * Vérifie la méthode {@link ClientEntreprise#hashCode()}.
     */
    @Test
    void testHashCode() {
        int hashCode1 = client1.hashCode();
        int hashCode2 = client2.hashCode();

        assertNotEquals(hashCode1, hashCode2);
    }

    /**
     * Depuis la classe {@link ClientEntreprise}
     * <br>
     * Vérifie la méthode {@link ClientEntreprise#equals(Object)}.
     */
    @Test
    void testEqualsObject() {
        assertEquals(client1, client2); // Deux clients avec les mêmes attributs doivent être égaux
        assertNotEquals(client1, client3); // Deux clients avec des attributs différents ne doivent pas être égaux
    }

    /**
     * Depuis la classe {@link ClientEntreprise}
     * <br>
     * Vérifie la méthode {@link ClientEntreprise#getTypeClient()}.
     */
    @Test
    void testGetTypeClient() {
        String typeClient = client1.getTypeClient();

        assertEquals("entreprise", typeClient);
    }

    /**
     * Depuis la classe {@link ClientEntreprise}
     * <br>
     * Vérifie la méthode {@link ClientEntreprise#ajoutPointsFidelite(double)}.
     */
    @Test
    void testAjoutPointsFidelite() {
        client1.ajoutPointsFidelite(1200);

        assertEquals(10, client1.getPtsFidelite());
    }

    /**
     * Depuis la classe {@link ClientEntreprise}
     * <br>
     * Vérifie la méthode {@link ClientEntreprise#toString()}.
     */
    @Test
    void testToString() {
        String clientString = client1.toString();

        String expectedString = "\n\tClient Entreprise\n------------------------------------\n\tCode : 4\tInscrit en : 12/05/2021\tMail : john.doe@mail.com\n\tTelephone : 0605124200\tAdresse : adresse1\n\tPoints de fidélité : 0\n\t Nom : Doe Company\tSIRET : 123456789";
        assertEquals(expectedString, clientString);
    }

    /**
     * Depuis la classe {@link ClientEntreprise}
     * <br>
     * Vérifie le constructeur {@link ClientEntreprise#ClientEntreprise(String, Adresse, String, String, String, String)}.
     */
    @Test
    void testClientEntreprise() {
    	when(adresse1.toString()).thenReturn("123 rue A, Ville, France");
    	
        assertNotNull(client1);
        assertEquals("12/05/2021", client1.getDateInscription());
        assertEquals("123 rue A, Ville, France", client1.getAdresse().toString());
        assertEquals("0605124200", client1.getNumTelephone());
        assertEquals("john.doe@mail.com", client1.getAdresseMail());
        assertEquals("Doe Company", client1.getNom());
        assertEquals("123456789", client1.getSIRET());
    }

    /**
     * Depuis la classe {@link ClientEntreprise}
     * <br>
     * Vérifie la méthode {@link ClientEntreprise#getNom()}.
     */
    @Test
    void testGetNom() {
        String nom = client1.getNom();

        assertEquals("Doe Company", nom);
    }

    /**
     * Depuis la classe {@link ClientEntreprise}
     * <br>
     * Vérifie la méthode {@link ClientEntreprise#getSIRET()}.
     */
    @Test
    void testGetSIRET() {
        String siret = client1.getSIRET();

        assertEquals("123456789", siret);
    }
}

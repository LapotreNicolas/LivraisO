package fr.ua.iutlens.sae.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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
    
    @BeforeEach
    void initS() {
        sg = new StockGlobal();
    }
    
    @AfterEach
    void delS() {
        sg = null;
    }
    
    @Test
    void testReduireQuantite() {
        // Given
        sg.ajouter(se);
        when(se.getQuantite()).thenReturn(30);
        
        // When
        sg.reduireQuantite(0, 20);
    }
    
    @Test
    void testReduireQuantiteException() {
        // Given
        sg.ajouter(se);
        when(se.getQuantite()).thenReturn(10);
        
        // When Then
        assertThrows(Exception.class, () -> sg.reduireQuantite(0, 20));
    }
}
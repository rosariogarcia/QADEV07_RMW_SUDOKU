package gameTest;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.NumberException;
import game.ImputValidate;

public class ImputValidateTest {

    @Test (expected = NumberException.class)
    public void readValuesWithString() throws NumberException {
        String readKeyboard = "00t02060y9003uu001001806400008102900700000008006708200002609500800203009005010300";
        assertEquals(ImputValidate.isNumeric(readKeyboard),false);
    }
    
    @Test (expected = NumberException.class)
    public void readValuesWithOnlyNumber() throws NumberException {
        String readKeyboard = "001020600900300001001806400008102900700000008006708200002609500800203009005010300";
        assertTrue(ImputValidate.isNumeric(readKeyboard));
    }
    
    @Test
    public void readValuesWithLessThan81Positions() {
        String reedKeyboard = "020600900300001001806400008102900700000008006708200002609500800203009005010300";
        assertFalse(ImputValidate.contain81position(reedKeyboard));
    }
    
    @Test
    public void readValuesWithMoreThan81Positions() {
        String reedKeyboard = "001789065020600900300001001806400008102900700000008006708200002609500800203009005010300";
        assertFalse(ImputValidate.contain81position(reedKeyboard));
    }
    
    @Test
    public void readSodukoXkeyboardValid() {
        String reedKeyboard = "001789065020600900300001001806400008102900700000008006708200002609500800203009005010300";
        assertFalse(ImputValidate.contain81position(reedKeyboard));
    }
    

}

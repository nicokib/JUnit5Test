package be.abis.exercise.test;

import be.abis.exercise.model.Address;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void belgianZipCodeShouldBeNumeric() {
        System.out.println("belgianZipCodeShouldBeNumeric");
        //Address adr1 = new Address("Rue de Bruxelles", "24", "90260", "Brussels", "Belgium", "32");
        Address adr1 = new Address("Rue de Bruxelles", "24", "1050", "Brussels", "Belgium", "32");
        assertTrue(adr1.isBelgianZipCodeNumeric());
        Address adr2 = new Address("Rue de Nivelles", "24", "7250", "Buzet", "", "");
        assertTrue(adr2.isBelgianZipCodeNumeric());
    }

    @Test
    public void testWrite() {
        System.out.println("testWrite");
        Address adr = new Address("Rue de Bruxelles", "24", "1050", "Brussels", "Belgium", "32");
        assertDoesNotThrow(() -> adr.write());
    }
}

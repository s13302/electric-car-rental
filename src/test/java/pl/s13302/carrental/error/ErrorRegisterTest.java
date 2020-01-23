package pl.s13302.carrental.error;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class ErrorRegisterTest {

    @Test
    public void testAddErrorToRegister() {
        // Given:
        String errorMessage = "Error message";
        ErrorRegister.addError(errorMessage);

        // When:
        Collection<String> registeredErrors = ErrorRegister.getRegisteredErrors();

        // Then:
        assertNotNull("Collection of errors should not be null", registeredErrors);
        assertEquals("Collection of errors should contain 1 error", 1, registeredErrors.size());
        assertTrue("Error message should be contain given error message", registeredErrors.contains(errorMessage));
    }

}

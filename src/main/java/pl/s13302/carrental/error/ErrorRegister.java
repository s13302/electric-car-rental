package pl.s13302.carrental.error;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ErrorRegister {

    private static final Set<String> REGISTERED_ERRORS = new HashSet<String>();

    public static void addError(String errorMessage) {
        REGISTERED_ERRORS.add(errorMessage);
    }

    public static Collection<String> getRegisteredErrors() {
        Collection<String> errors = Collections.unmodifiableSet(new HashSet<String>(REGISTERED_ERRORS));
        REGISTERED_ERRORS.clear();
        return errors;
    }

}

package util;

public class NoSuchElementException
        extends RuntimeException {

    NoSuchElementException() {
        super("No Such exception");
    }

    NoSuchElementException(String message) {
        super(message);
    }

} // NOSuchElementException

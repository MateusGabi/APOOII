package util;

/**
 *
 * @author 201519060149
 */
public class IllegalStateException 
    extends RuntimeException {

    IllegalStateException() {
        super("Illegal State");
    }

    IllegalStateException(String message) {
        super(message);
    }
}

package cz.muni.fi.pb162.find.exceptions;

import java.io.IOException;

/**
 * Exception will be thrown when any error occurs or other exception will be thrown,
 * If another exception will be thrown, you should catch it and throw SimpleSearchException
 * and pass the original exception as an argument.
 * @author pstanko
 */
public class SimpleSearchException extends IOException {
    public SimpleSearchException() {
    }

    public SimpleSearchException(String message) {
        super(message);
    }

    public SimpleSearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public SimpleSearchException(Throwable cause) {
        super(cause);
    }
}

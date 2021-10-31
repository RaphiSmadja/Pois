package exception;

public class TsvException extends RuntimeException {
    public TsvException(String errorMessage) {
        super(errorMessage);
    }
}

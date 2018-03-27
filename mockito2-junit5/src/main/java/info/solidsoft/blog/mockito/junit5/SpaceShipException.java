package info.solidsoft.blog.mockito.junit5;

public class SpaceShipException extends RuntimeException {

    public SpaceShipException() {
        super();
    }

    public SpaceShipException(String message) {
        super(message);
    }

    public SpaceShipException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpaceShipException(Throwable cause) {
        super(cause);
    }

    protected SpaceShipException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

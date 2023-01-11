package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private String message;

    public NegativeRadiusException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static final NegativeRadiusException INVALID_RADIUS =
            new NegativeRadiusException("Не удалось посчитать площадь");
}

// END

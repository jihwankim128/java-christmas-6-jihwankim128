package christmas.utility;

public class InputDataException {
    public static void validateInputSize(final int inputData) {
        if (inputData != 2) {
            throw new IllegalArgumentException(IllegalArgumentMessage.INVALID_ORDER);
        }
    }

    public static void validateInteger(final String inputData, final String message) {
        if (!inputData.matches("\\d+")) {
            throw new IllegalArgumentException(message);
        }
    }
}

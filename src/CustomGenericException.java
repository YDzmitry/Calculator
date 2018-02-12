

public class CustomGenericException extends Exception {
    private int errorCode;
    private String errorMessage;

    public CustomGenericException(String message) {
        this(0, message);
        errorMessage = message;
    }


    public CustomGenericException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public String getErrMessage() {
        return errorMessage;
    }
}
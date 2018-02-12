

public class CustomGenericException extends Exception
{
    private int errorCode;

    public CustomGenericException(String message)
    {
        this(0, message);
    }


    public CustomGenericException(int errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }


    public int getErrorCode()
    {
        return errorCode;
    }
}
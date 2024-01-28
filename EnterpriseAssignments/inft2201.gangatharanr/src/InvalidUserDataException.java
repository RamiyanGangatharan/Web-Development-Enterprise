public class InvalidUserDataException extends Exception
{
    private static final long serialVersionID = 1L;

    // Default
    public InvalidUserDataException(){super("Invalid User Data"); }

    // Parameter
    public InvalidUserDataException(String message){super(message);}

}

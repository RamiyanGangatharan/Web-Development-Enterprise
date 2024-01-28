public class InvalidPasswordException extends Exception
{
    private static final long serialVersionID = 1L;

    // Default
    public InvalidPasswordException(){super("Invalid Password"); }

    // Parameter
    public InvalidPasswordException(String message){super(message);}
}

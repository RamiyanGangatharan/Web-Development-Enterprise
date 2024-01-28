public class InvalidNameException extends Exception
{
    private static final long serialVersionID = 1L;

    // Default
    public InvalidNameException(){super("Invalid Name"); }

    // Parameter
    public InvalidNameException(String message){super(message);}
}

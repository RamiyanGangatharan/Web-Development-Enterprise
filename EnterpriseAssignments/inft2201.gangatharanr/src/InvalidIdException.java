public class InvalidIdException extends Exception
{
    private static final long serialVersionID = 1L;

    // Default
    public InvalidIdException(){super("Invalid ID"); }

    // Parameter
    public InvalidIdException(String message){super(message);}
}

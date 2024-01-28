/**
 * Represents an exception that is thrown when an invalid ID is encountered.
 * This class extends the {@link Exception} class and provides two constructors:
 * one without parameters that uses a default error message and another that accepts
 * a custom message.
 *
 * @author Ramiyan Gangatharan
 * @version 1.6 (January 28, 2024)
 * @since 1.0 (January 14, 2024)
 */
public class InvalidIdException extends Exception
{
    // Unique identifier for this Serializable class.
    // This is used to verify that the sender and receiver of a serialized object have loaded classes
    // for that object that are compatible with respect to serialization.
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an {@code InvalidIdException} with the default error message "Invalid ID".
     */
    public InvalidIdException()
    {
        super("Invalid ID");
    }

    /**
     * Constructs an {@code InvalidIdException} with a custom message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidIdException(String message)
    {
        super(message);
    }
}
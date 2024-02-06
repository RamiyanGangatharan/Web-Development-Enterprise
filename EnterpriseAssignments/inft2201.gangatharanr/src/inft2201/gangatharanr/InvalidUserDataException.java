package inft2201.gangatharanr;

/**
 * Represents an exception that is thrown when invalid user data is encountered.
 * This class extends {@link Exception} and offers two constructors:
 * a default constructor that uses a standard error message, and a parameterized constructor that allows for a custom message.
 */
@SuppressWarnings("Serial")
public class InvalidUserDataException extends Exception
{
    // Unique identifier for this Serializable class.
    // This ID is used during the deserialization process to ensure that a loaded class is compatible with the serialized object.
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an {@code InvalidUserDataException} with the default error message "Invalid User Data".
     * This constructor initializes the exception with a general message indicating that the provided user data is invalid.
     *
     * @author Ramiyan Gangatharan
     * @version 1.6 (January 28, 2024)
     * @since 1.0 (January 14, 2024)
     */
    public InvalidUserDataException()
    {
        super("Invalid User Data");
    }

    /**
     * Constructs an {@code InvalidUserDataException} with a custom message.
     * This constructor allows for specifying a detailed message that can more precisely describe the nature of the invalid user data.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidUserDataException(String message)
    {
        super(message);
    }
}
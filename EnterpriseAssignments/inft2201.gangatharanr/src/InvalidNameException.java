/**
 * Represents an exception that is thrown when an invalid name is encountered.
 * This class extends the {@link Exception} class to provide specialized behavior
 * for situations where name validation fails. It includes a default constructor
 * with a predefined error message and a parameterized constructor that allows
 * for the specification of a custom message.
 */
public class InvalidNameException extends Exception
{
    // Unique identifier for this Serializable class.
    // This identifier is used to ensure that the sender and receiver of a serialized object
    // have loaded compatible classes for that object with respect to serialization.
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an {@code InvalidNameException} with the default error message "Invalid Name".
     * This constructor initializes a new instance of {@code InvalidNameException} with a general
     * error message indicating that the name provided does not meet the validation criteria.
     */
    public InvalidNameException()
    {
        super("Invalid Name");
    }

    /**
     * Constructs an {@code InvalidNameException} with a custom message.
     * This constructor allows for the specification of a detailed message that can more
     * accurately describe the reason for the exception, providing more context or detail
     * about the validation failure.
     *
     * @param message the detail message. The detail message is saved for later retrieval
     *                by the {@link #getMessage()} method.
     *
     * @author Ramiyan Gangatharan
     * @version 1.6 (January 28, 2024)
     * @since 1.0 (January 14, 2024)
     */
    public InvalidNameException(String message)
    {
        super(message);
    }
}
package inft2201.gangatharanr;

/**
 * Represents an exception that is thrown when an invalid password is encountered.
 * This class extends the {@link Exception} class and provides two constructors:
 * one without parameters that uses a default error message and another that accepts
 * a custom message.
 *
 * @author Ramiyan Gangatharan
 * @version 1.6 (January 28, 2024)
 * @since 1.0 (January 14, 2024)
 */
@SuppressWarnings("Serial")
public class InvalidPasswordException extends Exception
{
    // Unique identifier for this Serializable class.
    // This is used to verify that the sender and receiver of a serialized object have loaded classes
    // for that object that are compatible with respect to serialization.
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an {@code InvalidPasswordException} with the default error message "Invalid Password".
     * This constructor initializes a new instance of {@code InvalidPasswordException} with a predefined
     * error message indicating that the password provided is invalid.
     */
    public InvalidPasswordException()
    {
        super("Invalid Password");
    }

    /**
     * Constructs an {@code InvalidPasswordException} with a custom message.
     * This constructor allows for the specification of a detailed message that can describe the reason
     * for the exception more precisely.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidPasswordException(String message)
    {
        super(message);
    }
}
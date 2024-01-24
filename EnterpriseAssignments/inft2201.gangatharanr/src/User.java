import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Represents a user in the system. This class stores user-specific information
 * and provides methods to access and modify this information. It implements
 * the CollegeInterface and adheres to its standards.
 *
 * The class contains several static constants for default values like ID, password,
 * name, and email address. It also includes methods for verifying user IDs and
 * formatting date information according to Canadian standards.
 *
 * @author Ramiyan Gangatharan
 * @version 1.4 (January 23, 2024)
 * @since 1.0 (January 14, 2024)
 */

public class User implements CollegeInterface
{
    // Constants for default values
    public static final long DEFAULT_ID = 100123456;
    public static final String DEFAULT_PASSWORD = "password";
    public static final byte MINIMUM_PASSWORD_LENGTH = 8;
    public static final byte MAXIMUM_PASSWORD_LENGTH = 40;
    public static final String DEFAULT_FIRST_NAME = "John";
    public static final String DEFAULT_LAST_NAME = "Doe";
    public static final String DEFAULT_EMAIL_ADDRESS = "john.doe@dcmail.com";
    public static final Boolean DEFAULT_ENABLED_STATUS = true;
    public static final char DEFAULT_TYPE = 's';
    public static final byte ID_NUMBER_LENGTH = 9;
    protected static final DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

    // User-specific attributes
    private long id;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private Date lastAccess;
    private Date enrolDate;
    private boolean enabled;
    private char type;

    // Accessor Methods
    public long getId() { return id;}
    public String getPassword() { return password;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmailAddress() {return emailAddress;}
    public Date getLastAccess() {return lastAccess;}
    public Date getEnrolDate() {return enrolDate;}
    public boolean isEnabled() {return enabled;}
    public char getType() { return type;}
    public static DateFormat getDF() {return DF;}

    // Mutator Methods
    public void setId(long id) {this.id = id; }
    public void setPassword(String password) {this.password = password;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public void setLastAccess(Date lastAccess) {this.lastAccess = lastAccess;}
    public void setEnrolDate(Date enrolDate) {this.enrolDate = enrolDate; }
    public void setEnabled(boolean enabled) {this.enabled = enabled;}
    public void setType(char type) {this.type = type;}

    /**
     * Default constructor which initializes a user with default values.
     */
    public User()
    {
        // Initialization
        setId(DEFAULT_ID);
        setPassword(DEFAULT_PASSWORD);
        setFirstName(DEFAULT_FIRST_NAME);
        setLastName(DEFAULT_LAST_NAME);
        setEmailAddress(DEFAULT_EMAIL_ADDRESS);
        setEnrolDate(new Date());
        setLastAccess(new Date());
        setEnabled(enabled);
        setType(DEFAULT_TYPE);
    }

    /**
     * Parameterized constructor for creating a user with specific attributes.
     *
     * @param id The user's identification number.
     * @param password The user's password.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @param emailAddress The user's email address.
     * @param lastAccess The date of the user's last access.
     * @param enrolDate The date when the user was enrolled.
     * @param enabled The status indicating whether the user is enabled.
     * @param type The type of the user.
     */
    public User
    (
        long id, String password, String firstName, String lastName, String emailAddress,
        Date lastAccess, Date enrolDate, boolean enabled, char type
    )
    {
        // Initialization
        setId(id);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(emailAddress);
        setLastAccess(lastAccess);
        setEnrolDate(enrolDate);
        setEnabled(enabled);
        setType(type);
    }

    /**
     * Returns a string representation of the User object.
     *
     * @return A string detailing the user's ID, name, email, creation date, and last access date.
     */
    @Override
    public String toString()
    {
        DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

        return String.format
        (
            "User Info for: %d \n" +
                    "\tName: %s %s (%s) \n" +
                    "\tCreated on: %s\n" +
                    "\tLast Access: %s",
            id,
            firstName,
            lastName,
            emailAddress,
            DF.format(enrolDate), // Directly passes the Date object
            DF.format(lastAccess) // Directly passes the Date object
        );
    }

    /**
     * Prints the user's information to the console.
     */
    public void dump() {System.out.println(this);}

    /**
     * Verifies if the provided ID is a valid 9-digit number.
     *
     * @param id The ID to be verified.
     * @return true if the ID is 9 digits long, false otherwise.
     */
    public static boolean verifyId(long id)
    {
        int count = String.valueOf(id).length();
        return count == ID_NUMBER_LENGTH;
    }
}
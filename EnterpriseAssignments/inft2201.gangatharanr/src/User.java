import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Represents a user in a college context, implementing the CollegeInterface. This class includes properties such as
 * identification number, password, name, email address, and dates for enrolment and last access. It provides methods
 * to get and set user attributes and other functionalities like ID verification and printing user information.
 *
 * @author Ramiyan Gangatharan
 * @version 1.5 (January 24, 2024)
 * @since 1.0 (January 14, 2024)
 */

public class User implements CollegeInterface
{
    // Constants defining default and boundary values
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
    public void setId(long id) throws InvalidIdException
    {
        if(verifyId(id)){this.id = id;}
        else{throw new InvalidIdException("This ID is not valid!");}
    }
    public void setPassword(String password) throws InvalidPasswordException
    {
        if
        (
            !password.isEmpty() &&
            password.length() >= MINIMUM_PASSWORD_LENGTH && password.length() <= MAXIMUM_PASSWORD_LENGTH)
            {this.password = password;}
        else{throw new InvalidPasswordException("This is an invalid password!");}
    }

    //This is the first time I have used REGEX in java but it essentially checks if the input is numeric.
    public void setFirstName(String firstName) throws InvalidNameException
    {
        if(!firstName.isEmpty() && !firstName.matches("\\d+")) {this.firstName = firstName;}
        else {throw new InvalidNameException("This firstname is not valid!");}
    }
    public void setLastName(String lastName) throws InvalidNameException
    {
        if (!lastName.isEmpty() && !lastName.matches("\\d+")){this.lastName = lastName;}
        else { throw new InvalidNameException("This lastname is not valid!"); }
    }
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public void setLastAccess(Date lastAccess) {this.lastAccess = lastAccess;}
    public void setEnrolDate(Date enrolDate) {this.enrolDate = enrolDate; }
    public void setEnabled(boolean enabled) {this.enabled = enabled;}
    public void setType(char type) {this.type = type;}

    /**
     * Default constructor. Initializes a user with default values for all fields.
     */
    public User() throws InvalidIdException, InvalidPasswordException, InvalidNameException
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
     * Parameterized constructor to create a user with specific attributes.
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
            throws InvalidIdException, InvalidNameException, InvalidPasswordException
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
     * Returns a string representation of the User object, detailing user's ID, name, email, creation date, and last access date.
     *
     * @return A formatted string containing the user's details.
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
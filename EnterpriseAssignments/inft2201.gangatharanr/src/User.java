import sun.util.calendar.LocalGregorianCalendar;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * This is the User class.
 * @author Ramiyan Gangatharan
 * @version 1.2 (January 22, 2024)
 * @since 1.0 (January 14, 2024)
 */
public class User implements CollegeInterface
{
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
    private static final DateFormat
            DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);
    private long id;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private LocalGregorianCalendar.Date lastAccess;
    private LocalGregorianCalendar.Date enrolDate;
    private boolean enabled;
    private char type;

    public long getId(){return id; }
    public String getPassword() {return password;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName; }
    public String getEmailAddress() {return emailAddress;}
    public LocalGregorianCalendar.Date getLastAccess() {return lastAccess;}
    public LocalGregorianCalendar.Date getEnrolDate() {return enrolDate;}
    public char getType() {return type; }
    public static DateFormat getDF(){ return DF;}
    public void setId(long id) {this.id = id;}
    public void setPassword(String password) {this.password = password;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}
    public void setLastAccess(LocalGregorianCalendar.Date lastAccess) {this.lastAccess = lastAccess;}
    public void setEnrolDate(LocalGregorianCalendar.Date enrolDate) {this.enrolDate = enrolDate;}
    public void setEnabled(boolean enabled) {this.enabled = enabled;}
    public void setType(char type) {this.type = type;}

    public User()
    {
        this.id = DEFAULT_ID;
        this.password = DEFAULT_PASSWORD;
        this.firstName = DEFAULT_FIRST_NAME;
        this.lastName = DEFAULT_LAST_NAME;
        this.emailAddress = DEFAULT_EMAIL_ADDRESS;
        setEnrolDate(this.enrolDate);
        setLastAccess(this.lastAccess);
        this.type = DEFAULT_TYPE;
    }

    public User
        (
            long id, String password, String firstName, String lastName, String emailAddress,
            LocalGregorianCalendar.Date lastAccess, LocalGregorianCalendar.Date enrolDate, boolean enabled, char type
        )
    {
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.lastAccess = lastAccess;
        this.enrolDate = enrolDate;
        this.enabled = enabled;
        this.type = type;
    }

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
                    DF.format(enrolDate),
                    DF.format(lastAccess)
            );
    }

    public void dump()
    {
        System.out.println(this.toString());
    }

    public static boolean verifyId(long id)
    {
        int count = String.valueOf(id).length();
        return count == 9;
    }
}

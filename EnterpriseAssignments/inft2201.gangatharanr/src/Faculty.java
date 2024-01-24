import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Represents a faculty member in a college context. This class extends the User class, adding specific properties
 * related to faculty members like school code, school description, office location, and phone extension. It provides
 * methods to get and set the faculty member's professional details.
 *
 * @author Ramiyan Gangatharan
 * @version 1.5 (January 24, 2024)
 * @since 1.0 (January 14, 2024)
 */
public class Faculty extends User
{
    User user = new User();
    /**
     * The default school code for the faculty.
     */
    public static final String DEFAULT_SCHOOL_CODE = "SET";

    /**
     * The default school description for the faculty.
     */
    public static final String DEFAULT_SCHOOL_DESCRIPTION = "School of Engineering & Technology";

    /**
     * The default office location for the faculty.
     */
    public static final String DEFAULT_OFFICE = "H-140";

    /**
     * The default phone extension number for the faculty.
     */
    public static final int DEFAULT_PHONE_EXTENSION = 1234;

    /**
     * The school code associated with the faculty member.
     */
    private String schoolCode;

    /**
     * The description of the school where the faculty member works.
     */
    private String schoolDescription;

    /**
     * The office location of the faculty member.
     */
    private String office;

    /**
     * The phone extension number for the faculty member.
     */
    private int extension;

    /**
     * Retrieves the school code associated with the faculty member.
     *
     * @return A string representing the school code.
     */
    public String getSchoolCode() { return schoolCode;}

    /**
     * Retrieves the description of the school where the faculty member works.
     *
     * @return A string representing the school description.
     */
    public String getSchoolDescription() {return schoolDescription;}

    /**
     * Retrieves the office location of the faculty member.
     *
     * @return A string representing the office location.
     */
    public String getOffice() {return office;}

    /**
     * Retrieves the phone extension number for the faculty member.
     *
     * @return An integer representing the phone extension.
     */
    public int getExtension() {return extension;}

    /**
     * Sets the school code associated with the faculty member.
     *
     * @param schoolCode A string representing the school code.
     */
    public void setSchoolCode(String schoolCode) {this.schoolCode = schoolCode;}

    /**
     * Sets the description of the school where the faculty member works.
     *
     * @param schoolDescription A string representing the school description.
     */
    public void setSchoolDescription(String schoolDescription) {this.schoolDescription = schoolDescription;}

    /**
     * Sets the office location of the faculty member.
     *
     * @param office A string representing the office location.
     */
    public void setOffice(String office) {this.office = office;}

    /**
     * Sets the phone extension number for the faculty member.
     *
     * @param extension An integer representing the phone extension.
     */
    public void setExtension(int extension) {this.extension = extension;}

    /**
     * Default constructor. Initializes a new faculty member with default values for school code, school description, office location, and phone extension.
     */
    public Faculty()
    {
        // Call to parent's default constructor
        super();

        setSchoolCode(DEFAULT_SCHOOL_CODE);
        setSchoolDescription(DEFAULT_SCHOOL_DESCRIPTION);
        setOffice(DEFAULT_OFFICE);
        setExtension(DEFAULT_PHONE_EXTENSION);
    }

    /**
     * Parameterized constructor. Initializes a new faculty member with the specified school code, school description, office location, and phone extension.
     *
     * @param id The user ID of the faculty member.
     * @param password The password of the faculty member.
     * @param firstName The first name of the faculty member.
     * @param lastName The last name of the faculty member.
     * @param emailAddress The email address of the faculty member.
     * @param enrolDate The enrolment date of the faculty member.
     * @param lastAccess The last access date of the faculty member.
     * @param enabled The status indicating if the faculty member is enabled or disabled.
     * @param type The type of the user (faculty member).
     * @param schoolCode The school code associated with the faculty member.
     * @param schoolDescription The description of the school where the faculty member works.
     * @param office The office location of the faculty member.
     * @param extension The phone extension number for the faculty member.
     */
    public Faculty
    (
        long id, String password, String firstName, String lastName, String emailAddress, Date enrolDate, Date lastAccess,
        boolean enabled, char type, String schoolCode, String schoolDescription, String office, int extension
    )
    {
        // Call to parent's parameterized constructor
        super(id, password, firstName, lastName, emailAddress, lastAccess, enrolDate, enabled, type);

        setSchoolCode(schoolCode);
        setSchoolDescription(schoolDescription);
        setOffice(office);
        setExtension(extension);
    }

    // NOT NEEDED AS toString() is not really used.
    public static String getTypeForDisplay()
    {
        String Faculty = "Faculty";
        return Faculty;
    }

    /**
     * Returns a string representation of the faculty member's information.
     *
     * @return A formatted string containing the faculty member's details.
     */
    @Override
    public String toString()
    {
        DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

        return String.format
        (
            "Faculty Info for: %d \n" +
                    "\tName: %s %s (%s) \n" +
                    "\tCreated on: %s\n" +
                    "\tLast Access: %s \n" +
                    "\tInstitution: " + COLLEGE_NAME +", %s \n" +
                    "\tOffice: %s \n" +
                    "\tNumber: " + PHONE_NUMBER + " - x" + "%s \n",
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmailAddress(),
            DF.format(user.getEnrolDate()), // Directly passes the Date object
            DF.format(user.getLastAccess()), // Directly passes the Date object
            getSchoolDescription(),
                getOffice(),
                getExtension()
        );
    }
}

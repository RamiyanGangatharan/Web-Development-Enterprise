import java.util.Date;

/**
 * This is the Faculty class.
 * @author Ramiyan Gangatharan
 * @version 1.2 (January 22, 2024)
 * @since 1.0 (January 14, 2024)
 */
public class Faculty extends User
{
    public static final String DEFAULT_SCHOOL_CODE = "SET";
    public static final String DEFAULT_SCHOOL_DESCRIPTION = "School of Engineering & Technology";
    public static final String DEFAULT_OFFICE = "H-140";
    public static final int DEFAULT_PHONE_EXTENSION = 1234;

    private String schoolCode;
    private String schoolDescription;
    private String office;
    private int extension;

    public String getSchoolCode() { return schoolCode;}
    public String getSchoolDescription() {return schoolDescription;}
    public String getOffice() {return office;}
    public int getExtension() {return extension;}

    public void setSchoolCode(String schoolCode) {this.schoolCode = schoolCode;}
    public void setSchoolDescription(String schoolDescription) {this.schoolDescription = schoolDescription;}
    public void setOffice(String office) {this.office = office;}
    public void setExtension(int extension) {this.extension = extension;}

    // Default Constructor
    public Faculty()
    {
        // Call to parent's default constructor
        super();

        setSchoolCode(DEFAULT_SCHOOL_CODE);
        setSchoolDescription(DEFAULT_SCHOOL_DESCRIPTION);
        setOffice(DEFAULT_OFFICE);
        setExtension(DEFAULT_PHONE_EXTENSION);
    }

    // Parameterized Constructor
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

    public static void getTypeForDisplay()
    {

    }
}

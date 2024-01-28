import java.text.DateFormat;
import java.util.Locale;
import java.util.Vector;

/**
 * Represents a student in a college context. This class extends the User class, adding
 * specific properties related to students like program code, year of study, and marks.
 * It provides methods to get and set the student's program information and academic records.
 *
 * @author Ramiyan Gangatharan
 * @version 1.6 (January 28, 2024)
 * @since 1.0 (January 14, 2024)
 */
public class Student extends User
{
    /**
     * The default program code assigned to a student when their program is undeclared.
     */
    public static final String DEFAULT_PROGRAM_CODE = "UNDC";

    /**
     * The default program description for students who have not declared their program.
     */
    public static final String DEFAULT_PROGRAM_DESCRIPTION = "Undeclared";

    /**
     * The default year of study assigned to new students.
     */
    public static final int DEFAULT_YEAR = 1;

    /**
     * The program code of the student's enrolled program.
     */
    private String programCode;

    /**
     * The current year of study of the student.
     */
    private int year;

    /**
     * A Vector containing the student's academic marks.
     */
    private Vector<Mark> marks = new Vector<Mark>();

    /**
     * Retrieves the program code of the student.
     *
     * @return A string representing the program code.
     */
    public String getProgramCode() {return programCode;}

    /**
     * Retrieves the current year of study of the student.
     *
     * @return An integer representing the year of study.
     */
    public int getYear() {return year;}

    /**
     * Retrieves the academic marks of the student.
     *
     * @return A Vector of Mark objects representing the student's academic marks.
     */
    public Vector<Mark> getMarks() {return marks;}

    /**
     * Sets the program code for the student.
     *
     * @param programCode A string representing the program code.
     */
    public void setProgramCode(String programCode) {this.programCode = programCode;}

    /**
     * Sets the current year of study for the student.
     *
     * @param year An integer representing the year of study.
     */
    public void setYear(int year) {this.year = year;}

    /**
     * Sets the academic marks for the student.
     *
     * @param marks A Vector of Mark objects representing the student's academic marks.
     */
    public void setMarks(Vector<Mark> marks) {this.marks = marks;}

    /**
     * Default constructor. Initializes a new student with default values for program code and year of study.
     */
    public Student() throws InvalidNameException, InvalidPasswordException, InvalidIdException {
        super();
        this.programCode = DEFAULT_PROGRAM_CODE;
        this.year = DEFAULT_YEAR;
    }

    /**
     * Parameterized constructor. Initializes a new student with the specified program code, year of study, and marks.
     *
     * @param programCode The program code of the student.
     * @param year The current year of study of the student.
     * @param marks A Vector of Mark objects representing the student's academic marks.
     */
    public Student(String programCode, int year, Vector<Mark> marks) throws InvalidNameException, InvalidPasswordException, InvalidIdException {
        super();
        this.programCode = programCode;
        this.year = year;
        this.marks = marks;
    }

    /**
     * Overloaded constructor. Initializes a new student with the specified program code and year of study, without marks.
     *
     * @param programCode The program code of the student.
     * @param year The current year of study of the student.
     */
    public Student(String programCode, int year) throws InvalidNameException, InvalidPasswordException, InvalidIdException {
        super();
        this.programCode = programCode;
        this.year = year;
    }

    /**
     * Returns a string representation of the student's information, including faculty and user details.
     *
     * @return A formatted string containing the student's details.
     */
    @Override
    public String toString()
    {
        User user = null;
        try {user = new User();}
        catch (InvalidIdException e)
        {throw new RuntimeException(e);}
        catch (InvalidPasswordException e) {throw new RuntimeException(e);}
        catch (InvalidNameException e) {throw new RuntimeException(e);}

        Faculty faculty = null;
        try {faculty = new Faculty();}
        catch (InvalidIdException e) { throw new RuntimeException(e);} catch (InvalidNameException e)
        {throw new RuntimeException(e);}
        catch (InvalidPasswordException e) {throw new RuntimeException(e);}

        Mark mark = null;
        try {
            mark = new Mark
                    (
                            "WEBD2201",
                            "Web Development - Fundamentals",
                            71,
                            4.0f
                    );
        }
        catch (InvalidIdException e) {throw new RuntimeException(e);}
        catch (InvalidNameException e) {throw new RuntimeException(e);}
        catch (InvalidPasswordException e) {throw new RuntimeException(e);}

        DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

        return String.format
        (
                "Faculty Info for: %d \n" +
                        "\tName: %s %s (%s) \n" +
                        "\tCreated on: %s\n" +
                        "\tLast Access: %s \n" +
                        "\tInstitution: " + COLLEGE_NAME +", %s \n" +
                        "\tOffice: %s \n" +
                        "\tNumber: " + PHONE_NUMBER + " - x" + "%s \n" +
                        "\tCourse: %s %s %s " + "-" + " %s\n" +
                        "\tInfo: Currently in %s" + "st" + " year of " + "'" + DEFAULT_PROGRAM_DESCRIPTION +
                        "'" + " (" + DEFAULT_PROGRAM_CODE + ")\n" +
                        "\tEnrolled: (%s) %s",
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmailAddress(),
                DF.format(user.getEnrolDate()),
                DF.format(user.getLastAccess()),
                faculty.getSchoolDescription(),
                faculty.getOffice(),
                faculty.getExtension(),
                mark.getCourseCode(),
                String.format("%-35s", mark.getCourseName()),
                mark.getResult(),
                mark.getGpaWeighting(),
                getYear(),
                getProgramCode(),
                user.getEnrolDate()
        );
    }
}
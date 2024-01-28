import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Represents an academic mark for a student. This class extends the User class and includes
 * properties related to academic courses such as course code, course name, result, and GPA weighting.
 * It provides methods to get and set details of a student's academic record.
 *
 * @author Ramiyan Gangatharan
 * @version 1.6 (January 28, 2024)
 * @since 1.0 (January 14, 2024)
 */
public class Mark extends User
{
    /**
     * The minimum GPA value.
     */
    public static final float MINIMUM_GPA = 0.0f;

    /**
     * The maximum GPA value.
     */
    public static final float MAXIMUM_GPA = 5.0f;

    /**
     * The DecimalFormat for formatting GPA values.
     */
    public static final DecimalFormat GPA = new DecimalFormat("0.00");

    /**
     * The course code associated with the mark.
     */
    private String courseCode;

    /**
     * The name of the course associated with the mark.
     */
    private String courseName;

    /**
     * The numerical result/grade obtained in the course.
     */
    private int result;

    /**
     * The GPA weighting for the course.
     */
    private float gpaWeighting;

    /**
     * Retrieves the course code.
     *
     * @return A string representing the course code.
     */
    public String getCourseCode() {return courseCode;}

    /**
     * Retrieves the course name.
     *
     * @return A string representing the course name.
     */
    public String getCourseName() {return courseName;}

    /**
     * Retrieves the result/grade obtained in the course.
     *
     * @return An integer representing the result.
     */
    public int getResult() {return result;}

    /**
     * Retrieves the GPA weighting for the course.
     *
     * @return A float representing the GPA weighting.
     */
    public float getGpaWeighting() {return gpaWeighting;}

    /**
     * Sets the course code.
     *
     * @param courseCode A string representing the course code.
     */
    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}

    /**
     * Sets the course name.
     *
     * @param courseName A string representing the course name.
     */
    public void setCourseName(String courseName) {this.courseName = courseName;}

    /**
     * Sets the result/grade obtained in the course.
     *
     * @param result An integer representing the result.
     */
    public void setResult(int result) {this.result = result;}

    /**
     * Sets the GPA weighting for the course.
     *
     * @param gpaWeighting A float representing the GPA weighting.
     */
    public void setGpaWeighting(float gpaWeighting) {this.gpaWeighting = gpaWeighting;}

    /**
     * Constructor to create a Mark object with specified course code, course name, result, and GPA weighting.
     *
     * @param courseCode The course code associated with the mark.
     * @param courseName The name of the course associated with the mark.
     * @param result The numerical result/grade obtained in the course.
     * @param gpaWeighting The GPA weighting for the course.
     */
    public Mark(String courseCode, String courseName, int result, float gpaWeighting)
            throws InvalidIdException, InvalidNameException, InvalidPasswordException
    {
        super();
        setCourseCode(courseCode);
        setCourseName(courseName);
        setResult(result);
        setGpaWeighting(gpaWeighting);
    }

    /**
     * Returns a string representation of the Mark object, including user and faculty details.
     *
     * @return A formatted string containing details of the mark, course, and associated faculty and user information.
     */
    @Override
    public String toString()
    {
        User user = null;
        try{user = new User();}
        catch (InvalidIdException | InvalidPasswordException | InvalidNameException e){throw new RuntimeException(e);}
        Faculty faculty = null;
        try {faculty = new Faculty();}
        catch (InvalidIdException e) {throw new RuntimeException(e);}
        catch (InvalidNameException e) { throw new RuntimeException(e);}
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
                                "\tCourse: %s %s %s " + "-" + " %s",
                        user.getId(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getEmailAddress(),
                        DF.format(user.getEnrolDate()), // Directly passes the Date object
                        DF.format(user.getLastAccess()), // Directly passes the Date object
                        faculty.getSchoolDescription(),
                        faculty.getOffice(),
                        faculty.getExtension(),
                        getCourseCode(),
                        String.format("%-35s", getCourseName()),
                        getResult(),
                        getGpaWeighting()
                );
    }
}

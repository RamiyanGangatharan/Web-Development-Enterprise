import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Locale;

/**
 * This is the Faculty class.
 * @author Ramiyan Gangatharan
 * @version 1.4 (January 23, 2024)
 * @since 1.0 (January 14, 2024)
 */

public class Mark extends User
{
    public static final float MINIMUM_GPA = 0.0f;
    public static final float MAXIMUM_GPA = 5.0f;
    public static final DecimalFormat GPA = new DecimalFormat("0.00");

    private String courseCode;
    private String courseName;
    private int result;
    private float gpaWeighting;

    public String getCourseCode() {return courseCode;}
    public String getCourseName() {return courseName;}
    public int getResult() {return result;}
    public float getGpaWeighting() {return gpaWeighting;}

    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
    public void setCourseName(String courseName) {this.courseName = courseName;}
    public void setResult(int result) {this.result = result;}
    public void setGpaWeighting(float gpaWeighting) {this.gpaWeighting = gpaWeighting;}

    public Mark(String courseCode, String courseName, int result, float gpaWeighting)
    {
        setCourseCode(courseCode);
        setCourseName(courseName);
        setResult(result);
        setGpaWeighting(gpaWeighting);
    }

    @Override
    public String toString()
    {
        User user = new User();
        Faculty faculty = new Faculty();
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

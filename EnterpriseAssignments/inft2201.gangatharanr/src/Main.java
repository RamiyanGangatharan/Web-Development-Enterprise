/**
 * This is the main class for a college management system. It serves as the entry point of the application.
 * In this class, instances of User, Faculty, Mark, and Student classes are created and their details are
 * displayed. The main method of this class demonstrates the creation and usage of these instances, primarily
 * focusing on showcasing their functionalities such as displaying user information.
 *
 * The primary purpose of this class is to illustrate how different classes within the college management system
 * interact and how their respective information can be displayed. It creates and utilizes objects from different
 * classes to demonstrate their functionality and interactions.
 *
 * @author Ramiyan Gangatharan
 * @version 1.5 (January 24, 2024)
 * @since 1.0 (January 14, 2024)
 */

public class Main
{
    /**
     * The main method that serves as the entry point for the application. It creates instances of the User,
     * Faculty, Mark, and Student classes and calls their toString methods to display information about each object.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) throws InvalidIdException, InvalidNameException, InvalidPasswordException
    {
        User user = new User();
        Faculty faculty = new Faculty();
        Mark mark = new Mark
                (
                    "WEBD2201",
                    "Web Development - Fundamentals",
                    71,
                    4.0f
                );

        Student student = new Student();
        System.out.println(user);
        System.out.println();
        System.out.println(faculty);
        System.out.println();
        System.out.println(mark);
        System.out.println();
        System.out.println(student);
    }
}
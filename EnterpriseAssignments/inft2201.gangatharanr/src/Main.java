/**
 * This is the main class where everything will be executed. It creates an instance
 * of the User class and calls its dump method to display the user's information.
 *
 * @author Ramiyan Gangatharan
 * @version 1.4 (January 23, 2024)
 * @since 1.0 (January 14, 2024)
 */

public class Main
{
    /**
     * The entry point of the application.
     *
     * This is the main method which serves as the starting point of the program.
     * It creates a new User object and invokes its dump method to print the user's
     * information to the standard output.
     *
     * @param args command-line arguments passed to the program. Not used in this application.
     */
    public static void main(String[] args)
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

        System.out.println(user);
        System.out.println();
        System.out.println(faculty);
        System.out.println();
        System.out.println(mark);
        System.out.println();
    }
}
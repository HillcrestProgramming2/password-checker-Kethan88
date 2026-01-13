import java.util.Scanner;

/**
 * Main application for the Password Strength Checker.
 */
public class PasswordCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to check: ");
        String password = scanner.nextLine();

        int score = CriteriaChecker.evaluateCriteria(password);
        String strength = CriteriaChecker.determineStrength(score);

        System.out.println("\nPassword Strength: " + strength + " (" + score + "/5)");

        if (score < 5) {
            System.out.println("Suggestions to improve your password:");
            System.out.print(FeedbackGenerator.generateFeedback(password));
        }

        scanner.close();
    }
}

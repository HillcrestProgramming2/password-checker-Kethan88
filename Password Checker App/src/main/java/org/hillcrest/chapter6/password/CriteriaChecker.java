/**
 * Utility class to evaluate password strength based on specific criteria.
 */
public class CriteriaChecker {

    /**
     * Evaluates password against 5 criteria using loops.
     * @param password The string to evaluate.
     * @return Score from 0 to 5.
     */
    public static int evaluateCriteria(String password) {
        int score = 0;
        if (password == null) return 0;

        // 1. Length Check
        if (password.length() >= 8) score++;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()-+=";

        // Loop through string to check characters
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.indexOf(c) != -1) hasSpecial = true;
        }

        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;

        return score;
    }

    /**
     * Determines the strength label based on score.
     * @param score 0-5
     * @return Weak, Moderate, or Strong.
     */
    public static String determineStrength(int score) {
        if (score <= 2) return "Weak";
        if (score == 3) return "Moderate";
        return "Strong";
    }
}

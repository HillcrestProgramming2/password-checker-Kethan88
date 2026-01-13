/**
 * Utility class to generate suggestions for password improvement.
 */
public class FeedbackGenerator {

    /**
     * Checks for missing criteria and builds a multi-line suggestion string.
     * @param password The password to check.
     * @return A formatted string of suggestions.
     */
    public static String generateFeedback(String password) {
        StringBuilder feedback = new StringBuilder();
        String specialChars = "!@#$%^&*()-+=";

        if (password.length() < 8) {
            feedback.append("- Increase the length to at least 8 characters.\n");
        }

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (specialChars.indexOf(c) != -1) hasSpecial = true;
        }

        if (!hasUpper) feedback.append("- Add at least one uppercase letter.\n");
        if (!hasLower) feedback.append("- Add at least one lowercase letter.\n");
        if (!hasDigit) feedback.append("- Add at least one number.\n");
        if (!hasSpecial) feedback.append("- Include at least one special character.\n");

        return feedback.toString();
    }
}

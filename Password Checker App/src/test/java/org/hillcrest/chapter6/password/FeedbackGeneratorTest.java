import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the suggestion strings generated for weak or moderate passwords.
 */
public class FeedbackGeneratorTest {

    @Test
    void testGenerateFeedback_MissingAll() {
        String feedback = FeedbackGenerator.generateFeedback("a");

        // Check for specific suggestion keywords
        assertTrue(feedback.contains("length"), "Should suggest increasing length");
        assertTrue(feedback.contains("uppercase"), "Should suggest adding uppercase");
        assertTrue(feedback.contains("number"), "Should suggest adding a number");
        assertTrue(feedback.contains("special character"), "Should suggest a special char");
    }

    @Test
    void testGenerateFeedback_MissingOnlySpecial() {
        // Valid length, upper, lower, and digit. Missing special.
        String feedback = FeedbackGenerator.generateFeedback("Password123");

        assertFalse(feedback.contains("length"));
        assertFalse(feedback.contains("uppercase"));
        assertTrue(feedback.contains("special character"));
    }

    @Test
    void testGenerateFeedback_StrongPassword() {
        // A strong password should result in an empty string (no improvements needed)
        String feedback = FeedbackGenerator.generateFeedback("Ab1!5678");
        assertEquals("", feedback.trim(), "Feedback should be empty for a 5/5 password");
    }
}
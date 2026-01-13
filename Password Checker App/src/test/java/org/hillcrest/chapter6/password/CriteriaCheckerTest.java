import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the logic for scoring and labeling password strength.
 */
public class CriteriaCheckerTest {

    @Test
    void testEvaluateCriteria_AllPoints() {
        // Meets all 5: Length, Upper, Lower, Digit, Special
        assertEquals(5, CriteriaChecker.evaluateCriteria("P@ssw0rd2026"));
    }

    @Test
    void testEvaluateCriteria_PartialPoints() {
        // Meets 3: Length, Lower, Digit (No Upper, No Special)
        assertEquals(3, CriteriaChecker.evaluateCriteria("password123"));

        // Meets 1: Only Lower
        assertEquals(1, CriteriaChecker.evaluateCriteria("abc"));
    }

    @Test
    void testEvaluateCriteria_NullAndEmpty() {
        assertEquals(0, CriteriaChecker.evaluateCriteria(null));
        assertEquals(0, CriteriaChecker.evaluateCriteria(""));
    }

    @Test
    void testDetermineStrength_Thresholds() {
        // Weak: 0-2
        assertEquals("Weak", CriteriaChecker.determineStrength(0));
        assertEquals("Weak", CriteriaChecker.determineStrength(2));

        // Moderate: 3
        assertEquals("Moderate", CriteriaChecker.determineStrength(3));

        // Strong: 4-5
        assertEquals("Strong", CriteriaChecker.determineStrength(4));
        assertEquals("Strong", CriteriaChecker.determineStrength(5));
    }
}
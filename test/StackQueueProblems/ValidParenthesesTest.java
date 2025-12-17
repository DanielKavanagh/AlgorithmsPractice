package StackQueueProblems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {
    ValidParentheses cut = new ValidParentheses();

    @Test
    public void testValidSimple() {
        assertTrue(cut.isValid("{([])}"));
    }

    @Test
    public void testValidComplex() {
        assertTrue(cut.isValid("({}{{{{(())}}}}[[[{}]]])"));
    }

    @Test
    public void testInvalid() {
        assertFalse(cut.isValid("{]"));
    }

    @Test
    public void testInvalidHanging() {
        assertFalse(cut.isValid("{}[{}]("));
    }

    @Test
    public void testInvalidEmptyStack() {
        assertFalse(cut.isValid("}"));
    }
}
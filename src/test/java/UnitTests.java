import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UnitTests {

//~ Constructor ........................................................

    @Test
    /**
     * Tests that valid strings are accepted and invalid strings are rejected.
     * stringAcceptor not yet implemented on main branch
     */
     
    public void acceptorTest() {
        assertFalse(myCalculator.stringAcceptor(null));
        assertFalse(myCalculator.stringAcceptor(""));
        assertFalse(myCalculator.stringAcceptor("hello"));
        assertFalse(myCalculator.stringAcceptor("x+y"));
        assertFalse(myCalculator.stringAcceptor("3x+2y-5"));
        assertFalse(myCalculator.stringAcceptor("hello"));
        assertFalse(myCalculator.stringAcceptor("+30"));
        assertFalse(myCalculator.stringAcceptor("*30"));
        assertTrue(myCalculator.stringAcceptor("-30"));
        assertTrue(myCalculator.stringAcceptor("-30+55"));
        assertTrue(myCalculator.stringAcceptor("-30+55*26+54"));
        assertFalse(myCalculator.stringAcceptor("-30+55-*26+54"));
        assertTrue(myCalculator.stringAcceptor("-30+55*-26+54"));
        assertFalse(myCalculator.stringAcceptor("-30+55*26+54-"));
    }

    @Test
    /**
     * Tests that the evaluate method will return the correct result when adding numbers
     */
    public void additionTest() {
        assertEquals(0, myCalculator.evaluate("0"));
        assertEquals(5, myCalculator.evaluate("2+3"));
        assertEquals(18, myCalculator.evaluate("9+9"));
        assertEquals(27, myCalculator.evaluate("9+9+9"));
        assertEquals(107, myCalculator.evaluate("100+7"));
        assertEquals(77, myCalculator.evaluate("7+70"));
        assertEquals(82, myCalculator.evaluate("7+70+5"));
        assertEquals(162, myCalculator.evaluate("110+50+2"));
    }

    @Test
    /**
     * Tests that the evaluate method will return the correct result when subtracting numbers
     */
    public void subtractionTest() {
        assertEquals(4, myCalculator.evaluate("9-5"));
        assertEquals(20, myCalculator.evaluate("30-10"));
        assertEquals(23, myCalculator.evaluate("30-7"));
        assertEquals(39, myCalculator.evaluate("100-61"));
    }

    @Test
    /**
     * Tests that the evaluate method will return the correct result when multiplying numbers
     */
    public void multiplicationTest() {
        assertEquals(0, myCalculator.evaluate("1*0"));
        assertEquals(0, myCalculator.evaluate("0*1"));
        assertEquals(1, myCalculator.evaluate("1*1"));
        assertEquals(9, myCalculator.evaluate("3*3"));
        assertEquals(81, myCalculator.evaluate("9*9"));
        assertEquals(39, myCalculator.evaluate("3*13"));
        assertEquals(39, myCalculator.evaluate("13*3"));
        assertEquals(605, myCalculator.evaluate("121*5"));
    }

    @Test
    /**
     * Tests that the evaluate method will return the correct result for equations featuring negative numbers
     * Failure on main branch (bugged)
     */
    public void negativeNumbersTest() {
        assertEquals(-5, myCalculator.evaluate("-5"));
        assertEquals(40, myCalculator.evaluate("50+-10"));
        assertEquals(-27, myCalculator.evaluate("-30+3"));
        assertEquals(12, myCalculator.evaluate("6--6"));
        assertEquals(0, myCalculator.evaluate("-6--6"));
        assertEquals(-35, myCalculator.evaluate("5*-7"));
    }

    @Test
    /**
     * Tests that the calculator will give the correct results for equations with order of operations
     * Failure on main branch (oop not yet implemented)
     */
    public void oopTest() {
        assertEquals(15, myCalculator.evaluate("5+5+5"));
        assertEquals(19, myCalculator.evaluate("10+4*2+1"));
        assertEquals(-50, myCalculator.evaluate("5-5--5*10"));
        assertEquals(67, myCalculator.evaluate("85-9*2"));
        assertEquals(30, myCalculator.evaluate("3*3*3+3"));
        assertEquals(72, myCalculator.evaluate("-24--24--24--24"));
        assertEquals(72, myCalculator.evaluate("-24--24*3"));
    }

}


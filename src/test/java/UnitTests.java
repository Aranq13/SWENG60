import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UnitTests {

//~ Constructor ........................................................

    
    /**
     * Tests that valid strings are accepted and invalid strings are rejected.
     * stringAcceptor not yet implemented on main branch
     
    public void acceptorTest() {
        myCalculator calculator = new myCalculator();

        assertFalse(calculator.stringAcceptor(null));
        assertFalse(calculator.stringAcceptor(""));
        assertFalse(calculator.stringAcceptor("hello"));
        assertFalse(calculator.stringAcceptor("x+y"));
        assertFalse(calculator.stringAcceptor("3x+2y-5"));
        assertFalse(calculator.stringAcceptor("hello"));
        assertFalse(calculator.stringAcceptor("+30"));
        assertFalse(calculator.stringAcceptor("*30"));
        assertTrue(calculator.stringAcceptor("-30"));
        assertTrue(calculator.stringAcceptor("-30+55"));
        assertTrue(calculator.stringAcceptor("-30+55*26+54"));
        assertFalse(calculator.stringAcceptor("-30+55-*26+54"));
        assertTrue(calculator.stringAcceptor("-30+55*-26+54"));
        assertFalse(calculator.stringAcceptor("-30+55*26+54-"));
    }
    */
    
    @Test
    /**
     * Tests that the evaluate method will return the correct result for equations with a single operator
     * Subtraction not working on main branch
     */
    public void singleTest() {
        myCalculator calculator = new myCalculator();

        assertEquals(0, calculator.evaluate("0"));
        assertEquals(55, calculator.evaluate("5+50"));
        //assertEquals(23, calculator.evaluate("30-7"));
        assertEquals(39, calculator.evaluate("13*3"));
    }

    
    /**
     * Tests that the evaluate method will return the correct result for equations featuring negative numbers
     * Failure on main branch (bugged)
     */
    public void negativeNumbersTest() {
        myCalculator calculator = new myCalculator();

        assertEquals(-5, calculator.evaluate("-5"));
        assertEquals(40, calculator.evaluate("50+-10"));
        assertEquals(-27, calculator.evaluate("-30+3"));
        assertEquals(12, calculator.evaluate("6--6"));
        assertEquals(0, calculator.evaluate("-6--6"));
        assertEquals(-35, calculator.evaluate("5*-7"));
    }

    
    /**
     * Tests that the calculator will give the correct results for equations with order of operations
     * Failure on main branch (oop not yet implemented)
     */
    public void oopTest() {
        myCalculator calculator = new myCalculator();

        assertEquals(15, calculator.evaluate("5+5+5"));
        assertEquals(19, calculator.evaluate("10+4*2+1"));
        assertEquals(-50, calculator.evaluate("5-5--5*10"));
        assertEquals(67, calculator.evaluate("85-9*2"));
        assertEquals(30, calculator.evaluate("3*3*3+3"));
        assertEquals(72, calculator.evaluate("-24--24--24--24"));
        assertEquals(72, calculator.evaluate("-24--24*3"));
    }

}


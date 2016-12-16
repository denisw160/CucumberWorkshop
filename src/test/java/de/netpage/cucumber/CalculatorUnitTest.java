package de.netpage.cucumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Default Unit-Test for {@link Calculator}.
 */
public class CalculatorUnitTest {

    /**
     * Instance of the calculator.
     */
    private Calculator calculator;

    /**
     * Setup the calculator for the test.
     *
     * @throws Exception during setup
     */
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
        assertNotNull(calculator);
    }

    /**
     * Test the add function. Use all possible value ranges.
     *
     * @throws Exception during execution
     */
    @Test
    public void add() throws Exception {
        // both values positive
        calculator.add(2.0, 3.0);
        assertEquals(5.0, calculator.getResult(), 0.0);

        // one value is null
        calculator.add(2.0, 0.0);
        assertEquals(2.0, calculator.getResult(), 0.0);
        calculator.add(0.0, 3.0);
        assertEquals(3.0, calculator.getResult(), 0.0);

        // both values are null
        calculator.add(0.0, 0.0);
        assertEquals(0.0, calculator.getResult(), 0.0);

        // one value is negative
        calculator.add(2.0, -3.0);
        assertEquals(-1.0, calculator.getResult(), 0.0);
        calculator.add(-2.0, 3.0);
        assertEquals(1.0, calculator.getResult(), 0.0);

        // both values negative
        calculator.add(-2.0, -3.0);
        assertEquals(-5.0, calculator.getResult(), 0.0);
    }

    /**
     * Test the last result of the calculation.
     *
     * @throws Exception during execution
     */
    @Test
    public void getResult() throws Exception {
        assertEquals(0.0, calculator.getResult(), 0.0);
    }

}
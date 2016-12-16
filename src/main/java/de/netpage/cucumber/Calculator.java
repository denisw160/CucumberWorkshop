package de.netpage.cucumber;

/**
 * The calculator.
 */
public class Calculator {

    /**
     * This is the internal memory of the calculator.
     */
    private double result;

    /**
     * The constructor initialize the calculator.
     * The memory will be set to 0.0.
     */
    public Calculator() {
        result = 0.0;
    }

    /**
     * Adds the two values and stores them into the memory (result).
     *
     * @param arg1 Value 1
     * @param arg2 Value 2
     */
    public void add(final double arg1, final double arg2) {
        result = arg1 + arg2;
    }

    /**
     * Return the result from memory.
     *
     * @return the result of the calcution
     */
    public double getResult() {
        return result;
    }

}

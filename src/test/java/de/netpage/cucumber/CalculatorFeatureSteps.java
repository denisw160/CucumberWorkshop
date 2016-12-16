package de.netpage.cucumber;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class provides the test steps for the features of the calculator.
 */
public class CalculatorFeatureSteps {

    /**
     * The calculator for the test.
     */
    private Calculator calculator;

    /**
     * Prepares the calculator for the test.
     */
    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    // --- This are the steps to test the calculator feature ---

    @Given("^I have a calculator$")
    public void i_have_a_calculator() throws Throwable {
        assertNotNull(calculator);
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void i_add_and(final int arg1, final int arg2) throws Throwable {
        calculator.add(arg1, arg2);
    }

    @When("^I will add two number (.+) and (.*)$")
    public void i_add_double_and_double(final String arg1, final String arg2) throws Throwable {
        final double in1 = Double.parseDouble(arg1);
        final double in2 = Double.parseDouble(arg2);
        calculator.add(in1, in2);
    }

    @Then("^the result should be (\\d+)$")
    public void the_result_should_be(final int result) throws Throwable {
        assertEquals(result, calculator.getResult(), 0.0);
    }

    @Then("^the result should be number (.+)$")
    public void the_result_should_be_double(final String result) throws Throwable {
        assertEquals(Double.parseDouble(result), calculator.getResult(), 0.0);
    }


}

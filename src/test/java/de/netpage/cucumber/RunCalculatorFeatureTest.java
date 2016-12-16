package de.netpage.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This Unit-Tests runs the Cucumber Feature Tests for the Calculator.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        glue = "de.netpage.cucumber",
        features = "classpath:cucumber/calculator.feature"
)
public class RunCalculatorFeatureTest {
}

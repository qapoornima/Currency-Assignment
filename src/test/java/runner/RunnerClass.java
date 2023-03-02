package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/feature"},
		tags = "@Assignment",
		glue={"stepDefinition"},
		plugin= {"pretty","html:target/cucumber-html-report/index.html"}
		)
public class RunnerClass {

}


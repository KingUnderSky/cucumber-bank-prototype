import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin ="pretty",
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = true,
		strict = true
		)

public class Runner {
	
}

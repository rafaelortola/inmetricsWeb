package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        /*plugin = { "pretty", "html:src/test/resources/relatorios",
        "json:src/test/resources/relatorios/cucumber.json",
        "junit:src/test/resources/relatorios/cucumber.xml" },*/
        features = "src/test/resources/features/",
        tags = {"@CadastrarFuncionario"},
        monochrome = true,
        glue = { "steps" },
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false)

public class RunnerTests {
}

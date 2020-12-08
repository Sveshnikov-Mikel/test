import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",

    glue = {"src/main/java/ru/mail/test", "src/test/java"},
    tags = "@all"
)
public class RunnerTest{
}

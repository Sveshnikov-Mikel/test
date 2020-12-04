import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase{
    WebDriver driver;
    @Before
public void setUp() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\msveshnikov\\Downloads\\addressbook-web-tests\\test\\src\\main\\resources\\chromedriver.exe");
driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://mail.ru/");}


@After
public void tearDown() {
    driver.quit();
}
}
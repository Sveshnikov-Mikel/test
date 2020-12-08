import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver driver;

  public void setUp() {

    System.setProperty("webdriver.chrome.driver", "C:\\Users\\msveshnikov\\Downloads\\addressbook-web-tests\\test\\src\\main\\resources\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://mail.ru/");

  }


  public void tearDown() {
    driver.quit();
  }
}
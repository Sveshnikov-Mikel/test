package ru.yandex;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

public class GroupDeletionMail {
  private WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Михаил\\IdeaProjects\\test\\src\\test\\java\\ru\\yandex\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("https://mail.yandex.ru/");
    login("testtestovich.93", "5482590");
  }

  private void login(String username, String password) {

    driver.findElement(By.xpath("//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")).click();
    driver.findElement(By.id("passp-field-login")).sendKeys(username);
    driver.findElement(By.id("passp-field-login")).sendKeys(Keys.ENTER);
    driver.findElement(By.id("passp-field-passwd")).sendKeys(password);
    driver.findElement(By.id("passp-field-passwd")).sendKeys(Keys.ENTER);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testGroupDeletion() {
    login("testtestovich.93", "5482590");
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //driver.findElement(By.xpath("//a[@title='Написать (w, c)']")).click();
    driver.findElement(By.xpath("//*[@id=\"nb-1\"]/body/div[2]/div[6]/div/div[3]/div[2]/div[2]/div/div/a")).click();
    //driver.findElement(By.xpath("//*[@id="nb-1"]/body/div[2]/div[6]/div/div[3]/div[2]/div[2]/div/div/a")).click();
    driver.findElement(By.xpath("//div[@class='compose-LabelRow'][contains(*, 'Кому')]//div[@class='MultipleAddressesDesktop-Field ComposeYabblesField']/div")).sendKeys("testtestovich.93@mail.ru");
    driver.findElement(By.xpath("//div[@class='compose-LabelRow'][contains(*, 'Кому')]//div[@class='MultipleAddressesDesktop-Field ComposeYabblesField']/div")).sendKeys(Keys.TAB);
    driver.findElement(By.xpath("//div[@class='compose-LabelRow-Content ComposeSubject-Content']/input")).sendKeys("Приветствие");
    driver.findElement(By.xpath("//div/div[@id='cke_1_contents']/div")).click();
    driver.findElement(By.xpath("//div/div[@id='cke_1_contents']/div")).sendKeys("Привет");
    driver.findElement(By.xpath("//div/button[@class='control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']")).click();
  }
}


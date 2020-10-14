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

public class GroupCreationMail {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
        login("testtestovich.93", "q5482590");
    }

    private void login(String username, String password) {
        driver.findElement(By.id("mailbox:login-input")).click();
        driver.findElement(By.id("mailbox:login-input")).sendKeys(username, Keys.ENTER);
        driver.findElement(By.id("mailbox:password-input")).sendKeys(password, Keys.ENTER);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGroupMail(){
        gotoSandEmail();
        gotoIncomingEmail();
        gotoSpam();
        gotoBasket();
    }

    private void gotoSandEmail() {
        driver.findElement(By.xpath("//div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div/a")).click();
        driver.findElement(By.xpath("//html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input")).sendKeys("testtestovich.93@yandex.ru", Keys.ENTER, Keys.TAB);
        driver.findElement(By.xpath("//html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")).sendKeys("Приветствие");
        driver.findElement(By.xpath("//html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]")).click();
        driver.findElement(By.xpath("//html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]")).sendKeys("Приветствие");
        driver.findElement(By.xpath("//html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span/span")).click();
        driver.findElement(By.xpath("//html/body/div[17]/div/div/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//html/body/div[9]/div/div/div[2]/div[2]/div/div/div[1]")).click();
    }

    private void gotoBasket() {
        driver.findElement(By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/nav/a[8]/div/div[1]")).click();
    }

    private void gotoSpam() {
        driver.findElement(By.xpath("//*[@id=\"app-canvas\"]/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[2]/div/div[1]/nav/a[7]/div/div[1]")).click();
    }

    private void gotoIncomingEmail() {
        driver.findElement(By.xpath("//a[@class='nav__item js-shortcut nav__item_active nav__item_shortcut nav__item_child-level_0']/div/div[@class='nav__folder-ico']")).click();
    }
}





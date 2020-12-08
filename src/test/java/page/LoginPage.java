package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.log4j.Logger;


public class LoginPage {
  WebDriver driver;
  final static Logger logger = Logger.getLogger(String.valueOf(LoginPage.class));

  public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }


  @FindBy(xpath = "//input[@name='login']")
  public WebElement clickLogin;

  @FindBy(xpath = "//input[@name='login']")
  public WebElement inputlogin;

  @FindBy(xpath = "//input[@name='password']")
  public WebElement passwd;

  @FindBy(xpath = "//button[contains(text(), 'Войти')]")
  public WebElement loginBtn;

  public void clickLogin() {
    clickLogin.click();
  }

  public void inputLogin(String login) {
    inputlogin.sendKeys(login, Keys.ENTER);
    logger.info("Ввод логина");
  }

  public void inputPassword(String password) {
    passwd.sendKeys(password);
    logger.info("Ввод пароля");
  }

  public void clickLoginBtn() {
    loginBtn.click();
    logger.info("Вход в систему");
  }
}
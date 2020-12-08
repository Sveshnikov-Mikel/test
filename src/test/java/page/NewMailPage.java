package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.apache.log4j.Logger;

public class NewMailPage {
  final static Logger log = Logger.getLogger(String.valueOf(MailPage.class));
  WebDriver driver;

  public NewMailPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  @FindBy(xpath = "//div[@class='input--3slxg']")
  public WebElement clickEmail;

  @FindBy(xpath = "//label[@class='container--zU301']")
  public WebElement adressEmail;

  @FindBy(xpath = "//div[@class='subject__container--HWnat']//input[@class='container--H9L5q size_s_compressed--2c-eV']")
  public WebElement themeEmail;

  @FindBy(xpath = "//div[@class='container--2Rl8H']/div/div[2]/div/div")
  public WebElement textEmail;

  @FindBy(xpath = "//span[text()='Сохранить']")
  public WebElement saveDraft;

  @FindBy(xpath = "//span[text()='Отправить']")
  public WebElement sandEmail;

  @FindBy(xpath = "//button[@title='Закрыть']")
  public WebElement closeMailWindow;

  @FindBy(xpath = "//span[@title='Закрыть']")
  public WebElement closeWindowSandEmail;

  public void clickEmail() {
    clickEmail.click();
  }

  public void adressEmail(String email) {
    adressEmail.sendKeys(email, Keys.TAB);
  }

  public void themeEmail(String theme) {
    themeEmail.sendKeys(theme);
  }

  public void textMail(String textMail) {
    textEmail.sendKeys(textMail);
  }

  public void saveDraft() {
    saveDraft.click();
  }

  public void sandEmail() {
    sandEmail.click();
  }

  public void closeWindowSandEmail() {
    closeWindowSandEmail.click();
    log.info("Закрыто окно после отправки письма");
  }

  public void closeDraftWindow() {
    closeMailWindow.click();
    log.info("Закрыто окно после сохранения черновика");
  }
}
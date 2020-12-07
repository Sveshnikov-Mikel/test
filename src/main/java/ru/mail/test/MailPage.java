package ru.mail.test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.log4j.Logger;

public class MailPage {
private static final Logger log = Logger.getLogger(String.valueOf(MailPage.class));
public static DataClass dataClass;
WebDriver driver;
public MailPage(WebDriver driver) {
 PageFactory.initElements(driver, this);
 this.driver = driver;
}
@FindBy(xpath = "//a[@title='Написать письмо']")
public WebElement createPage;

 @FindBy(xpath = "//a[@class='nav__item js-shortcut nav__item_shortcut nav__item_expanded_true nav__item_child-level_0'][2]")
public WebElement checkDraftFolder;

 @FindBy(xpath = "//a[@class='llc js-tooltip-direction_letter-bottom js-letter-list-item llc_pony-mode llc_normal'][1]")
public WebElement checkLastDraft;

 @FindBy(xpath = "//button[@title='Закрыть']")
public WebElement closeDraftWindow;

 @FindBy(id = "PH_logoutLink")
public WebElement logOut;

 @FindBy(xpath = "//a[@class='nav__item js-shortcut nav__item_shortcut nav__item_expanded_true nav__item_child-level_0'][1]")
public WebElement goToSandingMail;

 @FindBy(xpath = "//a[@class='llc js-tooltip-direction_letter-bottom js-letter-list-item llc_pony-mode llc_normal'][1]")
public WebElement checkLastSandingMail;

 public void createPage() {
// new WebDriverWait(driver, 60)
//     .until(ExpectedConditions.elementToBeClickable(createPage));
  try {
   Thread.sleep(100);
  } catch (InterruptedException e) {
   e.printStackTrace();
  }
  createPage.click();
}
public void checkDraftFolder(){
 checkDraftFolder.click();
}
public void checkLastDraft(){
// new WebDriverWait(driver, 60)
//         .until(ExpectedConditions.elementToBeClickable(checkLastDraft));
// checkLastDraft.click();
 try {
  Thread.sleep(100);
 } catch (InterruptedException e) {
  e.printStackTrace();
 }
 checkLastDraft.click();
}
public void closeDraftWindow() {
 closeDraftWindow.click();
}
public void logOut() {
 logOut.click();
  if (logOut == null){
   driver.findElement(By.xpath("//div[@class='ph-auth svelte-dphxt3']")).click();
   driver.findElement(By.xpath("//div[@class='ph-item ph-item__hover-active svelte-jet8df']")).click();
  }

  log.info("Выполнен выход из системы");
}

public void goToSandingMail(){
 goToSandingMail.click();
}
public void checkLastSandingMail(){
// new WebDriverWait(driver, 60)
//         .until(ExpectedConditions.elementToBeClickable(checkLastSandingMail));
 try {
  Thread.sleep(200);
 } catch (InterruptedException e) {
  e.printStackTrace();
 }
 checkLastSandingMail.click();
}
public void assertMethodTest1(){
 dataClass = new DataClass();
 Assert.assertEquals(driver.findElement(By.xpath("//div[contains(div,'Кому')][@data-name='to']//div[@data-type='to']/div/div/div/div")).getText(), dataClass.checkEmail);
 Assert.assertEquals(driver.findElement(By.xpath("//input[@name='Subject']")).getAttribute("value"), dataClass.checkTheme);
 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='container--2Rl8H']/div/div[2]/div/div/div/div/div/div[1]")).getText(), dataClass.checkTextMail);
 log.info("Проверка прошла успешно");}


public void assertMethodTest2(){
 dataClass = new DataClass();
 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='letter__recipients letter__recipients_short']/span[@class='letter-contact']")).getText(), dataClass.checkEmail);
 Assert.assertEquals(driver.findElement(By.xpath("//h2[@class='thread__subject thread__subject_pony-mode']")).getText(), dataClass.checkTheme);
 Assert.assertEquals(driver.findElement(By.xpath("//div[@class='js-helper js-readmsg-msg']/div/div/div/div[1]")).getText(), dataClass.checkTextMail);
 log.info("Проверка прошла успешно");
}
}

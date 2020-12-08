import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import page.DataClass;
import page.LoginPage;
import page.MailPage;
import page.NewMailPage;

public class BasicPageDef extends TestBase{

 public static LoginPage loginPage;
 public static DataClass dataClass;
 public static MailPage mailPage;
 public static NewMailPage newMailPage;

  @Before
  public void initialization(){
    setUp();
    loginPage = new LoginPage(driver);
    dataClass = new DataClass();
    mailPage = new MailPage(driver);
    newMailPage = new NewMailPage(driver);
  }

  @Когда("выполянем клик по полю ввода логина")
  public void выполянемКликПоПолюВводаЛогина() {
    loginPage.clickLogin();
  }

  @И("вводим логин")
  public void вводимЛогин() {
    loginPage.inputLogin(dataClass.login);
  }

  @Также("вводим пароль для входа в систему")
  public void вводимПарольДляВходаВСистему() {
    loginPage.inputPassword(dataClass.password);
  }

  @Тогда("выполняем вход в систему")
  public void выполняемВходВСистему() {
    loginPage.clickLoginBtn();


  }



  @Тогда("нажимаем на поле Создать письмо")
  public void нажимаемНаПолеСоздатьПисьмо() {
    mailPage.createPage();
  }

  @И("вводим адресата, тему письма и его текст, сохраняем как черновик, закрываем окно создания письма")
  public void вводимАдресатаТемуПисьмаИЕгоТекстСохраняемКакЧерновикЗакрываемОкноСозданияПисьма() {
    newMailPage.clickEmail();
    newMailPage.adressEmail(dataClass.email);
    newMailPage.themeEmail(dataClass.theme);
    newMailPage.textMail(dataClass.textMail);
    newMailPage.saveDraft();
    newMailPage.closeDraftWindow();
  }

  @Тогда("заходим в папку черновиков, открываем последний созданный")
  public void заходимВПапкуЧерновиковОткрываемПоследнийСозданный() {
    mailPage.checkDraftFolder();
    mailPage.checkLastDraft();
  }

  @И("выполняем проверку по полям адресата, темы письма и тектса, закрваем окно черновика")
  public void выполняемПроверкуПоПолямАдресатаТемыПисьмаИТектсаЗакрываемОкноЧерновика() {
    mailPage.assertMethodTest1();
    mailPage.closeDraftWindow();
  }

  @Тогда("выходим из почтового сервиса")
  public void выходимИзПочтовогоСервиса() {
    mailPage.logOut();
  }

  @И("вводим адресата, тему письма и его текст, отправляем письмо, закрываем окно создания письма")
  public void вводимАдресатаТемуПисьмаИЕгоТекстОтправляемПисьмоЗакрываемОкноСозданияПисьма() {
    newMailPage.clickEmail();
    newMailPage.adressEmail(dataClass.email);
    newMailPage.themeEmail(dataClass.theme);
    newMailPage.textMail(dataClass.textMail);
    newMailPage.sandEmail();
    newMailPage.closeWindowSandEmail();
  }

  @Тогда("заходим в папку отправленных писем, открываем последнее отправленное")
  public void заходимВПапкуОтправленныхПисемОткрываемПоследнееОтправленное() {
    mailPage.goToSandingMail();
    mailPage.checkLastSandingMail();
  }

  @И("выполняем проверку по полям адресата, темы письма и тектса, закрваем окно отправленного письма")
  public void выполняемПроверкуПоПолямАдресатаТемыПисьмаИТектсаЗакрваемОкноОтправленногоПисьма() {
    mailPage.assertMethodTest2();
  }
  @After
  public void teardown(){
    tearDown();
  }
}


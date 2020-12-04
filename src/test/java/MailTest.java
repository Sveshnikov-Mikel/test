import org.junit.Test;
import ru.mail.test.DataClass;
import ru.mail.test.LoginPage;
import ru.mail.test.MailPage;
import ru.mail.test.NewMailPage;


public class MailTest extends TestBase{

public static LoginPage loginPage;
public static MailPage mailPage;
public static NewMailPage newMailPage;
public static DataClass dataClass;

@Test
public void testMail() {
loginPage = new LoginPage(driver);
mailPage = new MailPage(driver);
newMailPage = new NewMailPage(driver);
dataClass = new DataClass();

loginPage.clickLogin();
loginPage.inputLogin(dataClass.login);
loginPage.inputPassword(dataClass.password);
loginPage.clickLoginBtn();
mailPage.createPage();
newMailPage.clickEmail();
newMailPage.adressEmail(dataClass.email);
newMailPage.themeEmail(dataClass.theme);
newMailPage.textMail(dataClass.textMail);
newMailPage.saveDraft();
newMailPage.closeDraftWindow();
mailPage.checkDraftFolder();
mailPage.checkLastDraft();
mailPage.assertMethodTest1();
mailPage.closeDraftWindow();
mailPage.logOut();
}
}

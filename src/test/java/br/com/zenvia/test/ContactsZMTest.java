package br.com.zenvia.test;

import br.com.zenvia.business.ContactsRules;
import br.com.zenvia.business.LoginRules;
import br.com.zenvia.core.BaseTest;
import br.com.zenvia.env.EnvironmentActualLoader;
import br.com.zenvia.env.PropertieLoader;
import br.com.zenvia.model.User;
import br.com.zenvia.page.AccountPage;
import br.com.zenvia.page.ContactsPage;
import br.com.zenvia.page.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author A.mann
 * Scenario test case
 * open url
 * send email
 * click next
 * send username
 * send password
 * click sigin
 */

public class ContactsZMTest extends BaseTest {
    //LoginRules loginRules = new LoginRules(driver);
    ContactsRules contactsRules = new ContactsRules(driver);

    protected String EMAIL = PropertieLoader.get().getEmail(EnvironmentActualLoader.get());
    protected String PASSWORD = PropertieLoader.get().getPassword(EnvironmentActualLoader.get());
    User user1 = User.builder().email(EMAIL).password(PASSWORD).build();

    @Test(description = "Successfully access your account", groups = {"navigation.test"})
    public void clickAddContacts() {

        AccountPage accountPage = new AccountPage(driver);
        contactsRules.login(user1);
        contactsRules.navigation();
        //loginRules.login(user1);


    }

//    @Test(description = "Successfully access your account and logout", groups = {"regression.test"})
//    public void loginAndLogout() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginRules.login(user1);
//        loginRules.logout();
//        assertTrue(loginPage.isLoginPage().isDisplayed());
//    }
//
//    @Test(description = "Successfully access your account and logout", groups = {"regression.test"})
//    public void loginAndLogout2() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginRules.login(user1);
//        loginRules.logout();
//        assertTrue(loginPage.isLoginPage().isDisplayed());
//    }
//
//    @BeforeClass
//    public void beforeClass() {
//
//    }
}
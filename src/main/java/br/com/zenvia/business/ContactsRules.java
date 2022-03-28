package br.com.zenvia.business;

import br.com.zenvia.core.BasePage;
import br.com.zenvia.model.User;
import br.com.zenvia.page.AccountPage;
import br.com.zenvia.page.ContactsPage;
import br.com.zenvia.page.LoginPage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ContactsRules extends BasePage {
    private LoginPage loginPage;
    private AccountPage accountPage;
    private ContactsPage contactsPage;


    public ContactsRules(RemoteWebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public LoginPage login(User user) {
        loginPage = new LoginPage(driver);

        //chrome login
        return loginPage.setEmail(user.getEmail()).clickNextButton().userNameInput(user.getEmail()).PasswordInput(user.getPassword()).clickSubmitButton();
       //funciondo return loginPage.setEmail(user.getEmail()).clickNextButton().userNameInput(user.getEmail()).PasswordInput(user.getPassword()).clickSubmitButton();

    }

    public AccountPage logout() {
        accountPage = new AccountPage(driver);
        return accountPage.getAccountMenu().getExit();
    }

    public ContactsPage navigation(){
        contactsPage = new ContactsPage(driver);
        return contactsPage.add_contact();

    }
}
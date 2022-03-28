package br.com.zenvia.page;

import br.com.zenvia.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author A.mann
 * Scenario test case
 * click add contacts button
 * click add manually button
 */

public class ContactsPage extends BasePage {

    @FindBy(xpath = "/html[1]/body[1]/app-navbar[1]/div[1]/nav[1]/div[1]/div[1]/a[1]/a[1]/img[1]")
    private WebElement home;

    @FindBy(xpath = "/html[1]/body[1]/app-navbar[1]/div[1]/nav[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/span[1]")
    private WebElement accountMenu;

    @FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
    private WebElement btn_add_contacts;

    //#########################################################################################

    public ContactsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public ContactsPage add_contact(){
        waitForElement(btn_add_contacts);
        this.btn_add_contacts.click();
        return this;
    }

    public WebElement getHome() {
        waitForElement(home);
        return home;
    }

    public ContactsPage getAccountMenu() {
        waitForElement(accountMenu);
        this.accountMenu.click();
        return this;
    }

}
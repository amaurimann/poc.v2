package br.com.zenvia.page;

import br.com.zenvia.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(xpath = "/html[1]/body[1]/app-navbar[1]/div[1]/nav[1]/div[1]/div[1]/a[1]/a[1]/img[1]")
    private WebElement home;

    @FindBy(xpath = "/html[1]/body[1]/app-navbar[1]/div[1]/nav[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/span[1]")
    private WebElement accountMenu;

    @FindBy(xpath = "/html[1]/body[1]/app-navbar[1]/div[1]/nav[1]/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div[11]/div[1]/div[1]/span[1]")
    private WebElement exit;

    public AccountPage(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement getHome() {
        waitForElement(home);
        return home;
    }

    public AccountPage getAccountMenu() {
        waitForElement(accountMenu);
        this.accountMenu.click();
        return this;
    }

    public AccountPage getExit() {
        waitForElement(exit);
        this.exit.click();
        return this;
    }
}
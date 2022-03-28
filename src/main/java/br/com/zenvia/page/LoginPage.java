package br.com.zenvia.page;

import br.com.zenvia.core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    // login chrome begin
    @FindBy(id = "email_signin")
    @CacheLookup
    protected WebElement email_field;

    @FindBy(id = "btn-next")
    private WebElement nextButton;
    //new
    @FindBy(id = "userNameInput")
    @CacheLookup
    protected WebElement userName_field;
    //new
    @FindBy(id = "passwordInput")
    @CacheLookup
    private WebElement passwordInput_field;
    //new
    @FindBy(id = "submitButton")
    @CacheLookup
    private WebElement submitButton;
    // login chrome end

//    @FindBy(id = "password_signin")
//    @CacheLookup
//    private WebElement password_field;
//
//    @FindBy(id = "btn-signin")
//    private WebElement loginButton;

    //#########################################################################################

    public LoginPage(RemoteWebDriver driver) {
        super(driver);
    }

    public LoginPage setEmail(String email) {
        this.email_field.sendKeys(email);
        return this;
    }

    public LoginPage clickNextButton() {
        this.nextButton.click();
        return this;
    }

    public LoginPage clickSubmitButton() {
        this.submitButton.click();
        return this;
    }

    public LoginPage userNameInput(String userName){
        this.userName_field.sendKeys(userName);
        return this;
    }

    public LoginPage PasswordInput(String password){
        this.passwordInput_field.sendKeys(password);
        return this;
    }

//    public LoginPage setPassword(String password) {
//        this.password_field.sendKeys(password);
//        return this;
//    }

//    public LoginPage clickLoginButton() {
//        this.loginButton.click();
//        return this;
//    }
//
    public WebElement isLoginPage() {
        waitForElement(email_field);
        return email_field;
    }
}
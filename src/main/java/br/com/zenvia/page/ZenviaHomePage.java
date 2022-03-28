package br.com.zenvia.page;

import br.com.zenvia.core.BasePage;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ZenviaHomePage extends BasePage {

    public ZenviaHomePage(RemoteWebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}

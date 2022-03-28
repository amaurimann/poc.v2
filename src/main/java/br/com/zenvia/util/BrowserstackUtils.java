package br.com.zenvia.util;

import br.com.zenvia.core.BrowserStackFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.SessionId;

/**
 * @author anderson.mann
 */
public class BrowserstackUtils extends BrowserStackFactory {

    public static void setTestStatus(String status, String message) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"" + status + "\", \"reason\": \"" + message + "\"}}");
    }

    public static void setTestName(String name) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("browserstack_executor: {\"action\": \"setSessionName\", \"arguments\": {\"name\": \"" + name + "\"}}");
    }

    public SessionId getSessionId() {
        SessionId value = driver.getSessionId();
        return value;
    }
}
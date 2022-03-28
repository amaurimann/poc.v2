package br.com.zenvia.core;

import br.com.zenvia.env.EnvironmentActualLoader;
import br.com.zenvia.env.PropertieLoader;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author A.mann
 */

public class BrowserStackFactory {
    protected static RemoteWebDriver driver;
    private static final String URL = PropertieLoader.get().getAuthenticateURI(EnvironmentActualLoader.get());

    protected static synchronized void createDriver(String browserName, String browserVersion, String os, String osVersion,
                                                    String resolution, String projectName) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> browserstackOptions = new HashMap<>();
            browserstackOptions.put("browserName", browserName);
            browserstackOptions.put("browserVersion", browserVersion);
            browserstackOptions.put("os", os);
            browserstackOptions.put("osVersion", osVersion);
            browserstackOptions.put("resolution", resolution);
            browserstackOptions.put("projectName", projectName);
            browserstackOptions.put("buildName", System.getProperty("BUILD_NAME", "local-zenvia-message-ui-atomated-tests-login-hlg"));
            browserstackOptions.put("local", "true");
            browserstackOptions.put("consoleLogs", "info");
            browserstackOptions.put("networkLogs", "true");
            browserstackOptions.put("video", "true");
            browserstackOptions.put("seleniumLogs", "true");
            browserstackOptions.put("maskCommands", "setValues");
            browserstackOptions.put("idleTimeout", "30");
            capabilities.setCapability("bstack:options", browserstackOptions);
            driver = new RemoteWebDriver(new URL(Constants.BS_C0NNECTION), capabilities);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            driver.get(URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
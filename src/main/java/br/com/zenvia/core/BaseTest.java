package br.com.zenvia.core;

import br.com.zenvia.util.TestListener;
import com.browserstack.local.Local;
import org.testng.annotations.*;

import java.util.HashMap;

/**
 * @author A.mann
 */
@Listeners({TestListener.class})
public abstract class BaseTest extends BrowserStackFactory {

    static Local bsLocal = new Local();

    @BeforeSuite(alwaysRun = true)
    public void startBrowserStackLocal() {
        HashMap<String, String> bsLocalArgs = new HashMap<>();
        bsLocalArgs.put("key", Constants.ACCESS_KEY);
        bsLocalArgs.put("browserstack.local", System.getenv("BROWSERSTACK_LOCAL"));
        bsLocalArgs.put("browserstack.localIdentifier", System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER"));
        bsLocalArgs.put("v", "true");
        bsLocalArgs.put("logFile", "logs/BSLocal.out");
        try {
            bsLocal.start(bsLocalArgs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName", "browserVersion", "os", "osVersion", "resolution", "projectName"})
    public void setupDriver(String browserName, String browserVersion, String os, String osVersion, String resolution, String projectName) {
        createDriver(browserName, browserVersion, os, osVersion, resolution, projectName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void stopBrowserStackLocal() {
        try {
            bsLocal.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
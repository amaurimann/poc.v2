package br.com.zenvia.test;

import br.com.zenvia.core.BaseTest;
import br.com.zenvia.page.ZenviaHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author anderson.mann
 */

public class ZenviaHomeTest extends BaseTest {

    ZenviaHomePage zenviaHome = new ZenviaHomePage(driver);

    @Test(description = "simple test", groups = {"smoke.test"})
    public void accessHomePage() {
        Assert.assertEquals(zenviaHome.getUrl(), "https://www.zenvia.com/");
        Assert.assertTrue(true);
    }

    @Test(description = "simple test", groups = {"regression.test"})
    public void accessHomePage2() {
        Assert.assertEquals(zenviaHome.getUrl(), "https://www.zenvia.com/");
    }
}
package br.com.zenvia.test;

import br.com.zenvia.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author anderson.mann
 */
public class DummiesTest extends BaseTest {


    @Test(description = "simple dummies test", groups = {"smoke.test"})
    public void dummiesTest() {
        Assert.assertTrue(true);
    }
}

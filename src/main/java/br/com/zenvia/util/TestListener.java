package br.com.zenvia.util;

import br.com.zenvia.core.BrowserStackFactory;
//import br.com.zenvia.database.PostGreDAO;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * @author anderson.mann
 */
public class TestListener extends BrowserStackFactory implements ITestListener {
    private final ExtentTestManager log = new ExtentTestManager();
    private final BrowserstackUtils bs = new BrowserstackUtils();
    private static final Logger logger = Logger.getLogger(TestListener.class);
    String suiteName;

//    PostGreDAO postGreDAO = new PostGreDAO();


    @Override
    public void onStart(ITestContext context) {
        logger.info("*** Test Suite " + context.getName() + " started ***");
        suiteName = context.getCurrentXmlTest().getSuite().getName();
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("*** Test Suite " + context.getName() + " ending ***");
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
        BrowserstackUtils.setTestStatus("passed", "Test successfully");
        BrowserstackUtils.setTestName(result.getMethod().getMethodName());
        log.getTest().log(Status.PASS, "Test passed");
        log.getTest().log(Status.INFO, "BrowserStack SessionId: " + bs.getSessionId());
        log.getTest().log(Status.INFO, "Suite name: " + suiteName);
        log.getTest().log(Status.INFO, "Class name: " + getTestClassName(result.getMethod().getMethodName()));
        log.getTest().log(Status.INFO, "Test description: " + result.getMethod().getDescription());

        String testName = result.getMethod().getMethodName();
//        postGreDAO.saveRecords(testName, "Test successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        BrowserstackUtils.setTestStatus("failed", "Test failed");
        BrowserstackUtils.setTestName(result.getMethod().getMethodName());
        log.getTest().log(Status.FAIL, "Test Failed");
        log.getTest().log(Status.INFO, "BrowserStack SessionId: " + bs.getSessionId());
        log.getTest().log(Status.INFO, "Suite name: " + suiteName);
        log.getTest().log(Status.INFO, "Class name: " + getTestClassName(result.getMethod().getMethodName()));
        log.getTest().log(Status.INFO, "Test description: " + result.getMethod().getDescription());
    }

    public String getTestClassName(String testName) {
        String[] reqTestClassname = testName.split("\\.");
        int i = reqTestClassname.length - 1;
        logger.info("Required Test Name : " + reqTestClassname[i]);
        return reqTestClassname[i];
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("*** Test " + result.getMethod().getMethodName() + " skipped...");
        log.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("*** Test failed but within percentage % " + result.getMethod().getMethodName());
    }
}
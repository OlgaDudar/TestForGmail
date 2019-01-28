package core;

import core.driver.WebDriverThreadLocal;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;

import org.testng.IInvokedMethodListener;

import org.testng.ISuite;

import org.testng.ISuiteListener;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestNGMethod;

import org.testng.ITestResult;

import org.testng.Reporter;

import java.io.File;

public class CustomListener implements ITestListener, ISuiteListener, IInvokedMethodListener {

   private String path = System.getProperty("user.dir")+"\\screenshots\\"+System.currentTimeMillis()+".png";

    @Override

    public void onStart(ISuite arg0) {

        Reporter.log("Start executing Suite " + arg0.getName(), true);

    }

    // This belongs to ISuiteListener and will execute, once the Suite is finished

    @Override

    public void onFinish(ISuite arg0) {

        Reporter.log("End executing Suite " + arg0.getName(), true);

    }

    // This belongs to ITestListener and will execute before starting of Test set/batch

    public void onStart(ITestContext arg0) {

        Reporter.log("Start executing Test " + arg0.getName(), true);

    }

    // This belongs to ITestListener and will execute, once the Test set/batch is finished

    public void onFinish(ITestContext arg0) {

        Reporter.log("Completed executing test " + arg0.getName(), true);

    }

    // This belongs to ITestListener and will execute only when the test is pass

    public void onTestSuccess(ITestResult arg0) {

        // This is calling the printTestResults method

        printTestResults(arg0);

    }

    // This belongs to ITestListener and will execute only on the event of fail test

    public void onTestFailure(ITestResult arg0) {

        // This is calling the printTestResults method

        printTestResults(arg0);

    }

    // This belongs to ITestListener and will execute before the main test start (@Test)

    public void onTestStart(ITestResult arg0) {

        System.out.println("The execution of the main test starts now");

    }

    // This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped

    public void onTestSkipped(ITestResult arg0) {

        printTestResults(arg0);

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    // This is the method which will be executed in case of test pass or fail

    // This will provide the information on the test

    private void printTestResults(ITestResult result) {

        Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

        if (result.getParameters().length != 0) {

            String params = null;

            for (Object parameter : result.getParameters()) {

                params += parameter.toString() + ",";

            }

            Reporter.log("Test Method had the following parameters : " + params, true);

        }

        String status = null;

        switch (result.getStatus()) {

            case ITestResult.SUCCESS:

                status = "Pass";
                //makeScreenshot();

                break;

            case ITestResult.FAILURE:

                status = "Failed";
                //makeScreenshot();

                break;

            case ITestResult.SKIP:

                status = "Skipped";

        }

        Reporter.log("Test Status: " + status +" See attachment: " + makeScreenshot(), true);

    }

    // This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test

    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "Start executing following method : " + returnMethodName(arg0.getTestMethod());

        Reporter.log(textMsg, true);

    }

    // This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test

    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

        Reporter.log(textMsg, true);

    }

    // This will return method names to the calling function

    private String returnMethodName(ITestNGMethod method) {

        return method.getRealClass().getSimpleName() + "." + method.getMethodName();

    }


    private String makeScreenshot() {
        File scr;
        try{
            scr = ((TakesScreenshot) WebDriverThreadLocal.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scr, new File(path));
            return path;
        }
        catch(Exception ex){
           return null ;
        }

    }

}
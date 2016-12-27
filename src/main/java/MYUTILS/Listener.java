package MYUTILS;

import static POLIB.BasePage.driver;
import POLIB.TestBaseSetup;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
 

public class Listener implements ITestListener, IInvokedMethodListener {

	public void onFinish(ITestContext arg0) {
		Reporter.log("Completed executing test " + arg0.getName(), true);
	}

	public void onStart(ITestContext arg0) {
		Reporter.log("About to begin executing test " + arg0.getName(), true);
	}
        
           public void takeScreenShot(String methodName,String testclass) {
    	//get the driver
                    driver = TestBaseSetup.getDriver();
                 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File("C:\\tests\\testclass\\"+methodName+".png"));
				Log.info("***Placed screen shot in "+"C:\\tests\\testclass"+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
	}
        
        

	public void onTestFailure(ITestResult result) {
          Log.error("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	takeScreenShot(methodName,result.getTestClass().getName());
		printTestResults(result);
	}

	private void printTestResults(ITestResult result) {
		Reporter.log("TestName = " + result.getTestName(), true);
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
			break;
		case ITestResult.FAILURE:
			status = "Failed";
			break;
		case ITestResult.SKIP:
			status = "Skipped";
		}
		Reporter.log("Test Status: " + status, true);
	}

	public void onTestSkipped(ITestResult arg0) {
		printTestResults(arg0);
	}

	public void onTestStart(ITestResult arg0) {
	}

	public void onTestSuccess(ITestResult arg0) {
		printTestResults(arg0);
	}

	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "Completed executing " + returnMethodName(arg0.getTestMethod());
		Reporter.log(textMsg, true);

	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		String textMsg = "About to begin executing " + returnMethodName(arg0.getTestMethod());
		Reporter.log(textMsg, true);
	}

	private String returnMethodName(ITestNGMethod method) {
		return method.getRealClass().getSimpleName() + "." + method.getMethodName();
	}

}



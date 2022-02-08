package baseclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Baseclass implements ITestListener {
	 
	public static ThreadLocal<ExtentTest> parallel= new ThreadLocal<ExtentTest>();
	@Override
	public void onFinish(ITestContext context) {
ex.flush();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
	WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {

			parallel.get().addScreenCaptureFromPath(getscreeshot(methodname, driver),"Failed at: " +methodname );
			getscreeshot(methodname, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		parallel.get().log(Status.FAIL, "Failed test" +methodname +result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestStart(ITestResult result) {
String methodname= result.getMethod().getMethodName();
		test= ex.createTest(methodname);
		parallel.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
		
		
		parallel.get().log(Status.PASS, "Test is passed  :" + methodname);	
		
	}

}

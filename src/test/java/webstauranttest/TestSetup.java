package webstauranttest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import util.DriverUtil;
import util.Listener;
import util.LoggerUtil;
import util.PropertiesUtil;
import org.testng.ITestContext;

@Listeners(Listener.class)
public class TestSetup extends LoggerUtil{
	private static String browserName;
	static WebDriver driver; 
	

@BeforeSuite
public static void driverSetup() {
	LoggerUtil.info("--------------------------------- Test Execution Started ---------------------------------");
	browserName = (PropertiesUtil.getProperty("browser"));
	LoggerUtil.info("--------------------------------- Driver Setup Started ---------------------------------");
	driver = DriverUtil.initializeWebDriver(browserName);
	driver.manage().window().maximize();
	LoggerUtil.info("--------------------------------- Driver Setup Completed ---------------------------------");
}

	

	    
@AfterSuite
public void driverClose(ITestContext context) {
	int total = context.getAllTestMethods().length;
	int passed = context.getPassedTests().size();
	int failed = context.getFailedTests().size();
	int skipped = context.getSkippedTests().size();
	LoggerUtil.info("Total number of testcases : " + total);
	LoggerUtil.info("Number of testcases Passed : " + passed);
	LoggerUtil.info("Number of testcases Failed : " + failed);
	LoggerUtil.info("Number of testcases Skipped  : " + skipped);
	LoggerUtil.info("--------------------------------- Test Execution Completed ---------------------------------");
	driver.quit();
	    }


}
package util;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	/**
	 * Gets the test name using ITestResults.
	 */
	public String getTestName(ITestResult result) {
		return result.getTestName() != null ? result.getTestName()
				: result.getMethod().getConstructorOrMethod().getName();
	}

	/**
	 * Gets the test description using ITestResults.
	 */
	public String getTestDescription(ITestResult result) {
		return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	}

	/**
	 * Logs test start
	 */
	@Override
	public void onTestStart(ITestResult result) {
		LoggerUtil.info(getTestName(result) + ": Test started");
	}

	/**
	 * Logs test success
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		LoggerUtil.info(getTestName(result) + " : Test Passed");
	}

	/**
	 * Logs test failures
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null)
			cause = t.getMessage();
		LoggerUtil.error(getTestName(result) + " : Test Failed : " + cause);
	}

	/**
	 * Logs skipped tests
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		LoggerUtil.info(getTestName(result) + " : Test Skipped");
	}

}

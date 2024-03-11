package util;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtil {
	
	/**
	 * Maps the driver for browser and initializes web driver based on browser type input.
	 */
	public static WebDriver initializeWebDriver(String browserName) {
		WebDriver driver = null;
		try {
			Map<String, Class<? extends WebDriver>> webDriversMapping = new HashMap<>();
			webDriversMapping.put("chrome", ChromeDriver.class);
			webDriversMapping.put("firefox", FirefoxDriver.class);
			webDriversMapping.put("edge", EdgeDriver.class);
			webDriversMapping.put("safari", SafariDriver.class);

			Class<? extends WebDriver> driverClass = webDriversMapping.get(browserName.toLowerCase());
			if (driverClass != null) {
				WebDriverManager.getInstance(driverClass).setup();
				driver = driverClass.getDeclaredConstructor().newInstance();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}

package webstaurantobjectrepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.LoggerUtil;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

//	@CacheLookup
	@FindBy(id = "searchval")
	private static WebElement searchTextBox;

//	@CacheLookup
	@FindBy(xpath = "//button[@value='Search']")
	private static WebElement searchButton;

	/**
	 * Function to launch the application
	 */
	public void lauchApplication(String url) {
		driver.get(url);
	}

	/**
	 * Function to search an item
	 */
	public void searchItem(String searchInput) {

		if (!driver.getTitle().contains("WebstaurantStore")) {
			LoggerUtil.error("Error in homepage. Incorrect Title");
		}
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(searchTextBox)).sendKeys(searchInput);

		wait.until(ExpectedConditions.visibilityOf(searchButton)).sendKeys(Keys.RETURN);

	}

}

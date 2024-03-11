package webstaurantobjectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.LoggerUtil;

public class CartPage {

	WebDriver driver;
	private String cartValidationText;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//button[normalize-space()='Empty Cart']")
	private static WebElement emptyCartButton;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private static WebElement reactModal;

	@FindBy(xpath = "//p[@class='header-1']")
	private static WebElement emptyCartValidation;

	/**
	 * Function to click empty cart button
	 */
	public void clickEmptyCart() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(emptyCartButton)).click();
	}

	/**
	 * Function to click empty cart confirmation button
	 */
	public void confirmEmptyCart() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(reactModal));
		WebElement emptyCartConfirmation = reactModal.findElement(By.xpath(".//button[contains(text(),\"Empty\")]"));
		emptyCartConfirmation.sendKeys(Keys.RETURN);
	}

	/**
	 * Function to validate if cart is empty
	 */
	public void validateEmptyCart(String assertEmptyCart) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(emptyCartValidation));
		cartValidationText = emptyCartValidation.getText();
		Assert.assertTrue(cartValidationText.contains(assertEmptyCart), "Cart is not empty : Test Failed");
		if (!cartValidationText.contains(assertEmptyCart)) {
			LoggerUtil.error("Cart is not empty. Verification Failed");

		}
	}

}

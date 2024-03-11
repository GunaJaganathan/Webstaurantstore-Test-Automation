package webstaurantobjectrepository;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import util.LoggerUtil;

public class SearchResults {

	WebDriver driver;
	static SoftAssert softAssert = new SoftAssert();

	public SearchResults(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[@id='paging']//li[last()-1]")
	private static WebElement pageNumber;

	@FindBy(xpath = "//div[@id='paging']//li[last()]")
	private static WebElement pages;

	@FindBy(id = "ProductBoxContainer")
	private static List<WebElement> productList;

	@FindBy(xpath = "//span[@data-testid='itemDescription']")
	private static List<WebElement> productTitleList;

	@FindBy(xpath = "(//input[@name='addToCartButton'])[last()]")
	private static WebElement addToCart;

	@FindBy(xpath = "//a[@href='/cart/']")
	private static WebElement viewCart;

	@FindBy(xpath = "//input[contains(@class,'quantityInput')]")
	private static WebElement getQuantity;

	/**
	 * Function to verify if all products returned by the search
	 */
	public void verifyEachProductTitle(String prodTitleAssert) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String totalPagesText = wait.until(ExpectedConditions.visibilityOf(pageNumber)).getText();

		int totalPagesInt = Integer.parseInt(totalPagesText);

		for (int pageNum = 2; pageNum <= totalPagesInt; pageNum = pageNum + 1) {
			pages.click();
			int totalProdInPage = wait.until(ExpectedConditions.visibilityOfAllElements(productList)).size();

			for (int prodNum = 0; prodNum <= totalProdInPage - 1; prodNum = prodNum + 1) {
				WebElement productTitle = productTitleList.get(prodNum);
				String productTitleText = productTitle.getText();
				softAssert.assertTrue(productTitleText.contains(prodTitleAssert), "Product title " + productTitleText
						+ " in page " + (pageNum-1) + " doesn't contain " + prodTitleAssert + " : Verification Failed");
				if (!productTitleText.contains(prodTitleAssert)) {
					LoggerUtil.error("Product title " + productTitleText + " in page " + (pageNum-1) + " doesn't contain "
							+ prodTitleAssert + " : Verification Failed");

				}

			}
			LoggerUtil.info("Products title in page " + (pageNum - 1) + " are validated successfully");
		}
	}

	/**
	 * Function to add the last item to the cart
	 */
	public void addItemToCart() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(addToCart)).sendKeys(Keys.RETURN);

	}

	/**
	 * Function to view the cart and verify if item added to the cart
	 */
	public void viewCart() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(viewCart)).sendKeys(Keys.RETURN);
		String prodQuantity = wait.until(ExpectedConditions.visibilityOf(getQuantity)).getAttribute("value");
		Assert.assertEquals(Integer.parseInt(prodQuantity), 1);
		if (Integer.parseInt(prodQuantity) != 1)
			;
		{
			LoggerUtil.error("Product was not added to the cart");
		}

	}

}

package webstauranttest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import util.Listener;
import util.PropertiesUtil;
import webstaurantobjectrepository.CartPage;
import webstaurantobjectrepository.HomePage;
import webstaurantobjectrepository.SearchResults;

@Listeners(Listener.class)
public class WebstaurantSearchItemTest extends TestSetup {

	HomePage homepage;
	SearchResults searchresultspage;
	CartPage cartpage;

	@BeforeTest
	void initPageObject() {
		homepage = PageFactory.initElements(driver, HomePage.class);
		searchresultspage = PageFactory.initElements(driver, SearchResults.class);
		cartpage = PageFactory.initElements(driver, CartPage.class);
	}

	@Test
	void testAddStainlessTableToCart() {
		String url = PropertiesUtil.getProperty("url");
		if (url == null || url == "") {
			logger.error("No URL. Check property file");
		}
		logger.info("------------------Test Case 'testAddStainlessTableToCart' started------------------");
		homepage.lauchApplication(url);
		homepage.searchItem("stainless work table");
		searchresultspage.verifyEachProductTitle("Table");
		searchresultspage.addItemToCart();
		searchresultspage.viewCart();
		cartpage.clickEmptyCart();
		cartpage.confirmEmptyCart();
		cartpage.validateEmptyCart("Your cart is empty.");
		logger.info("------------------Test Case 'testAddStainlessTableToCart' completed------------------");
	}

	@Test
	void testAddWoodTableToCart() {
		String url = PropertiesUtil.getProperty("url");
		if (url == null || url == "") {
			logger.error("No URL. Check property file");
		}
		logger.info("------------------Test Case 'testAddWoodTableToCart' started------------------");
		homepage.lauchApplication(url);
		homepage.searchItem("wood work table");
		searchresultspage.verifyEachProductTitle("Table");
		searchresultspage.addItemToCart();
		searchresultspage.viewCart();
		cartpage.clickEmptyCart();
		cartpage.confirmEmptyCart();
		cartpage.validateEmptyCart("Your cart is empty.");
		logger.info("------------------Test Case 'testAddWoodTableToCart' completed------------------");
	}

}

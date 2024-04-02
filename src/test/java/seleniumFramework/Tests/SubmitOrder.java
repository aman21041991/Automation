package seleniumFramework.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import seleniumFramework.TestComponents.BaseTest;
import seleniumFramework.pageobjects.CartPage;
import seleniumFramework.pageobjects.CheckoutPage;
import seleniumFramework.pageobjects.ConfirmationPage;
import seleniumFramework.pageobjects.OrdersPage;
import seleniumFramework.pageobjects.ProductCatalouge;

public class SubmitOrder extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData" , groups = "Purchase")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException{

		ProductCatalouge ProductCatalouge = landingpage.appLogin(input.get("email"), input.get("password"));

		// ProductCatalouge ProductCatalouge = new ProductCatalouge(driver);
		List<WebElement> products = ProductCatalouge.getProductList();
		ProductCatalouge.aadProductToCart(input.get("product"));
		CartPage CartPage = ProductCatalouge.goToCart();
		// CartPage CartPage = new CartPage(driver);

		Boolean match = CartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage CheckoutPage = CartPage.goToCheckout();
		CheckoutPage.SelectCountry("india");
		ConfirmationPage ConfirmationPage = CheckoutPage.submitOrder();
		String confirmMessage = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void orderHistory() {

		ProductCatalouge ProductCatalouge = landingpage.appLogin("singh.aman.gautam@gmail.com", "Amansingh@123#");
		OrdersPage OrdersPage = ProductCatalouge.goToOrdersPage();
		Boolean match = OrdersPage.verifyOrderDisplay(productName);
		Assert.assertTrue(match);
	}

	
	@DataProvider
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String, String>>	data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//seleniumFramework//data//PurchaseOrder.json");
	return new Object[][] {{ data.get(0) } , { data.get(1)}};
	

	}

//	@DataProvider
//	public Object[][] getData()
//	{
//		
//	return new Object[][] {{"singh.aman.gautam@gmail.com", "Amansingh@123#" , "ZARA COOAT 3"} , {"aman.gautam@ninja-ai.com", "Amansingh@123#" , "ADIDAS ORIGINAL" }};
//	
//
//	}
	
	
}

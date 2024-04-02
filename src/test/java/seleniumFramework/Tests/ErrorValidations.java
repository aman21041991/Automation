package seleniumFramework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumFramework.TestComponents.BaseTest;
import seleniumFramework.TestComponents.Retry;

public class ErrorValidations extends BaseTest {

	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void errorvalidation() throws IOException { 
		
		String productName = "ZARA COAT 3";
		 landingpage.appLogin("singh.aman.gautam@gmail.com", "Aamansingh@123#");
         Assert.assertEquals("Incorrect emai or password.", landingpage.getErrorMessage()); 
         
		
		
	}
}

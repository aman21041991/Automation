package seleniumFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFramework.GenericAbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement SelectCountry;
	
	@FindBy(css=".action__submit")
	WebElement Submit;
	
	By result = By.cssSelector(".ta-results");
	

	public void SelectCountry(String CountryName) {

		Actions a = new Actions(driver);
       a.sendKeys(Country , CountryName).build().perform();
		waitForEelementToAppear (By.cssSelector(".ta-results"));
		SelectCountry.click();
	}
	
	public ConfirmationPage submitOrder() {
		Submit.click();
		ConfirmationPage ConfirmationPage	= new ConfirmationPage(driver);
		return ConfirmationPage;
	}

}

package seleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFramework.GenericAbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
	
	
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	
	//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	public String getConfirmationMessage() {
		
	String Message=	confirmationMessage.getText();
	return Message;
	}

}

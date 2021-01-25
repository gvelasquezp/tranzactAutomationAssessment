package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	public WebDriver driver;
	
	@FindBy (css = ".header_user_info")
	WebElement signInButton;
	
	@FindBy (id = "email_create")
	WebElement emailAddressAccountField;
	
	@FindBy(id = "SubmitCreate")
	WebElement createAccountButton;
	
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

	public WebElement getSignInButton() {
		return signInButton;
	}
	
	public WebElement getEmailAddressAccountField() {
		return emailAddressAccountField;
	}
	
	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}
}

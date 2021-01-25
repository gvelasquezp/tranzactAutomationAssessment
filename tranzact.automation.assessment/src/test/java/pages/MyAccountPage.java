package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage{
	
	public WebDriver driver;
	
	@FindBy (css = ".account")
	WebElement accountInfoLabel;
	
	@FindBy (css = ".logout")
	WebElement logoutButton;
	
	@FindBy(id = "SubmitCreate")
	WebElement createAccountButton;
	
    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

	public WebElement getAccountInfoLabel() {
		return accountInfoLabel;
	}
	
	public WebElement getLogoutButton() {
		return logoutButton;
	}
	
}

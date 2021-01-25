package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegistrationPage;

public class TranzactTest extends BaseTest{
	

	private HomePage homePage;
	private RegistrationPage registrationPage;
	private MyAccountPage myAccountPage;
	String accountName;
	String accountLastname;
	
	@Given("I open the Home page")
	public void i_open_the_home_page() {	    
		System.out.println("Initializing the browser to run the test.");
	    startBrowserDefined("chrome");	    
	}

	@Given("I click on Sign in button")
	public void i_click_on_sign_in_button() {		
		homePage = new HomePage(driver);
		System.out.println("Verifying the Sign in button is displayed.");
		Assert.assertTrue(homePage.getSignInButton().isDisplayed());
		System.out.println("Click on Sign in button.");
		homePage.getSignInButton().click();		
	}

	@Given("I enter my email address")
	public void i_enter_my_email_address() {
		System.out.println("Generating valid email for registration.");
		String email = generateRandomEmail();
		homePage.getEmailAddressAccountField().sendKeys(email);
	}

	@Given("I click on Create Account button")
	public void i_click_on_create_account_button() {
		System.out.println("Verifying the Create Account button is displayed");
		Assert.assertTrue(homePage.getCreateAccountButton().isDisplayed());
		waitElementIsClickable(homePage.getCreateAccountButton());
		System.out.println("Click on Create Account button.");
		homePage.getCreateAccountButton().click();
	}

	@When("^I fill all fields for ([^\"]*) & ([^\"]*) user$")
	public void i_fill_all_fields_for_name_lastname_user(String name , String lastname) throws IOException {
		System.out.println("Filling in the form with valid data for registration");
		accountName = name;
		accountLastname = lastname;
		registrationPage = new RegistrationPage(driver);
		waitElementIsVisible(registrationPage.getMrCheckbox());
		InputStream input = new FileInputStream("src/test/java/resources/framework.properties");
		Properties prop = new Properties();
        prop.load(input);
               
        registrationPage.selectGender(prop.getProperty("gender"));
        registrationPage.getPFirstnameField().sendKeys(name);
        registrationPage.getPLastnameField().sendKeys(lastname);
        
        System.out.println("Generating random password for registration.");
        String pass = generateRandomPassword();
        registrationPage.getPasswordField().sendKeys(pass);
        
        registrationPage.selectDate(prop.getProperty("dateBirthday"));
        registrationPage.selectNewsletter(prop.getProperty("newsletter"));
        registrationPage.selectOffers(prop.getProperty("offers"));
        registrationPage.getFirstnameField().clear();
        registrationPage.getFirstnameField().sendKeys(name);
        registrationPage.getLastnameField().clear();
        registrationPage.getLastnameField().sendKeys(lastname);
        registrationPage.getCompanyField().sendKeys(prop.getProperty("company"));
        registrationPage.getAddress1Field().sendKeys(prop.getProperty("address1"));
        registrationPage.getAddress2Field().sendKeys(prop.getProperty("address2"));
        registrationPage.getCityField().sendKeys(prop.getProperty("city"));
        registrationPage.selectState(prop.getProperty("state"));
        registrationPage.getPostcodeField().sendKeys(prop.getProperty("postalCode"));
        registrationPage.getAdditionalInformationField().sendKeys(prop.getProperty("additionalInfo"));
        registrationPage.getPhoneField().sendKeys(prop.getProperty("homePhone"));
        registrationPage.getPhoneMobileField().sendKeys(prop.getProperty("mobilePhone"));
        registrationPage.getAliasField().clear();
        registrationPage.getAliasField().sendKeys(prop.getProperty("alias"));
        
	}

	@When("I click on Register button")
	public void i_click_on_register_button() {
		System.out.println("Verifying the Submit button is displayed");
		Assert.assertTrue(registrationPage.getSubmitAccountButton().isDisplayed());
		System.out.println("Click on Submit button.");
		registrationPage.getSubmitAccountButton().click();
		myAccountPage = new MyAccountPage(driver);
		waitElementIsVisible(myAccountPage.getAccountInfoLabel());
	}

	@Then("I access to my account page")
	public void i_access_to_my_account_page() {
		System.out.println("Verifying that the account information displayed shows the registered data");
		String accountInfo = myAccountPage.getAccountInfoLabel().getText();
		Assert.assertTrue((accountInfo.contains(accountName))&(accountInfo.contains(accountLastname)));
	}

	@Then("I logout from my account page")
	public void i_logout_from_my_account_page() throws InterruptedException {
		System.out.println("Verifying the Logout button is displayed");
		waitElementIsClickable(myAccountPage.getLogoutButton());
		System.out.println("Click on Logout button.");
		myAccountPage.getLogoutButton().click();
		System.out.println("Verifying that the user has successfully logged out");
		Assert.assertTrue(homePage.getSignInButton().isDisplayed());
		waitDriver();
		closeDriver();
	}

}

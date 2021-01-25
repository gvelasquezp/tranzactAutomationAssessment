package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends BasePage{
	
	public WebDriver driver;
	
	@FindBy (id = "uniform-id_gender1")
	WebElement mrCheckbox;
	
	@FindBy (id = "uniform-id_gender2")
	WebElement mrsCheckbox;
	
	@FindBy (id = "customer_firstname")
	WebElement pr_firstnameField;
	
	@FindBy (id = "customer_lastname")
	WebElement pr_lastnameField;
	
	@FindBy (id = "email")
	WebElement emailField;
	
	@FindBy (id = "passwd")
	WebElement passwordField;
	
	@FindBy (id = "days")
	WebElement daysSelect;
	
	@FindBy (id = "months")
	WebElement monthsSelect;
	
	@FindBy (id = "years")
	WebElement yearsSelect;
	
	@FindBy (id = "newsletter")
	WebElement newsletterCheckbox;
	
	@FindBy (id = "optin")
	WebElement receiveOffersCheckbox;
	
	@FindBy (id = "firstname")
	WebElement firstnameField;
	
	@FindBy (id = "lastname")
	WebElement lastnameField;
	
	@FindBy (id = "company")
	WebElement companyField;
	
	@FindBy (id = "address1")
	WebElement addressField1;
	
	@FindBy (id = "address2")
	WebElement address2Field;
	
	@FindBy (id = "city")
	WebElement cityField;
	
	@FindBy (id = "id_state")
	WebElement stateSelect;
	
	@FindBy (id = "postcode")
	WebElement postcodeField;
	
	@FindBy (id = "id_country")
	WebElement countrySelect;
	
	@FindBy (id = "other")
	WebElement additionalInformationField;
	
	@FindBy (id = "phone")
	WebElement phoneField;
	
	@FindBy (id = "phone_mobile")
	WebElement phoneMobileField;
	
	@FindBy (id = "alias")
	WebElement aliasField;
	
	@FindBy (id = "submitAccount")
	WebElement submitAccountButton;
	
    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

	public WebElement getMrCheckbox() {
	return mrCheckbox;
	}
	
	public WebElement getMrsCheckbox() {
	return mrsCheckbox;
	}
	
	public WebElement getPFirstnameField() {
	return pr_firstnameField;
	}
	
	public WebElement getPLastnameField() {
	return pr_lastnameField;
	}
	
	public WebElement getEmailField() {
	return emailField;
	}
	
	public WebElement getPasswordField() {
	return passwordField;
	}
	
	public WebElement getDaysSelect() {
	return daysSelect;
	}
	
	public WebElement getMonthsSelect() {
	return monthsSelect;
	}
	
	public WebElement getYearsSelect() {
	return yearsSelect;
	}
	
	public WebElement getNewsletterCheckbox() {
	return newsletterCheckbox;
	}
	
	public WebElement getReceiveOffersCheckbox() {
	return receiveOffersCheckbox;
	}
	
	public WebElement getFirstnameField() {
	return firstnameField;
	}
	
	public WebElement getLastnameField() {
	return lastnameField;
	}
	
	public WebElement getCompanyField() {
	return companyField;
	}
	
	public WebElement getAddress1Field() {
	return addressField1;
	}
	
	public WebElement getAddress2Field() {
	return address2Field;
	}
	
	public WebElement getCityField() {
	return cityField;
	}
	
	public WebElement getStateSelect() {
	return stateSelect;
	}
	
	public WebElement getPostcodeField() {
	return postcodeField;
	}
	
	public WebElement getCountrySelect() {
	return countrySelect;
	}
	
	public WebElement getAdditionalInformationField() {
	return additionalInformationField;
	}
	
	public WebElement getPhoneField() {
	return phoneField;
	}
	
	public WebElement getPhoneMobileField() {
	return phoneMobileField;
	}
	
	public WebElement getAliasField() {
	return aliasField;
	}
	
	public WebElement getSubmitAccountButton() {
	return submitAccountButton;
	}
	
	public void selectGender(String gender) {
		if (gender.equals("male")){
			getMrCheckbox().click();
		}
		else
			getMrsCheckbox().click();
	}
	
	public void selectDate(String birthday) {		
		String[] date = birthday.split("/");
		String year = date[0];
		String month = date[1];
		String day = date[2];
		String prov = month.charAt(0)+"";
		
		if(prov.equals("0"))
			month=month.charAt(1)+"";
		
		Select selectDay = new Select(daysSelect);
		selectDay.selectByValue(day);
		
		Select selectMonth = new Select(monthsSelect);
		selectMonth.selectByValue(month);
		
		Select selectYear = new Select(yearsSelect);
		selectYear.selectByValue(year);		
	}
	
	public void selectNewsletter(String value) {
		if(value.equals("true"))
			getNewsletterCheckbox().click();
	}
	
	public void selectOffers(String value) {
		if(value.equals("true"))
			getReceiveOffersCheckbox().click();
	}
	
	public void selectState(String state) {	
		Select selectState = new Select(stateSelect);
		selectState.selectByVisibleText(state);
	}
	
}

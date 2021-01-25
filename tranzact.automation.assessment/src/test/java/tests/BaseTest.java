package tests;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {
	
    public WebDriver driver;
	

	 /**
     * This is a method for start the browser defining the browser name
     // @param String
     *            browserName
     **/
    public void startBrowserDefined(String browserName) {
    	String browser = browserName.toLowerCase();
        System.out.println("Testing in Browser: " + browser);
        if (browser == "firefox"){
        	System.setProperty("webdriver.gecko.driver","$Path\\Firefoxriver");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        else if (browser == "chrome"){

            System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            System.out.println("Go to http://automationpractice.com/index.php");
            driver.get("http://automationpractice.com/index.php");
            
        }
        System.out.println("Browser initialized successfully :" + browser);
    }
    
    
    /**
     * This is a method for close the browser driver
     **/
    public void closeDriver() {
    	System.out.println("Closing the browser ... ");
        driver.quit();
        System.out.println("Browser closed successfully.");
    }

    /**
     * This is a method for make a pause of 5'
     **/
    public void waitDriver() throws InterruptedException {
        Thread.sleep(5000);
    }
    
    /**
     * This is a method for generate a random email'
     **/
    public String generateRandomEmail(){
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	String randomEmail = "user"+timestamp.getTime()+"@test.com";
    	return randomEmail;
    }
    
    /**
     * This is a method for wait a element clickable
     **/
    public void waitElementIsClickable(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 10); 
    	wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * This is a method for wait a element visible
     **/
    public void waitElementIsVisible(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 10); 
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    /**
     * This is a method for generate a random password
     **/
    public static String generateRandomPassword(){
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final int len = 10;
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
}

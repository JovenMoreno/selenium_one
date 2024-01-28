package Codefios;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillingBy {
	
	WebDriver driver;

	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By USER_PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By USER_SUBMIT_FIELD = By.xpath("//button[@id='login_submit']"); 
	By DASHBOARD_VALIDATION_FIELD = By.xpath("//strong[contains(text(),'Dashboard')]");  
	By TRANSACTIONS_FIELD = By.xpath("//span[contains(text(),'Transactions')]");
	By DEPOSITS_FIELD = By.xpath("//span[contains(text(),'Deposit')]");
	By DEPOSIT_PAGE_VALIDATION_FIELD = By.xpath("//a[contains(text(),'Codefios')]");
	By DEPOSITER_NAME_FIELD = By.cssSelector("input[class='form-control']");
	By DEPOSITORS_NOTE_FIELD = By.xpath("//textarea[@name='notes']");
	By DEPOSITED_AMOUNT_FIELD = By.xpath("//input[@class='form-control ']");
	By DEPOSIT_SUBMIT_FIELD = By.xpath("//button[@class='btn btn-sm btn-primary' ]");
	
	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Selenium_Practice1\\Assignment\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@Test
	public void positiveLoginTest()  {

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(USER_PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(USER_SUBMIT_FIELD).click();
		
		Assert.assertTrue("Page Not Found",driver.findElement(DASHBOARD_VALIDATION_FIELD).isDisplayed());

		driver.findElement(TRANSACTIONS_FIELD).click();
		

		driver.findElement(DEPOSITS_FIELD).click();
		

		Assert.assertTrue("Page Not Found", driver.findElement(DEPOSIT_PAGE_VALIDATION_FIELD).isDisplayed());
		
		
		driver.findElement(DEPOSITER_NAME_FIELD).sendKeys("Joven Moreno");
		
		
		driver.findElement(DEPOSITORS_NOTE_FIELD).sendKeys("This is my First account");
		
		
		driver.findElement(DEPOSITED_AMOUNT_FIELD).sendKeys("15000");
		
		
		driver.findElement(DEPOSIT_SUBMIT_FIELD).click();
		 
		
		
		
		

	}

	
	
	
	
	
	
	
	


}

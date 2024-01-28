package Codefios;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillingWebElement {

	WebDriver driver;

	WebElement USER_NAME;
	WebElement USER_PASSWORD;
	WebElement USER_SUBMIT;
	WebElement DASHBOARD_VALIDATION;
	WebElement TRANSACTIONS;
	WebElement DEPOSITS;
	WebElement DEPOSIT_PAGE_VALIDATION;
	WebElement DEPOSITER_NAME;
	WebElement DEPOSITORS_NOTE;
	WebElement DEPOSITED_AMOUNT;
	WebElement DEPOSIT_SUBMIT;

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

		USER_NAME = driver.findElement(By.xpath("//input[@id='user_name']"));
		USER_PASSWORD = driver.findElement(By.xpath("//input[@id='password']"));
		USER_SUBMIT = driver.findElement(By.xpath("//button[@id='login_submit']"));
		
		USER_NAME.sendKeys("demo@codefios.com");
		USER_PASSWORD.sendKeys("abc123");
		USER_SUBMIT.click(); 
		
		DASHBOARD_VALIDATION = driver.findElement(By.xpath("//strong[contains(text(),'Dashboard')]"));
		Assert.assertTrue("Page Not Found", DASHBOARD_VALIDATION.isDisplayed());

		TRANSACTIONS = driver.findElement(By.xpath("//span[contains(text(),'Transactions')]"));
		TRANSACTIONS.click();

		DEPOSITS = driver.findElement(By.xpath("//span[contains(text(),'Deposit')]"));
		DEPOSITS.click();

		DEPOSIT_PAGE_VALIDATION = driver.findElement(By.xpath("//a[contains(text(),'Codefios')]"));
		Assert.assertTrue("Page Not Found", DEPOSIT_PAGE_VALIDATION.isDisplayed());
		
		DEPOSITER_NAME = driver.findElement(By.cssSelector("input[class='form-control']"));
		DEPOSITER_NAME.sendKeys("Joven Moreno");
		
		
		
		DEPOSITORS_NOTE = driver.findElement(By.xpath("//textarea[@name='notes']"));
		DEPOSITORS_NOTE.sendKeys("This is my First account");
		
		DEPOSITED_AMOUNT = driver.findElement(By.xpath("//input[@class='form-control ']"));
		DEPOSITED_AMOUNT.sendKeys("15000");
		
		DEPOSIT_SUBMIT = driver.findElement(By.xpath("//button[@class='btn btn-sm btn-primary' ]"));
		DEPOSIT_SUBMIT.click();
		
		
		
		

	}

}
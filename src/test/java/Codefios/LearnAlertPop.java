package Codefios;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlertPop {
	
	WebDriver driver;

	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By USER_PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By USER_SUBMIT_FIELD = By.xpath("//button[@id='login_submit']"); 
	
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

		
		driver.findElement(USER_SUBMIT_FIELD).click();
		
		driver.switchTo().alert().accept();
		

		
		
	
	} 
	

}

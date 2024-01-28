package Codefios;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {

	WebDriver driver;

	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By USER_PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By USER_SUBMIT_FIELD = By.xpath("//button[@id='login_submit']");
	By DASHBOARD_VALIDATION_FIELD = By.xpath("//strong[contains(text(),'Dashboard')]");
	By CUSTOMER_MENU_FIELD = By.xpath("//body[1]/div[1]/aside[1]/div[1]/nav[1]/ul[2]/li[2]/a[1]/span[1]");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//span[contains(text(),'Add Customer')]");
	By ADD_CUSTOMER_VALIDATION_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong");
//	By FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input");

	@Before
	public void init() {  

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Selenium_Practice1\\Assignment\\driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

//	@Test
	public void positiveLoginTest() {

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(USER_PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(USER_SUBMIT_FIELD).click();

		// Assert.assertTrue("Page Not
		// Found",driver.findElement(DASHBOARD_VALIDATION_FIELD).isDisplayed());

		Assert.assertEquals("Expected Page not found", "Dashboard",driver.findElement(DASHBOARD_VALIDATION_FIELD).getText());

	}

	@Test

	public void addcustomer() {

		positiveLoginTest();

		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		Assert.assertEquals("Expected Page Not Found", "New Customer",driver.findElement(ADD_CUSTOMER_VALIDATION_FIELD).getText());

		driver.findElement(By.xpath("//*[@id=\"general_compnay\"]/div[1]/div/input")).sendKeys("Joven Moreno");

		
		
		WebElement dropdownCompany = driver.findElement(By.xpath("//*[@id=\"general_compnay\"]/div[2]/div/select"));

		Select select = new Select(dropdownCompany);

		List<WebElement> actualOptions = select.getOptions();
		
	
		String[] expectedOptions = { "", "rrrtu","rrrtu", "test", "Walgreen" };
		
		Assert.assertEquals(expectedOptions.length, actualOptions.size());
	

		for (int i = 0; i < actualOptions.size(); i++) {
			Assert.assertEquals(expectedOptions[i], actualOptions.get(i).getText());
			System.out.println(expectedOptions[i] + " "+ actualOptions.get(i).getText());
        }

		
	    select.selectByVisibleText("Walgreen");
	    
	    WebElement selectedOption = select.getFirstSelectedOption();
	    Assert.assertEquals("Walgreen", selectedOption.getText());
	    
	    driver.findElement(By.xpath("//*[@id=\"general_compnay\"]/div[3]/div/input")).sendKeys("abc11155@gmail.com");
	    driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("4694690804");
	    driver.findElement(By.xpath("//*[@id=\"general_compnay\"]/div[5]/div/input")).sendKeys("PLano Texas");
	    driver.findElement(By.xpath("//*[@id=\"general_compnay\"]/div[6]/div/input")).sendKeys("Plano");
	    driver.findElement(By.xpath("//*[@id=\"port\"]")).sendKeys("75070");
	    
	    
	    WebElement dropdownCountry = driver.findElement(By.xpath("//*[@id=\"general_compnay\"]/div[8]/div[1]/select"));
	    
        Select select11 = new Select(dropdownCountry);
		
		select11.selectByVisibleText("Algeria");
		
		WebElement selectedOption11 = select11.getFirstSelectedOption();
        Assert.assertEquals("Algeria", selectedOption11.getText());
		

	       
	    
		WebElement dropdownGroup = driver.findElement(By.xpath("//*[@id=\"customer_group\"]"));

		Select select1 = new Select(dropdownGroup);
		
		select1.selectByVisibleText("SDLC");
		
		WebElement selectedOption1 = select1.getFirstSelectedOption();
        Assert.assertEquals("SDLC", selectedOption1.getText());
	    
        driver.findElement(By.xpath("//*[@id=\"save_btn\"]")).click();
        

        driver.findElement(By.linkText("Joven Moreno")).isDisplayed();
	
	    
	    

	}

}

package Codefios;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {
	
	WebDriver driver;

	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void newWindow() throws InterruptedException {
		
	/*	String title1 = driver.getTitle();
		System.out.println(title1);
		
		String window1 = driver.getWindowHandle();
		System.out.println(window1); */
		
		driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]")).sendKeys("selenium");
		driver.findElement(By.xpath("//*[@id=\"ybar-search\"]")).click();
		
	/*	Thread.sleep(10000);
		
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		String window2 = driver.getWindowHandle();
		System.out.println(window2); */
		
		driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[1]/div/div[1]/h3/a")).click();
		
		Set<String> handles = driver.getWindowHandles();
		
		for (String str : handles) {
			// System.out.println(str);
			driver.switchTo().window(str);
			
		}
		
		
		String title3 = driver.getTitle();
		System.out.println(title3);
	
	}

}

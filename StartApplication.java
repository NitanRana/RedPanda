package redPanda;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StartApplication{
	
	WebDriver driver;
	@BeforeClass
	public void startbrowers(){
	
		System.setProperty("webdriver.chrome.driver","C:/Users/Nitan/Desktop/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.imdb.com/chart/top");
	}
	@AfterClass
	public void closing(){
		driver.close();
	}
	
	//Validation Method 
	@Test 
	public void verifyingTitle(){
		String ExpectedTitle = "Top Rated Movies";
		String ActualTiltle = driver.findElement(By.xpath(".//*[@id='main']/div/span/div/div/h1")).getText();
		//System.out.println(ActualTiltle);
		assertEquals(ActualTiltle, ExpectedTitle);
	}	
	
	
}

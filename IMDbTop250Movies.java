package redPanda;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IMDbTop250Movies extends StartApplication{

	@Test
	public void getData(){
	
		
		List<WebElement> movies=driver.findElements(By.xpath(".//*[@id='main']/div/span/div/div/div[3]/table/tbody"));
		for(WebElement TopMovies:movies){
			String s = TopMovies.getText();
			}

	}
}

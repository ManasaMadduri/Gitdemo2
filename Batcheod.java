package project;

import java.awt.Robot;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Batcheod {
	public static void main(String[] args) throws FindFailed, InterruptedException, Exception  {
		String downloadFilepath = "E:\\Closed Loop Optimization\\Batch_9\\Meta file";
	       HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	       chromePrefs.put("profile.default_content_settings.popups", 0);
	       chromePrefs.put("download.default_directory", downloadFilepath);
	       ChromeOptions options = new ChromeOptions();
	       options.setExperimentalOption("prefs", chromePrefs);
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver= new ChromeDriver(options);

			driver.manage().window().maximize();
			
			driver.get("https://data.matr.io/1/projects/5d80e633f405260001c0b60a/batches/5dcef1fe110002c7215b2c94");
			Thread.sleep(2000);
		
		  
		    
		    
			 List<WebElement> docs =driver.findElements(By.xpath("//div[@role='button']"));
				System.out.println(docs.size());
	
			for (int i = 1; i <= docs.size(); i++) 
			{
				
				
	       driver.findElement(By.xpath("(//div[@role='button'])[" + i + "]")).click();
	       driver.findElement(By.xpath("(//span[@class='MuiButton-label'])[4]")).click();
		    
	       Thread.sleep(10000);
		   driver.navigate().back();
	    
			 }
	     
			System.out.println("imdone");
		}	 
	    	 
	    	 
}
		

			
			
		
		

			
	
	
		
		
		



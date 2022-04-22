package project;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.api.robot.desktop.DesktopKeyboard;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

import io.github.bonigarcia.wdm.WebDriverManager;



public class CycledataDownload {

	public static void main(String[] args) throws FindFailed, InterruptedException, AWTException  {
		String downloadFilepath = "E:\\nmccyle";
	       HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	       chromePrefs.put("profile.default_content_settings.popups", 0);
	       chromePrefs.put("download.default_directory", downloadFilepath);
	       ChromeOptions options = new ChromeOptions();
	       options.setExperimentalOption("prefs", chromePrefs);
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver(options);

		driver.manage().window().maximize();
        driver.get("https://www.batteryarchive.org/list.html");
        Actions action = new Actions(driver);
        driver.switchTo().frame(0); 
     
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//i[@aria-label='icon: down'])[3]")).click();
        DesktopKeyboard keyboard = new DesktopKeyboard();
        Screen  s = new Screen();
        for (int i=0;i<5;i++)
          {
          s.type(Key.BACKSPACE);
          }
        keyboard.type("NMC");
        s.type(Key.ENTER);
        driver.findElement(By.xpath("(//i[@aria-label='icon: down'])[3]")).click();
        
        Thread.sleep(2000);
        WebElement click  = driver.findElement(By.xpath("//span[text()=' Apply Changes']"));
        action.moveToElement(click).doubleClick().build().perform();
       
        Thread.sleep(5000);
        
        
    	Robot robot= new Robot(); 
		 robot.setAutoDelay(50);
		 robot.mouseWheel(15); 
		 
		
		 driver.findElement(By.xpath("//li[@title='Next Page']")).click();
		 
		 robot.mouseWheel(-15);
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//td[@class='display-as-link'])[1]/a"))));
		List<WebElement> li = driver.findElements(By.xpath("//td[@class='display-as-link']/a"));

		
		for (int i = 1; i <= li.size(); i++) {

			if (i != 1) {
				driver.switchTo().frame(0);
			}

			String s1 = driver.findElement(By.xpath("(//td[@class='display-as-link'])[" + i + "]/a")).getAttribute("href");
			((JavascriptExecutor) driver).executeScript("window.open()");
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.get(s1);
			Thread.sleep(8000);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Download'])[1]"))));
			driver.findElement(By.xpath("(//a[text()='Download'])[1]")).click();
			driver.close();
			Thread.sleep(2000);
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(4000);
		}
		
	}

}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
              

	
	





	



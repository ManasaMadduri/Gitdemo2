package project;

import java.awt.Robot;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;

import io.github.bonigarcia.wdm.WebDriverManager;

public class next {
	public static void main(String[] args) throws FindFailed, InterruptedException, Exception  {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.switchTo().frame(0);
	 driver.manage().window().maximize();
	 driver.get("https://www.batteryarchive.org/list.html");
	
	 Robot robot= new Robot(); 
	 robot.setAutoDelay(50);
	 robot.mouseWheel(15); 
	 
	 
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//li[@title='Next Page']")).click();
	 
	 robot.mouseWheel(-15); 
	 
	 
	 
	 
	 
	 
	 
//	 WebElement bottomname = driver.findElement(By.xpath("(//td[@class='display-as-link'])[4]"));
//	 JavascriptExecutor js = (JavascriptExecutor) driver;
//	 js.executeScript("window.scrollBy(0,200)", "bottomname"); 
	}

}

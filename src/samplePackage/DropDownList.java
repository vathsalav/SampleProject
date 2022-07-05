package samplePackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownList {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) { 
		 
		
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\master\\eclipse-workspace\\DataDrivenFramework\\src\\test\\resources\\drivers\\chromedriver.exe");
		      WebDriver driver = new ChromeDriver();
		      driver.manage().window().maximize();
		      String baseURL = "http://demo.guru99.com/test/newtours/register.php";
		      driver.get(baseURL);
		      driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		      Select s = new Select(driver.findElement(By.name("country")));
		      // getting the list of options in the dropdown with getOptions()
		      List <WebElement> op = s.getOptions();
		      int size = op.size();
		      for(int i =0; i<size ; i++){
		         String options = op.get(i).getText();
		         System.out.println(options);
		      }
		      driver.quit();
	 }
	 }
	
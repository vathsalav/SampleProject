package samplePackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchBackParentWindowTitle {
	
	
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\master\\eclipse-workspace\\SampleProject\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
        
        driver.findElement(By.xpath("//a[normalize-space()='Company']")).click();
        String mainwindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        
        while (i1.hasNext()) {
            String ChildWindow = i1.next(); 
                if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                WebElement text = driver.findElement(By.id("tocCollapse"));
                System.out.println("Heading of child window is " );
                driver.close();
                System.out.println("Child window closed");
            }
        }    
  
        //  Switch back to the main window which is the parent window.
        driver.switchTo().window(mainwindow);
        driver.quit();
    }

}

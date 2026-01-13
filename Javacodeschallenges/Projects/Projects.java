package Projects;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Projects {public static void main(String[] args) throws InterruptedException, IOException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.xpath("//input[@class='lNPl8b']")).sendKeys("Smartphons",Keys.ENTER);
	Thread.sleep(2000);
	WebElement Totalresult = driver.findElement(By.xpath("//span[@class='_Omnvo']"));
	System.out.println(Totalresult.getText());
	driver.findElement(By.className("buvtMR")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//div[@class='buvtMR'])[3]")).click();
	Thread.sleep(2000);
	WebElement min = driver.findElement(By.className("hbnjE2"));
	Select sel1 = new Select(min);
	sel1.selectByVisibleText("₹15000");
	Thread.sleep(2000);
	WebElement max = driver.findElement(By.xpath("(//select[@class='hbnjE2'])[2]"));
	Select sel2 = new Select(max);
	sel2.selectByContainsVisibleText("₹30000");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[text()='Newest First']")).click();
	Thread.sleep(2000);
	
	WebElement Fproduct = driver.findElement(By.xpath("//div[text()='MOTOROLA g67 power 5G (Pantone Parachute, 128 GB)']"));
	WebElement Price = driver.findElement(By.xpath("(//div[text()='₹16,999'])[1]"));
	System.out.println(Fproduct.getText() + " : " + Price.getText());
	Thread.sleep(5000);
	String oldHandle = driver.getWindowHandle();
	driver.findElement(By.xpath("(//div[@class='RG5Slk'])[1]")).click();	
	Set<String> handles = driver.getWindowHandles();
	for (String h : handles) {
		if (!h.equals(oldHandle)) {
			driver.switchTo().window(h);
			break;
			}
	}
		System.out.println(driver.getTitle());
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
	Thread.sleep(1000);
	WebElement PD = driver.findElement(By.xpath("//span[text()='Price details']"));
	Thread.sleep(1000);
	WebElement AP = driver.findElement(By.xpath("//span[@class='u7129o Mmn1B1']"));
	Thread.sleep(1000);
	WebElement PPF = driver.findElement(By.xpath("//span[text()='₹86']"));
	Thread.sleep(1000);
	WebElement TA = driver.findElement(By.xpath("//span[text()=' ₹17,085']"));
	Thread.sleep(1000);
	
	
	System.out.println(PD.getText() + " : ");
	System.out.println("Actural product price" + " :" + AP.getText() );
	System.out.println("Protect Promise Fee" + " : " + PPF.getText());
	System.out.println("Total Amount" + " : " + TA.getText());
	
	File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	File des = new File("./filpcart1.png");
	FileUtils.copyFile(screenshotAs, des);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[text()='Remove']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[text()='Remove'])[1]")).click();
	Thread.sleep(4000);
	
	File screenshotAs2 = driver.getScreenshotAs(OutputType.FILE);
	File des1 = new File("./filpcart2.png");
	FileUtils.copyFile(screenshotAs2, des1);
	Thread.sleep(1000);
	
	System.out.println("Successfully removed MOTOROLA g67 power 5G (Pantone Parachute, 128 GB) from your cart");
	driver.quit();
	driver.quit();
}
}

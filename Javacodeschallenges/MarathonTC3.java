package Javacodeschallenges;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class MarathonTC3 {public static void main(String[] args) throws InterruptedException, IOException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("guest");
	ChromeDriver driver = new ChromeDriver(option);
	driver.get("https://www.tatacliq.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.id("moe-dontallow_button")).click();
	Thread.sleep(3000);
	WebElement Brands = driver.findElement(By.xpath("//div[text()='Brands']"));
	Thread.sleep(5000);
	Actions act = new Actions(driver);
	act.moveToElement(Brands).perform();
	WebElement watch = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
	act.moveToElement(watch).perform();
	driver.findElement(By.xpath("//div[text()='Casio']")).click();
	Thread.sleep(3000);
	WebElement fliter = driver.findElement(By.className("SelectBoxDesktop__hideSelect"));
	Select sel1 = new Select(fliter);
	sel1.selectByVisibleText("New Arrivals");
	driver.findElement(By.xpath("(//div[text()='Men'])[1]")).click();
	Thread.sleep(3000);
	List<WebElement> prices = driver.findElements(By.xpath("//div[contains(text(),'₹')]"));
	List<String> list = new ArrayList<String>();
	for (WebElement allprices : prices) {
		String text = allprices.getText();
		list.add(text);
	}
	System.out.println(list);
	Thread.sleep(3000);
	String wprices1 =driver.findElement(By.xpath("(//h3[@class='ProductDescription__boldText'])[2]")).getText();
	System.out.println("Home page price" + " : " + " " +"MRP: "+ wprices1);
	driver.findElement(By.xpath("//a[@class='ProductModule__base']")).click();
	Thread.sleep(3000);
	Set<String> windows = driver.getWindowHandles();
	List<String> windowsList = new ArrayList<>(windows);
	driver.switchTo().window(windowsList.get(1));
	String wprices2 = driver.findElement(By.xpath("//h3[text()='MRP:  ₹4495']")).getText();
	System.out.println("cart page price" + " : " + " " + wprices2);
	WebElement cart = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
	act.moveToElement(cart).click().perform();
	Thread.sleep(3000);
	String cartcount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
	System.out.println("CartCount" + ": " + " " +cartcount);
	driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).click();
	driver.quit();
}
}



package Javacodeschallenges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MarathonTC2 {public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for boys",Keys.ENTER);
	String text = driver.findElement(By.xpath("//span[text()='1-48 of over 10,000 results for']")).getText();
	System.out.println("Full Text: " + text + " " + "bags for boys");
	driver.findElement(By.xpath("//span[@class='a-expander-prompt']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
	Thread.sleep(2000);
	String bagname = driver.findElement(By.xpath("(//span[text()='Safari'])[1]")).getText();
	System.out.println(bagname + " : " +"Triplex 37L School bag for Boys and Girls, Office use/travel bag for man & women");
	Thread.sleep(3000);
	String bagprice = driver.findElement(By.xpath("(//span[text()='3,199'])[1]")).getText();
	System.out.println(bagprice);
	Thread.sleep(3000);
	driver.getTitle();
	Thread.sleep(2000);
	driver.close();
}
}
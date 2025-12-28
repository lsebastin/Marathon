package Javacodeschallenges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MarathonTC1 {public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.pvrcinemas.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.xpath("//span[@class='cinemas-inactive']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[contains(text(),'Select Cinema')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[contains(text(),'PVR Sathyam Royapettah Chennai')])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//li[@class='p-dropdown-item']/span)[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//li[@class='p-dropdown-item']/span)[8]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//li[@class='p-dropdown-item'])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//span[@class='p-button-label p-c'])[5]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Accept']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Accept']")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("EL.ELITE|J:8")).click();
	Thread.sleep(4000);
	String seatinfo = driver.findElement(By.xpath("//h6[contains(text(),'Seat Info')]")).getText();
	String M = driver.findElement(By.xpath("//p[text()='J8']")).getText();
	String X = driver.findElement(By.xpath("//p[text()='ELITE']")).getText();
	System.out.println(seatinfo + ":" + " " + M + " " + X);
	String Total = driver.findElement(By.xpath("//div[contains(@class,'grand-prices')]/h6")).getText();
	System.out.println("GREND TOTAL" + " :" + " "+Total);
	
	driver.findElement(By.xpath("//button[@class='sc-bbbBoY kbsOBB btn-proceeded']")).click();
	Thread.sleep(4000);
	driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
	Thread.sleep(4000);
	System.out.println("Page title :" + driver.getTitle());
	driver.close(); 	 	
}
}
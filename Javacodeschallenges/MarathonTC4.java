package Javacodeschallenges;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class MarathonTC4 {public static void main(String[] args) throws InterruptedException, IOException {
	ChromeOptions option = new ChromeOptions();
	option.addArguments("guest");
	ChromeDriver driver = new ChromeDriver(option);
	driver.get("https://dev181504.service-now.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.id("user_name")).sendKeys("admin");
	Thread.sleep(2000);
	driver.findElement(By.id("user_password")).sendKeys("F/*jyM6Q6pHh");
	Thread.sleep(2000);
	driver.findElement(By.id("sysverb_login")).click();
	Thread.sleep(2000);
	Shadow shadow = new Shadow(driver);
	shadow.setImplicitWait(5);
	shadow.findElementByXPath("//div[text()='All']").click();
	shadow.findElementByXPath("//span[text()='Service Catalog']").click();
	
	WebElement is = shadow.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(is);
	driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
	
	driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
	
	driver.findElement(By.xpath("//label[text()='Yes']")).click();
	driver.findElement(By.id("IO:43d5c38a9707011021983d1e6253af8a")).sendKeys("090909909");
	
	WebElement Data = driver.findElement(By.id("IO:33494b069747011021983d1e6253af45"));
	Select sel1 =new Select(Data);
	sel1.selectByIndex(2);
	
	driver.findElement(By.xpath("//label[text()='Blue']")).click();
	driver.findElement(By.xpath("//label[text()='512 GB [add £223.60]']")).click();
	
	
	driver.findElement(By.id("oi_order_now_button")).click();
	
	WebElement req = driver.findElement(By.id("requesturl"));
	System.out.println("request id" + ":" + " "+ req.getText());
	
	
	File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	File des = new File("./serivecnoworder.png");
	FileUtils.copyFile(screenshotAs, des);
	driver.close();
}
}


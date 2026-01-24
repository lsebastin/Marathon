package practiceNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class baseclass {
	public static ChromeDriver driver;
	
	@Parameters({"Url","Uname","pword"})
	@BeforeMethod
	public void percon(String Url,String Uname,String pword) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		driver = new ChromeDriver(option);
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user-name")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.id("login-button")).click();
			
	}
	
	@AfterMethod
	public void postcon() {
		driver.close();
	}
	

}

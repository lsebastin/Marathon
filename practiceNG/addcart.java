package practiceNG;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazon.aexce;

public class addcart  extends baseclass {
	@Parameters()
	@Test(dataProvider = "Fetchdata")
	public void process(String fname,String lname, String pcode) throws InterruptedException {
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[text()='Add to cart'])[1]")).click();
		Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		List<WebElement> descrption = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		for (WebElement products : descrption) {
				System.out.println(products.getText());
		}
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("first-name")).sendKeys(fname);
		Thread.sleep(3000);
		driver.findElement(By.id("last-name")).sendKeys(lname);
		Thread.sleep(3000);
		driver.findElement(By.id("postal-code")).sendKeys(pcode);
		Thread.sleep(3000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		List<String> list = new ArrayList<>();
		for (WebElement allprices : prices) {
			System.out.println(allprices.getText());
		}
		WebElement total = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
		System.out.println(total.getText());
		Thread.sleep(3000);
		WebElement tax = driver.findElement(By.xpath("//div[@class='summary_tax_label']"));
		System.out.println(tax.getText());
		Thread.sleep(3000);
		WebElement allthetotal = driver.findElement(By.xpath("//div[@class='summary_total_label']"));
		System.out.println(allthetotal.getText());
		Thread.sleep(3000);
		WebElement done = driver.findElement(By.id("finish"));
		Actions action = new Actions(driver);
		action.moveToElement(done).click().perform();
		
	}
	
	@DataProvider(name = "Fetchdata")
	public String[][] senddata() throws IOException {
		return excel.data();
		
	}

}

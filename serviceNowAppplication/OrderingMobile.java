package serviceNowAppplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class OrderingMobile extends ServiceNowLoginCredential{
	@Test
	public void runOrderingMobile() {
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[text()='All']").click();
		dom.setImplicitWait(20);
		dom.findElementByXPath("//span[text()='Service Catalog']").click();
		WebElement findElementByXPath = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(findElementByXPath);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		driver.findElement(By.xpath("(//strong[contains(text(),'Apple iPhone')])[1]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
		WebElement drop = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select dropDown = new Select(drop);
		dropDown.selectByValue("Unlimited");		
		driver.findElement(By.xpath("(//label[@class='radio-label'])[4]")).click();
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		String text = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
		if(text.contains("Thank you"))
		{
			System.out.println(text);
		}
		String requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println(requestNumber);

	}

}

package serviceNowAppplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewCaller extends ServiceNowLoginCredential {
	@Test
	public void runCreateNewCaller()
	{
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[@aria-label='All']").click();
		dom.setImplicitWait(20);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Caller");
		dom.setImplicitWait(20);
		dom.findElementByXPath("//mark[text()='Caller']").click();
		WebElement findElementByXPath = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(findElementByXPath);		
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("Kowsalya");
		driver.findElement(By.xpath("//input[@aria-label='Last name']")).sendKeys("Selvakumar");
		driver.findElement(By.xpath("//input[@aria-label='Title']")).sendKeys("Details");
		driver.findElement(By.xpath("//input[@aria-label='Email']")).sendKeys("kowsalyaselvakumar@gmail.com");
		driver.findElement(By.xpath("//input[@aria-label='Business phone']")).sendKeys("8825976636");
		driver.findElement(By.xpath("//input[@aria-label='Mobile phone']")).sendKeys("8825976636");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
	}
}

package serviceNowAppplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CreateNewProposal extends ServiceNowLoginCredential{
	@Test
	public void runCreateNewProposal() throws InterruptedException
	{
	Shadow dom = new Shadow(driver);
	dom.setImplicitWait(30);
	dom.findElementByXPath("//div[@aria-label='All']").click();
	dom.setImplicitWait(20);
	dom.findElementByXPath("//input[@id='filter']").sendKeys("proposal");
	dom.setImplicitWait(30);
	WebElement click=dom.findElementByXPath("//span[@class='item-icon']");
	driver.executeScript("arguments[0].click();", click);
	WebElement findElementByXPath = dom.findElementByXPath("//iframe[@title='Main Content']");
	driver.switchTo().frame(findElementByXPath);
	driver.findElement(By.xpath("//button[text()='New']")).click();
	driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("I am using Service Now application.");
	driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
	String text = driver.findElement(By.xpath("(//td[@class='vt'])[4]")).getText();
	if(text.contains("New"))
	{
		System.out.println("Successfully Created New Proposal");
	}
	else
	{
		System.out.println("Not Created New Proposal");
	}
	}
}
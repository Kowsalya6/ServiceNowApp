package serviceNowAppplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class FillMandatoryFeild extends ServiceNowLoginCredential {
	@Test
	public void runFillMandatoryFeild() throws InterruptedException
	{
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[@aria-label='All']").click();
		dom.setImplicitWait(20);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Knowledge");
		WebElement click = dom.findElementByXPath("//mark[text()='Knowledge']");
		driver.executeScript("arguments[0].click();", click);
		WebElement findElementByXPath = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(findElementByXPath);
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		driver.findElement(By.xpath("//a[text()='IT']")).click();
		driver.switchTo().window(lst.get(0));
		driver.switchTo().frame(findElementByXPath);
		WebElement catagories = driver.findElement(By.xpath("(//div[@class='input-group ref-container']//input)[2]"));
		catagories.sendKeys("java");
		driver.findElement(By.xpath("//td[text()='IT / Java']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Short description']")).sendKeys("Details");
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		
}
}
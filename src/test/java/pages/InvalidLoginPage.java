package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InvalidLoginPage {
	WebDriver driver; 
	private By mailid=By.cssSelector("#email");
	private By pcode=By.xpath("//input[@id='password']");
	private By logbtn=By.cssSelector("input[name='submit']");
	
	public InvalidLoginPage (WebDriver driver) {
		this.driver=driver;
	}
public void invalidlogin() {
	driver.findElement(mailid).sendKeys("sirisha1@gmail.com");
	
	driver.findElement(pcode).sendKeys("sirisha1");
	
	driver.findElement(logbtn).click();
	
}
}

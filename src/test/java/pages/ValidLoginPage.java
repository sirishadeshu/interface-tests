package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ValidLoginPage {
	WebDriver driver;
	
	private By mailid=By.cssSelector("#email");
	private By pcode=By.xpath("//input[@id='password']");
	private By logbtn=By.cssSelector("input[name='submit']");
	
public ValidLoginPage(WebDriver driver) {
	this.driver=driver;
	}
public HomePage login() {
	driver.findElement(mailid).sendKeys("sirisha@gmail.com");
	
	driver.findElement(pcode).sendKeys("sirisha");
	
	driver.findElement(logbtn).click();
	
	return new HomePage(driver);
}
}

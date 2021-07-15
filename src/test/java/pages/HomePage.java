package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	
	private By requestquotation= By.id("ui-id-2");
	private By radioyes=By.xpath("//input[@value='Yes']");
	private By estimated=By.id("quotation_vehicle_attributes_value");
	private By parkloctn=By.cssSelector("#quotation_vehicle_attributes_parkinglocation");
	private By optn=By.xpath("//option[@value='Public place']");
	private By cpbtn=By.xpath("//input[@value='Calculate Premium']");
	private By resetbtn=By.xpath("//input[@value='Reset form']");
	private By logoutbtn=By.xpath("//input[@value='Log out']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	public void cpfeatures() throws InterruptedException {
		//Click on RequestQuotation
		 driver.findElement(requestquotation).click();
		 
		 //Select Yes option in radiobutton
		 driver.findElement(radioyes).click();
		 
		 //Enter 1000 as estimated value 
		 driver.findElement(estimated).sendKeys("1000");
		  
		 //Select public place option from parking location dropdown
		 WebElement parkloc= driver.findElement(parkloctn);
		 parkloc.findElement(optn).click();
		 
		 Assert.assertFalse(parkloc.isSelected());
		 
		 //Click on CalculatePremium 
		  driver.findElement(cpbtn).click();
		  
		  //Click on ResetForm
		  Thread.sleep(3000);
		  driver.findElement(resetbtn).click();
	}
 public boolean isCalculatedPremiumDisplayed() {
	 return  driver.findElement(cpbtn).isDisplayed();
 }
 public boolean isRadioButtonSelected() {
	 return driver.findElement(radioyes).isSelected();
 }
 public ValidLoginPage logOut() {
	 driver.findElement(logoutbtn).click();
	 return new ValidLoginPage(driver);
 }
 public boolean isLogoutDisplayed() {
	 return driver.findElement(logoutbtn).isDisplayed();
 }
}

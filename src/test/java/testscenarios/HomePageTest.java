package testscenarios;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.HomePage;
import pages.ValidLoginPage;

public class HomePageTest {
	WebDriver driver;
	@Test
	public void CalculatePremium() throws InterruptedException {
		System.out.println("CalculatePremium is executed");
		System.setProperty("webdriver.gecko.driver", "C:\\selenium-java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
		
		ValidLoginPage validloginpage= new ValidLoginPage(driver);
		validloginpage.login();
		
		HomePage homepage= new HomePage(driver);
		homepage.cpfeatures();
	
		AssertJUnit.assertTrue(homepage.isCalculatedPremiumDisplayed());
		AssertJUnit.assertFalse(homepage.isRadioButtonSelected());

}
}

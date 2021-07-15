package testscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ValidLoginPage;

public class ValidLoginTest {
	@Test
	public void ValidLogin() {
		System.out.println("ValidLogin executed");
		System.setProperty("webdriver.gecko.driver", "C:\\selenium-java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		 WebDriver driver =new FirefoxDriver();
		
		 driver.get("http://demo.guru99.com/insurance/v1/index.php");
		ValidLoginPage validloginpage= new ValidLoginPage(driver);
		HomePage homepage = validloginpage.login();
		
		Assert.assertTrue(homepage.isLogoutDisplayed());	
		
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Insurance Broker System");
		
	}
}

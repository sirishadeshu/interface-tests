package testscenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.InvalidLoginPage;

public class InvalidLoginTest {
	WebDriver driver;
	@Test
	public void invalidinfo() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium-java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		 WebDriver driver =new FirefoxDriver();
		
		 driver.get("http://demo.guru99.com/insurance/v1/index.php");
		InvalidLoginPage invalidpage= new InvalidLoginPage(driver);
		invalidpage.invalidlogin();
	}

}

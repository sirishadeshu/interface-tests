package insurancetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.InvalidLoginPage;
import pages.ValidLoginPage;

public class InsuranceTest {
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium-java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://demo.guru99.com/insurance/v1/index.php");
	}
	
	@Test
	public void ValidLogin() {	
		ValidLoginPage validlogin= new ValidLoginPage(driver);
		validlogin.login();
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Insurance Broker System");
		
	}
	
	@Test
	public void InvalidLogin() {
		InvalidLoginPage invalidpage= new InvalidLoginPage(driver);
		invalidpage.invalidlogin();	
	}
	
	@Test
	public void CalculatePremium() throws InterruptedException {
		ValidLoginPage validlogin= new ValidLoginPage(driver);
		validlogin.login();
		HomePage homepage= new HomePage(driver);
		homepage.cpfeatures();
}
	@Test
	public void LogInAndOut() {
		ValidLoginPage validloginpage= new ValidLoginPage(driver);
		validloginpage.login();
		HomePage logout= new HomePage(driver);
		logout.logOut();
	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

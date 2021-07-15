import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.InvalidLoginPage;
import pages.ValidLoginPage;

public class ExtentReport {
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;
	@BeforeClass
	
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	test = report.startTest("ExtentReport");
	}
	@Test
	public void ValidReport()
	{
	System.setProperty("webdriver.gecko.driver", "C:\\selenium-java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/insurance/v1/index.php");
	ValidLoginPage validlogin= new ValidLoginPage(driver);
	validlogin.login();
	
	String title = driver.getTitle();
	Assert.assertEquals(title, "Insurance Broker System");
	
	if(driver.getTitle().equals("Insurance Broker System"))
	{
	test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");
	}
	}
	@Test
	public void InvalidReport()
	{
	System.setProperty("webdriver.gecko.driver", "C:\\selenium-java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/insurance/v1/index.php");
	InvalidLoginPage invalidpage= new InvalidLoginPage(driver);
	invalidpage.invalidlogin();	
	if(driver.getTitle().equals("Insurance Broker System"))
	{
	test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");
	}
	}
	@Test
	public void CalculatePremiumReport() throws InterruptedException
	{
	System.setProperty("webdriver.gecko.driver", "C:\\selenium-java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/insurance/v1/index.php");
	ValidLoginPage validlogin= new ValidLoginPage(driver);
	validlogin.login();
	HomePage homepage= new HomePage(driver);
	homepage.cpfeatures();
	
	if(driver.getTitle().equals("Insurance Broker System"))
	{
	test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");
	}
	}
	@Test
	public void LogInOutReport()
	{
	System.setProperty("webdriver.gecko.driver", "C:\\selenium-java\\geckodriver-v0.29.1-win64\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://demo.guru99.com/insurance/v1/index.php");
	ValidLoginPage validloginpage= new ValidLoginPage(driver);
	validloginpage.login();
	HomePage logout= new HomePage(driver);
	logout.logOut();
	if(driver.getTitle().equals("Insurance Broker System"))
	{
	test.log(LogStatus.PASS, "Navigated to the specified URL");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");
	}
	}
	@AfterClass
	public static void endTest()
	{
	WebDriver driver = new FirefoxDriver();
	report.endTest(test);
	report.flush();
	driver.quit();
	}
	}

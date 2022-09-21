package base;

import java.lang.reflect.Method;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import common.CommonFunctions;
import common.CommonWaits;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.SheetsPillowcases;
import objects.HomePageForCategories;
import objects.HomePageToSignIn;
import objects.SignInToYourTargetAccount;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ReadConfigFile;


public class BaseClass {

	public ReadConfigFile readConfigFile = new ReadConfigFile(null);
	WebDriver driver;
	WebDriverWait wait;
	CommonWaits waits;
	ExtentReports extent;

	protected CommonFunctions commons;
	protected HomePageToSignIn homePageToSignIn;
	protected SignInToYourTargetAccount signIn;
	protected HomePageForCategories categories;
	protected SheetsPillowcases sheets;

	@BeforeSuite
	public void initiatingReport() {
		extent = ExtentManager.initiatingReport();
	}

	@BeforeMethod
	public void beforeEachTest(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.creatingTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);

	}

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser1) {
		driver = localDriver(browser1);
		driver.get(readConfigFile.getReadConfigFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(
				Duration.ofSeconds(Integer.parseInt(readConfigFile.getReadConfigFile("pageLoadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(readConfigFile.getReadConfigFile("implicitWait"))));
		wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(readConfigFile.getReadConfigFile("explicitWait"))));
		initClasses();
	}

	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "Test Passed");

		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");

		} else {
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed \n"+ result.getThrowable());
			commons.getScreenshot(method.getName());
		}

	}

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;

	}

	protected WebDriver getDriver() {
		return driver;
	}

	private void initClasses() {

		waits = new CommonWaits(wait);
		commons = new CommonFunctions(driver, waits);
		homePageToSignIn = new HomePageToSignIn(driver, commons);
		signIn = new SignInToYourTargetAccount(driver, commons);
		categories = new HomePageForCategories(driver, commons);
		sheets = new SheetsPillowcases(driver, commons, waits);

	}

	@AfterMethod
	public void terminate() {
		// driver.quit();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}

package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.Commons;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.HomePage;
import objects.SignInToYourTargetAccount;
import utils.ReadConfigFile;

public class BaseClass {

	public ReadConfigFile readConfigFile = new ReadConfigFile(null);
	WebDriver driver;

	protected Commons commons;
	protected HomePage homePage;
	protected SignInToYourTargetAccount signInToYourTargetAccount;

	@BeforeMethod
	public void setUp() {
		driver = localDriver("chrome");
		driver.get(readConfigFile.getReadConfigFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(
				Duration.ofSeconds(Integer.parseInt(readConfigFile.getReadConfigFile("pageLoadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(readConfigFile.getReadConfigFile("implicitWait"))));
		initClasses();
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
		}
		return driver;

	}

	protected WebDriver getDriver() {
		return driver;
	}

	private void initClasses() {
		commons = new Commons();
		homePage = new HomePage(driver, commons);
		signInToYourTargetAccount = new SignInToYourTargetAccount(driver, commons);
	}

	@AfterMethod
	public void terminate() {
		driver.quit();
	}

}

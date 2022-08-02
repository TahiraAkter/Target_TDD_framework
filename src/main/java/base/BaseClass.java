package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadConfigFile;

public class BaseClass {

	public ReadConfigFile readConfigFile = new ReadConfigFile(null);
	WebDriver driver; 

	@BeforeMethod 
	public void setUp() { 
		driver = localDriver("chrome");
		driver.get(readConfigFile.getConfiguration("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(readConfigFile.getConfiguration("pageLoadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(readConfigFile.getConfiguration("implicitWait"))));

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

	public WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void terminate() {
		driver.quit();
	}

}

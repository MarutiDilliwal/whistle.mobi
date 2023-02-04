package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver sdriver ;
	public WebDriver driver;
	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();

	@BeforeClass
	public void launchBrowser() throws IOException, InterruptedException {
		String browser = null;
		browser = fLib.getPropertyValue("Browser");
		System.out.println("Browser name = "+browser);

		String url = null;
		url = fLib.getPropertyValue("Url");
		System.out.println("URL is = "+url);

		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		System.out.println("Browser is successfullly launched");

		driver.get(url);
		Thread.sleep(3000);
		wLib.maximizeTheBrowser(driver);
		Thread.sleep(3000);
		wLib.waitTillPageGetsLoaded(driver);
	}

//	@AfterClass
//	public void closeTheBrowser() {
//		driver.quit();
//		System.out.println("Browser is closed");
//	}
}

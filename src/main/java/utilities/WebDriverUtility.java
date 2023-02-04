package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void maximizeTheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void refreshThePage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardThePage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void backwardThePage(WebDriver driver) {
		driver.navigate().back();
	}

	public void waitTillPageGetsLoaded(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void waitTillElementToBeClicked(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void pageLoadTitle(WebDriver driver,String title) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains(title));
	}

	public void pageLoadUrl(WebDriver driver,String url) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.urlContains(url));
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(0);
	}

	public void switchToFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}

	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void select(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void select(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	public void select(String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void getAllTheOptionsFromTheDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement option : options) {
			String text = option.getText();
			System.out.println(text);
		}
	}

	public void mouseHoverOnElements(WebElement element,WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void enterKeyClick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	public static String takeScreenShot(WebDriver driver,String ScreenShotName) throws IOException {
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Screenshots"+ScreenShotName+".PNG");
		FileUtils.copyFile(source, destination);
		return ScreenShotName;
	}
	public void switchToWindow(WebDriver driver,String actualTitle) {
		Set<String> windows = driver.getWindowHandles();
		for(String window : windows) {
			driver.switchTo().window(window);
			String title = driver.getTitle();
			if(title.contains(actualTitle)) {
				break;
			}
		}
	}
	public void switchToWindow(String actualUrl, WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String currentUrl = driver.getCurrentUrl();
			if(currentUrl.contains(actualUrl)) {
				break;
			}
		}
	}
}

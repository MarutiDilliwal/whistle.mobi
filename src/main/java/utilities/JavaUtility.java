package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.chrome.ChromeOptions;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int num = random.nextInt();
		return num;
	}
	public static void getSystemDate() {  
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		Date date = new Date();  
		System.out.println(formatter.format(date));  
	}

	public void disableBrowserLevelNotifications() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
	}
}

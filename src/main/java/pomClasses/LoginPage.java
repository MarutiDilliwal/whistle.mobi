package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='START CAMPAIGN']")
	private WebElement startCampaignButton;
	
	@FindBy(id="email_id")
	private WebElement emailIdTb;
	
	@FindBy(id="user_pass")
	private WebElement passwordTb;

	public WebElement getStartCampaignButton() {
		return startCampaignButton;
	}

	public WebElement getEmailIdTb() {
		return emailIdTb;
	}

	public WebElement getPasswordTb() {
		return passwordTb;
	}
}

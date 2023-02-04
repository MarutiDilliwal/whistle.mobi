package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainDashBoardPage {

	public MainDashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="smsTab")
	private WebElement smsDashBoardBtn;

	@FindBy(id="company")
	private WebElement dateDropdown;

	@FindBy(id="start_date")
	private WebElement startDateTb;

	@FindBy(id="end_date")
	private WebElement endDateTb;

	@FindBy(xpath="//*[@id=\\\"CampaignData_wrapper\\\"]/div[2]/div[2]/div[1]/div/table/thead/tr/th[19]")
	private WebElement totalClicksBtn;
	
	@FindBy(xpath="//*[@id=\\\"CampaignData_wrapper\\\"]/div[2]/div[3]/div[2]/div/table/tbody/tr[1]/td[2]/a")
	private WebElement brandLinkBtn;

	public WebElement getSmsDashBoardBtn() {
		return smsDashBoardBtn;
	}

	public WebElement getDateDropdown() {
		return dateDropdown;
	}

	public WebElement getStartDateTb() {
		return startDateTb;
	}

	public WebElement getEndDateTb() {
		return endDateTb;
	}

	public WebElement getTotalClicksBtn() {
		return totalClicksBtn;
	}
	
	public WebElement getBrandLinkBtn() {
		return brandLinkBtn;
	}
	
}

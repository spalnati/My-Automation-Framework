package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ProjectOptionsPage {

	public WebDriver driver;
	String selectedProjectName;
	String TransferedProjectName;

	public ProjectOptionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='sub-nav']/ul/li[22]/div/button")
	public static WebElement DropdownToggle;

	@FindBy(how = How.CSS, using = ".transfer-project>a")
	public static WebElement TransferProject;

	@FindBy(how = How.CSS, using = ".btn.dropdown-toggle")
	public static WebElement ShareProject;

	@FindBy(how = How.CSS, using = ".export-project>a")
	public static WebElement ExportProject;

	@FindBy(how = How.CSS, using = ".export-project-all>a")
	public static WebElement ExportProjectAll;

	@FindBy(how = How.CSS, using = ".delete-project>a")
	public static WebElement DeleteProject;

	@FindBy(how = How.CSS, using = ".rename-project>a")
	public static WebElement RenameProject;

	@FindBy(how = How.CSS, using = ".duplicate-project>a")
	public static WebElement DuplicateProject;

	@FindBy(how = How.CSS, using = ".clear-all-filters>a")
	public static WebElement ResetAllFilters;

	@FindBy(how = How.CSS, using = "#duplicateProjectName")
	public static WebElement DuplicateProjectName;

	@FindBy(how = How.CSS, using = ".duplicateBtn")
	public static WebElement ClickonDuplicateButton;

	@FindBy(how = How.CSS, using = "#renameProjectName")
	public static WebElement RenameProjectName;

	@FindBy(how = How.CSS, using = ".renameBtn")
	public static WebElement ClickonRenameButton;

	@FindBy(how = How.CSS, using = "#username")
	public static WebElement TransferUserName;

	@FindBy(how = How.CSS, using = "#partnerid")
	public static WebElement TransferPartnerID;

	@FindBy(how = How.XPATH, using = ".//*[@id='transfer-project-box']/div/div[3]/button[2]")
	public static WebElement ClickonTransferButton;

	@FindBy(how = How.CSS, using = ".okBtn")
	public static WebElement ClickonOKButton;

	@FindBy(how = How.XPATH, using = ".//*[@id='projectList']/li[2]/table/tbody/tr/td[2]")
	public static WebElement selectProjectFromList;

	@FindBy(how = How.CSS, using = ".choose-project-span.swapFontColor")
	public static WebElement selectProject;

	@FindBy(how = How.CSS, using = "#pricesTab>span")
	public static WebElement clickonPriceTab;

	@SuppressWarnings("deprecation")
	public void TransferProject(String UserName, String PartnerID) throws InterruptedException {

		DropdownToggle.click();
		TransferProject.click();
		TransferUserName.sendKeys(UserName);
		TransferPartnerID.sendKeys(PartnerID);
		ClickonTransferButton.click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.top_section.col-xs-12 > span")));
		Assert.assertEquals(driver.findElement(By.cssSelector("span.info_label.highlightable")).getText(),
				"The project has been successfully transfered.");
		driver.findElement(By.cssSelector("button.okBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.info_label.highlightable")).getText());
	}

	public void selectProjectFromList() {
		selectProject.click();
		selectedProjectName = selectProjectFromList.getText();
		System.out.println(selectedProjectName);
		selectProjectFromList.click();
		clickonPriceTab.click();
		
   }
	
   public void addQuotestotheCart(){
	   
	   WebDriverWait wait = new WebDriverWait(driver, 30/* timeOutInSeconds */);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[1]/div[133]/div[3]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[7]/span[1]"))).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 30/* timeOutInSeconds */);
		ExpectedCondition<List<WebElement>> condition1 = ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector((".add-to-cart")));
		List<WebElement> allVisibleCartOptions = wait.until(condition1);
		int NumberOfCartOptions = allVisibleCartOptions.size();
		System.out.println("Items available to add it to Cart: " + NumberOfCartOptions);
		allVisibleCartOptions.get(1).click();
		allVisibleCartOptions.get(2).click();
		allVisibleCartOptions.get(3).click();
	   
	  }

	public void verifyProjectisTransfered() {
		selectProject.click();
		TransferedProjectName = selectProjectFromList.getText();
		if (TransferedProjectName == selectedProjectName) {
			System.out.print("Tranfering a Project Test is a Pass");
		}else{
			System.out.print("Tranfering a Project Test is failed");
		}
	}
	
   public void duplicateProjectinCMP(){
	   final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
	   DropdownToggle.click();
	   DuplicateProject.click();
	   DuplicateProjectName.sendKeys("Project Duplicated on " + sdf.format(date));
	   ClickonDuplicateButton.click();
	   
	   
   }

}

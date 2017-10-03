package pageObjects;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class MarketplaceHomepage {

	public WebDriver driver;
	final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	String floorValue = sdf.format(date);
	// System.out.println(floorValue);

	public MarketplaceHomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "li-projectList")
	public static WebElement ClickonProjectsDropdown;

	@FindBy(how = How.ID, using = "li-new-project")
	public static WebElement CreateNewProject;

	@FindBy(how = How.ID, using = "newProjectName")
	public static WebElement EnterProjectName;

	@FindBy(how = How.XPATH, using = ".//*[@id='new-project-box']/div/div[3]/button[2]")
	public static WebElement ClickonCreateNewProject;

	@FindBy(how = How.XPATH, using = ".//*[@id='projectList']/li[2]/table/tbody/tr/td[2]/span")
	public static WebElement VerifyProject;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[1]/div[2]/input")
	public static WebElement EnterAddress;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[1]/div[2]/span[3]")
	public static WebElement ClickOnAddressbox;

	@FindBy(how = How.XPATH, using = ".//*[@id='productZone']/div[2]/div[1]/div[1]/div/ul[1]/li[2]/span")
	public static WebElement VerifyAddressisAddedtoProject;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[2]/div[2]/button")
	public static WebElement ClickOnGetPrices;

	@FindBy(how = How.XPATH, using = ".//*[@id='productZone']/div[2]/div[1]/div[1]/div/ul[1]/li[1]/span")
	public static WebElement AddressTurnedToBlue;

	@FindBy(how = How.XPATH, using = ".//*[@id='productZone']/div[2]/div[1]/div[1]/div/ul[1]/li[7]/span")
	public static WebElement ClickonLocalFilter;

	@FindBy(how = How.CSS, using = ".address_tab.address_tab_bulk.col-xs-3>span")
	public static WebElement BulkUpload;

	@FindBy(how = How.CSS, using = "#get_file")
	public static WebElement Upload;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[3]/div[9]/div[3]/div[2]/button[2]")
	public static WebElement GetPricesforUpload;

	@FindBy(how = How.CSS, using = ".get-default-prices")
	public static WebElement GetDefaultPricesforUpload;

	@FindBy(how = How.XPATH, using = ".//*[@id='override-all-bulk-filters-box']/div/div[3]/button[1]")
	public static WebElement SayNoToSpecificPrices;

	@FindBy(how = How.XPATH, using = ".//*[@id='override-all-bulk-filters-box']/div/div[3]/button[2]")
	public static WebElement SayYesToSpecificPrices;

	@FindBy(how = How.XPATH, using = ".//input[@name='100 Mbps']")
	public static WebElement SelectBandwidth100Mbps;

	@FindBy(how = How.CSS, using = "#notify-checkbox")
	public static WebElement notifyPricingComplted;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[1]/div[2]/input")
	public static WebElement enteranAddress;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[1]/div[3]/input")
	public static WebElement enteranAddress1;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[1]/div[2]/span[3]")
	public static WebElement findAddress1;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[2]/div[3]/span[3]")
	public static WebElement findP2PAddress1;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[2]/div[4]/span[3]")
	public static WebElement findP2PAddress2;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/ul/li[2]/span")
	public static WebElement clickonP2P;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[2]/div[3]/input")
	public static WebElement enterP2PAddress1;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[2]/div[4]/input")
	public static WebElement enterP2PAddress2;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/ul/li[5]/span/i")
	public static WebElement clickonLONandLAT;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[4]/div[1]/input")
	public static WebElement clickonLatitude;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[1]/div[4]/div[2]/input")
	public static WebElement clickonLongitude;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[2]/div[2]/button")
	public static WebElement getPricesforManualAddress;

	@FindBy(how = How.CSS, using = ".get-default-prices")
	public static WebElement getDefaultPricesforRequest;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[2]/div[2]/button")
	public static WebElement getPricesforP2PAddress;

	@FindBy(how = How.XPATH, using = ".//*[@id='address-box']/div/div[2]/div[3]/button")
	public static WebElement findAddressforLonANDlat;

	@FindBy(how = How.CSS, using = ".toggleCtrl.tglSwColor")
	public static WebElement gotoMAP;

	public void createNewProject() {
		ClickonProjectsDropdown.click();
		CreateNewProject.click();
	}

	public String enterProjectName(String projectName) {
		EnterProjectName.sendKeys(projectName);
		ClickonCreateNewProject.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return projectName;
	}

	public void verifyPartnerName() {
		String projectName = VerifyProject.getText();
		Assert.assertTrue(VerifyProject.getText().equalsIgnoreCase(projectName));
	}

	public void doUploadanImport() throws IOException {
		BulkUpload.click();
		Upload.click();
		Runtime.getRuntime().exec("C:/Users/spalnati/git/BulkUploadConnectMarketPlace/BulkuploadImports/bulkupload.exe");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getPricesforBulkupload() {

		GetPricesforUpload.click();
		GetDefaultPricesforUpload.click();
		SayNoToSpecificPrices.click();

	}

	public void enterRandomFloor() throws InterruptedException {

		final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String floorValue = sdf.format(date);
		System.out.println(floorValue);
		driver.findElement(By.xpath("//div[@id='address-box']/div/div/div[3]/div[9]/div[2]/ul/li/span[3]")).click();
		// driver.findElement(By.id("floor_lvl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("floor_lvl")).sendKeys(floorValue);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.applyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='address-box']/div/div/div[3]/div[9]/div[2]/ul/li[2]/span[3]")).click();
		// driver.findElement(By.id("floor_lvl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("floor_lvl")).sendKeys(floorValue);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.applyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='address-box']/div/div/div[3]/div[9]/div[2]/ul/li[3]/span[3]")).click();
		// driver.findElement(By.id("floor_lvl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("floor_lvl")).sendKeys(floorValue);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.applyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='address-box']/div/div/div[3]/div[9]/div[2]/ul/li[4]/span[3]")).click();
		// driver.findElement(By.id("floor_lvl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("floor_lvl")).sendKeys(floorValue);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.applyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='address-box']/div/div/div[3]/div[9]/div[2]/ul/li[5]/span[3]")).click();
		// driver.findElement(By.id("floor_lvl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("floor_lvl")).sendKeys(floorValue);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.applyBtn")).click();
		Thread.sleep(1000);

	}

	public void checkforPriceCompleteonUI() throws InterruptedException {

		/*
		 * List<WebElement> list = driver.findElements(By.
		 * cssSelector(".product-indicator .icon-address-marker-blue"));
		 * for(WebElement el : list) {
		 */

		WebDriverWait wait = new WebDriverWait(driver, 300/* timeOutInSeconds */);
		ExpectedCondition<List<WebElement>> condition = ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.cssSelector(".product-indicator .icon.icon-address-marker-blue"));
		List<WebElement> allVisibleElements = wait.until(condition);
		int NumberOfPricedItems = allVisibleElements.size();
		Thread.sleep(30000);
		System.out.println("Addresses in the project for Pricing: " + NumberOfPricedItems);
		if (NumberOfPricedItems > 0) {
			System.out.println("Addresses added in the project are getting Completed Pricing by Rapid");
			Thread.sleep(3000);
		} else {
			System.out.println("All Addresses added in the project are not getting Completed Pricing by Rapid. please check the rapid pricing server for any issues");
		}

		//Assert.assertEquals(NumberOfPricedItems, 5);
	}

	public void priceManualAddresses(String address) throws InterruptedException {
		enteranAddress.sendKeys(address);
		Thread.sleep(1000);
		findAddress1.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@id='address-box']/div/div[1]/div[1]/div[2]/span[2]")));
		element.click();
		Thread.sleep(1000);
		driver.findElement(By.id("floor_lvl")).sendKeys(floorValue);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.applyBtn")).click();
		Thread.sleep(1000);
		getPricesforManualAddress.click();
		getDefaultPricesforRequest.click();
		Thread.sleep(60000);
		// gotoMAP.click();

	}

	public void priceP2PAddresses(String address1, String address2) throws InterruptedException {
		clickonP2P.click();
		enterP2PAddress1.sendKeys(address1);
		findP2PAddress1.click();
		enterP2PAddress2.sendKeys(address2);
		findP2PAddress2.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='address-box']/div/div/div[3]/div[9]/div[2]/ul/li/span[3]")).click();
		// driver.findElement(By.id("floor_lvl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("floor_lvl")).sendKeys(floorValue);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.applyBtn")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='address-box']/div/div[1]/div[2]/div[5]/span[2]")).click();
		// driver.findElement(By.id("floor_lvl")).clear();
		Thread.sleep(1000);
		driver.findElement(By.id("floor_lvl")).sendKeys(floorValue);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.applyBtn")).click();
		Thread.sleep(1000);
		getPricesforP2PAddress.click();
		getDefaultPricesforRequest.click();

	}

}

package testPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpers.DataProviderClass;
import junit.framework.Assert;
import pageObjects.CPSHomePage;
import pageObjects.ConnectLoginPage;
import pageObjects.MarketplaceHomepage;
import pageObjects.ProjectOptionsPage;

public class CMPPricingRequestsTest extends BrowserFactory {

	ConnectLoginPage LoginPage = new ConnectLoginPage(driver);
	MarketplaceHomepage MarketPlace = new MarketplaceHomepage(driver);
	CPSHomePage CPS = new CPSHomePage(driver);
	// below code will generate data and time
	Date date = new Date();
	String OriginalProjectName;

	@Test(priority = 0, dataProvider = "CPSAuthentication1", dataProviderClass = DataProviderClass.class)
	public void CMPPricingTest(String user, String pass, String customer) throws IOException {

		CPSHomePage CPS = new CPSHomePage(driver);

		driver.get("http://cps-sqe2.swe.covad.com:17777/cps/");

		CPS.logintoCPS(user, pass);
		// the below code will check for any broken links in the current page
		// LoginPage.checkforBrokenLinks();
		// Navigating to the Connect MarketPlace
		CPS.searchForPartnerinCPS(customer);
		// the below code will check for any broken links in the current page
		// LoginPage.checkforBrokenLinks();
		// the below code will point the driver focus to newly opened browser after user clicked on go connect marketplace link in CPS
		String ParentWindow = driver.getWindowHandle();

		CPS.goToConnectMarketplace();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		CPS.verifyCustomerandDefaultProject(customer);
	}

	@Test(priority = 1, enabled = false)
	public void checkforBrokenLinksinCMP() {
		ConnectLoginPage LoginPage = new ConnectLoginPage(driver);
		LoginPage.checkforBrokenLinks();
	}

	@Test(priority = 2, enabled = false)
	public void createNewProject() {
		MarketplaceHomepage MarketPlace = new MarketplaceHomepage(driver);
		// below code will start creating the new project in CMP and upload an
		// import into the project
		MarketPlace.createNewProject();
		OriginalProjectName = MarketPlace.enterProjectName("Bulk Upload Test on " + date.toString());
		MarketPlace.verifyPartnerName();
	}

	@Test(priority = 3, enabled = false)
	public void priceaManualAddressinCMP() throws InterruptedException {
		MarketplaceHomepage MarketPlace = new MarketplaceHomepage(driver);
		// Requesting a price for manual request in CMP
		MarketPlace.priceManualAddresses("180 n lasalle st chicago il 60606");
	}

	@Test(priority = 4, enabled = false)
	public void priceP2PRequestinCMP() throws InterruptedException {
		MarketplaceHomepage MarketPlace = new MarketplaceHomepage(driver);
		// Requesting a price for P2P request in CMP
		MarketPlace.priceP2PAddresses("350 e cermack rd chicago il", "60 Hudson st New York NY");

	}

	@Test(priority = 5)
	public void selectProjectFromAvailableList() {
		ProjectOptionsPage projectOptions = new ProjectOptionsPage(driver);
		projectOptions.selectProjectFromList();
	}

	@Test(priority = 6)
	public void trasnferProject() throws InterruptedException {
		ProjectOptionsPage projectOptions = new ProjectOptionsPage(driver);
		projectOptions.TransferProject("palnati", "15216");
	}

	
	@SuppressWarnings("deprecation")
	@Test(priority = 7)
	public void checkProjectisTransferedSuccessfully(String username, String password) {
		ConnectLoginPage LoginPage = new ConnectLoginPage(driver);
		ProjectOptionsPage projectOptions = new ProjectOptionsPage(driver);
		driver.get("connect.uat.globalcapacity.com/csp/");
		LoginPage.logintoConnect("palnati", "Welcome#");
		LoginPage.navigateToMarketplace();
		projectOptions.selectProjectFromList();
		Assert.assertEquals(driver.findElement(By.cssSelector("td.td-name > span")).getText(), OriginalProjectName);
		Assert.assertEquals(driver.findElement(By.cssSelector("td.td-addresses > span")).getText(), "1");

	}

	@BeforeTest
	public void setup() throws MalformedURLException {
		launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}

}

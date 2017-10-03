package testPages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
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

public class TransferandSharingaProjectTest extends BrowserFactory {

	ConnectLoginPage LoginPage = new ConnectLoginPage(driver);
	MarketplaceHomepage MarketPlace = new MarketplaceHomepage(driver);
	CPSHomePage CPS = new CPSHomePage(driver);
	// below code will generate data and time
	Date date = new Date();
	
	@Test(priority = 0, dataProvider = "CPSAuthenticationUAT", dataProviderClass = DataProviderClass.class)
	public void TransferProject(String user, String pass, String customer) throws IOException {

		CPSHomePage CPS = new CPSHomePage(driver);

		driver.get("http://cps-sqe2.swe.covad.com:17777/cps/");

		CPS.logintoCPS(user, pass);
		CPS.searchForPartnerinCPS(customer);
		String ParentWindow = driver.getWindowHandle();

		CPS.goToConnectMarketplace();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		CPS.verifyCustomerandDefaultProject(customer);
	}

	@Test(priority = 1)
	public void selectProjectFromAvailableList() throws InterruptedException {
		ProjectOptionsPage projectOptions = new ProjectOptionsPage(driver);
		projectOptions.selectProjectFromList();
		
	 }
	
	@Test(priority = 2)
	public void additemstotheCart(){
		ProjectOptionsPage projectOptions = new ProjectOptionsPage(driver);
		projectOptions.addQuotestotheCart();
		
	}

	@Test(priority = 3)
	public void transferProject() throws InterruptedException {
		ProjectOptionsPage projectOptions = new ProjectOptionsPage(driver);
		projectOptions.TransferProject("palnati", "15216");
	}


	@Test(priority = 4, dataProvider = "Authentication", dataProviderClass = DataProviderClass.class)
	public void checkProjectisTransferedSuccessfully(String user,String pass) {
		ConnectLoginPage LoginPage = new ConnectLoginPage(driver);
		ProjectOptionsPage projectOptions = new ProjectOptionsPage(driver);
		driver.get("http://connect.uat.globalcapacity.com/csp/login");
		LoginPage.logintoConnect(user,pass);
		LoginPage.navigateToMarketplace();
		projectOptions.selectProjectFromList();	
		projectOptions.verifyProjectisTransfered();
		
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

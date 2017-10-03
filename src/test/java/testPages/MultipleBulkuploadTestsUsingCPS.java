package testPages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import helpers.DataProviderClass;
import pageObjects.CPSHomePage;
import pageObjects.ConnectLoginPage;
import pageObjects.MarketplaceHomepage;
import pageObjects.ProjectOptionsPage;

public class MultipleBulkuploadTestsUsingCPS extends BrowserFactory {
	

	
	@Test(dataProvider = "CPSAuthentication", dataProviderClass = DataProviderClass.class)
	public void DailyBulkuploadsTestUsingCPS (String user, String pass, String customer) throws IOException {
		// below code will instantiate the classes from page objects package
		ConnectLoginPage LoginPage = new ConnectLoginPage(driver);
		MarketplaceHomepage MarketPlace = new MarketplaceHomepage(driver);
		CPSHomePage CPS = new CPSHomePage(driver);
		ProjectOptionsPage ProjectOptions = new ProjectOptionsPage(driver);
		//below code will generate data and time
		Date date = new Date();
		
		driver.get("http://cps-sqe2.swe.covad.com:17777/cps/");
	
		CPS.logintoCPS(user, pass);
	
		// the below code will check for any broken links in the current open page
		//LoginPage.checkforBrokenLinks();
		//Navigating to the Connect MarketPlace
		CPS.searchForPartnerinCPS(customer);
		// the below code will check for any broken links in the current open page 
		//LoginPage.checkforBrokenLinks();
		// the below code will point the driver focus to newly opened browser after user clicked on go connect marketplace link in CPS
		String ParentWindow = driver.getWindowHandle();

		CPS.goToConnectMarketplace();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		CPS.verifyCustomerandDefaultProject(customer);
		MarketPlace.createNewProject();
		MarketPlace.enterProjectName("Bulk Upload Test on " + date.toString());
		MarketPlace.verifyPartnerName();
		MarketPlace.doUploadanImport();
		
	}
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		launchBrowser("firefox");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
		driver.quit();
	}

}



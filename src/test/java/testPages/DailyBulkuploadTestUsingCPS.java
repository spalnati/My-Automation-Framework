package testPages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.glass.ui.Size;

import helpers.DataProviderClass;
import pageObjects.CPSHomePage;
import pageObjects.ConnectLoginPage;
import pageObjects.MarketplaceHomepage;
import pageObjects.ProjectOptionsPage;

public class DailyBulkuploadTestUsingCPS extends BrowserFactory {
	

	
	@Test(dataProvider = "CPSAuthenticationProd", dataProviderClass = DataProviderClass.class)
	public void DailyBulkuploadsTestUsingCPS (String user, String pass, String customer) throws IOException {
		// below code will instantiate the classes from page objects package
		MarketplaceHomepage MarketPlace = new MarketplaceHomepage(driver);
		CPSHomePage CPS = new CPSHomePage(driver);
		//below code will generate date and time
		Date date = new Date();
		
		driver.get("http://cps.oss.covad.com:18888/cps/");
		
		CPS.logintoCPS(user, pass);
		CPS.searchForPartnerinCPS(customer);
		// the below code will point the driver focus to newly opened browser after user clicked on go connect marketplace link in CPS
		String ParentWindow = driver.getWindowHandle();
		CPS.goToConnectMarketplace();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		
		CPS.verifyCustomerandDefaultProject(customer);
		// below code will start creating the new project in CMP and upload an import into the project
		MarketPlace.createNewProject();
		MarketPlace.enterProjectName("Bulk Upload Test on " + date.toString());
		MarketPlace.verifyPartnerName();
		MarketPlace.doUploadanImport();
/*		try {
			MarketPlace.enterRandomFloor();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		MarketPlace.getPricesforBulkupload();
	    try {
			MarketPlace.checkforPriceCompleteonUI();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.switchTo().window(ParentWindow);
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



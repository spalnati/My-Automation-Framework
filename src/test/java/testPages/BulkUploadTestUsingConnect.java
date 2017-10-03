package testPages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helpers.DataProviderClass;
import helpers.Log;
import pageObjects.ConnectLoginPage;
import pageObjects.MarketplaceHomepage;

public class BulkUploadTestUsingConnect extends BrowserFactory {
	

	@Test(dataProvider = "Authentication" , dataProviderClass = DataProviderClass.class)
	public void BulkuploadsTestUsingConnect ( String username, String password) throws IOException {
		
		ConnectLoginPage LoginPage = new ConnectLoginPage(driver);
		MarketplaceHomepage MarketPlace = new MarketplaceHomepage(driver);
		Date date = new Date();
		//WebDriver driver;
		//LoginPage.logintoConnect(username, password);
		File file = new File("C:/Users/spalnati/git/BulkUploadConnectMarketPlace/TestConstants.properties");
		FileInputStream dataStream = new FileInputStream(file);
		Properties data = new Properties();
		data.load(dataStream);

		driver.get(data.getProperty("URL"));
		
		LoginPage.logintoConnect(username, password);
		Log.info("User is Logged in");
		// the below code will check for any broken links in connect home page
		LoginPage.checkforBrokenLinks();
		//Navigating to the Connect MarketPlace
		LoginPage.navigateToMarketplace();
		// the below code will check for any broken links in Connect Marketplace home page
		//LoginPage.checkforBrokenLinks();
		// the below code will verify the user logged in 
		LoginPage.verifyUser();
		// below code will start creating the new project in CMP
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
		driver.quit();
	}
	


}

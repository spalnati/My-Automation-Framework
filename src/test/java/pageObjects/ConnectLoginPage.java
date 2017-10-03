
package pageObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import helpers.Log;

public class ConnectLoginPage {

	public WebDriver driver;

	public ConnectLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}


	@FindBy(how=How.ID, using="login")
	public static WebElement username;

	@FindBy(how=How.ID, using="password")
	public static WebElement Password;

	@FindBy(how=How.ID, using="loginbtn")
	public static WebElement signin_button;

	@FindBy(how=How.LINK_TEXT, using="Marketplace")
	public static WebElement click_on_MarketplaceLink;

	@FindBy(how=How.ID, using="li-user")
	public static WebElement verify_UserLoggedin;

	public void logintoConnect(String userName,String password) {
		username.sendKeys(userName);
		Log.info("UserName is Entered");
		Password.sendKeys(password);
		Log.info("Password is Entered");
		signin_button.click();
		Log.info("Clicked on Connect Login button");
	}

	public void navigateToMarketplace() {
		click_on_MarketplaceLink.click();
		Log.info("User is now navigated to ConnectMarketplace");

	}

	public void verifyUser(){
		verify_UserLoggedin.getText().toLowerCase().contains("sankar");
	}

	public void checkforBrokenLinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String url = ele.getAttribute("href");

			verifyLinkActive(url);

		}

	}

	public static void verifyLinkActive(String linkUrl)

	{
		try {
			URL url = new URL(linkUrl);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

			httpURLConnect.setConnectTimeout(3000);

			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);
			}
		} catch (Exception e) {

		}
	}



}

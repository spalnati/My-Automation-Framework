package testPages;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BrowserFactory {

	public static WebDriver driver;

	public static void launchBrowser(String browserName) throws MalformedURLException{
		try {
			if (browserName.equalsIgnoreCase("Firefox")) {

				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("chrome")) {

				System.setProperty("webdriver.chrome.driver",
						"C:/Users/chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("IE")) {

				System.setProperty("webdriver.ie.driver",
						"C:/IEDriverServer.exe");

				driver = new InternetExplorerDriver();
			}

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
 

}


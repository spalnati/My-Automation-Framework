package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CPSHomePage {

	public WebDriver driver;

	public CPSHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how=How.NAME, using="name")
	public static WebElement cpsusername;

	@FindBy(how=How.NAME, using="passwd")
	public static WebElement cpsPassword;

	@FindBy(how=How.NAME, using="submit")
	public static WebElement cpssignin_button;

	@FindBy(how=How.NAME, using="searchText")
	public static WebElement selectPartner;

	@FindBy(how=How.NAME, using="Search")
	public static WebElement cpsPartnerSearch;

	@FindBy(how=How.XPATH, using="/html/body/table[3]/tbody/tr/td[2]/table/tbody/tr/td/a[1]/font")
	public static WebElement clickonSelectedPartner;

	@FindBy(how=How.XPATH, using="/html/body/table[3]/tbody/tr/td[2]/table/tbody/tr/td/div/table/tbody/tr[2]/td[3]/form/font/b/p/input[2]")
	public static WebElement gotoConnectMarketplace;

	@FindBy(how=How.XPATH, using=".//*[@id='li-partnerList']/span[1]")
	public static WebElement verifyCustomerName;

	@FindBy(how=How.CSS, using=".//*[@id='li-projectList']/span[1]")
	public static WebElement checkforDefaultProject;

	public void logintoCPS (String user, String pass){
		//cpsusername.clear();
		cpsusername.sendKeys(user);
		//cpsPassword.clear();
		cpsPassword.sendKeys(pass);
		cpssignin_button.click();

	}
	public void searchForPartnerinCPS(String customer){
		selectPartner.clear();
		selectPartner.sendKeys(customer);
		cpsPartnerSearch.click();
		clickonSelectedPartner.click();
	}
	
	public void goToConnectMarketplace(){
		gotoConnectMarketplace.click();
	}
	
	public void verifyCustomerandDefaultProject(String customer){

		try {
			Assert.assertEquals(customer, verifyCustomerName.getText());
		} catch (Error e) {
			e.printStackTrace();
		}
       }
	
}

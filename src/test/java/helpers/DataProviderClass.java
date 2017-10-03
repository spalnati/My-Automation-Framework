package helpers;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	
	@DataProvider(name = "CPSAuthentication")
	public static String[][] cpscredentials(){
		return new String[][]{{"cps_super", "password1", "Level 3 Communications LLC-LEV001"},
			                 {"cps_super", "password1", "Global Capacity Retail"},
		                     {"cps_super", "password1", "Global Capacity Retail"},
			                 {"cps_super", "password1", "GTT Americas, LLC"},
			                 {"cps_super", "password1", "Sales Support - STD CO Based"},
			                 {"cps_super", "password1", "Airespring, Inc."},
			                 {"cps_super", "password1", "COMLINK"},
			                 {"cps_super", "password1", "Xo Communications"},
			                 {"cps_super", "password1", "Telnes, LLC"},
			                 {"cps_super", "password1", "Tolt Solutions, Inc."}};
	}
	

	@DataProvider(name = "Authentication")
	public static String[][] credentials(){
		return new String[][]{{"palnati", "Welcome#"}};
	}
	
	@DataProvider(name = "CPSAuthenticationProd")
	public static String[][] cpscredentials1(){
		return new String[][] {{"spalnati", "Subhasini123", "Test Customer"}};
	}

	@DataProvider(name = "CPSAuthenticationUAT")
	public static String[][] cpscredentialsuat(){
		return new String[][]{{"cps_super", "password1", "Test Customer"}};
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@DataProvider(name = "BrowserandCPSURL")
	public static String[][] BrowserandCPSURL(){
		return new String[][]{{"chrome","http://cps-sqe2.swe.covad.com:17777/cps/"}, 
			{"firefox","http://cps-sqe2.swe.covad.com:17777/cps/"}};
	}
	

	@DataProvider(name = "BrowserandConnectURL")
	public static String[][] browserandURL(){
		return new String[][]{{"chrome", "http://connect.uat.globalcapacity.com/csp/login"},
			{"firefox", "http://connect.uat.globalcapacity.com/csp/login"}};
	}*/
  
}

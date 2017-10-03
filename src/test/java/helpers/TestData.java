package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestData {
	
	public void getData() throws IOException{
	
	File file = new File("C:/Users/spalnati/Selenium Workspace/ConnectMarkeplaceMain/BulkUploadConnectMarketPlace/TestConstants.properties");
	FileInputStream dataStream = new FileInputStream(file);
	Properties data = new Properties();
	data.load(dataStream);

}

}
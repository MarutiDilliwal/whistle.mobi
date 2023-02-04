package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getPropertyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream("/Users/marutidilliwal/eclipse-workspace/WhistleSupport.mobi/src/test/resources/PropertyFile/Data.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String value = properties.getProperty(key);
		return value;
	}
}

package util;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PropertiesUtil {

	private static Properties properties = new Properties();

	/**
	 * Loads properties from test.properties file
	 */
	public static void loadPropertyFile() {
		try {
			InputStream inputProperties = new FileInputStream(ConstantsUtil.TEST_PROPERTY_FILE_PATH);
			properties.load(inputProperties);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Gets the property from property name
	 */
	public static String getProperty(String propName) {
		loadPropertyFile();
		return properties.getProperty(propName);
	}
}

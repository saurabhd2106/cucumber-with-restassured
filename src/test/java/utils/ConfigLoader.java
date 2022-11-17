package utils;

import java.util.Properties;

public class ConfigLoader {

	private final Properties properties;

	private static ConfigLoader configLoader;

	private ConfigLoader() {
		properties = PropertyUtils.propertyLoader("src/test/resources/config/config.properties");
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getHostname() {
		String prop = properties.getProperty("hostname");

		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property hostname is not specified in the config.properties file");
	}

	public String getPortNumber() {
		String prop = properties.getProperty("portNumber");

		if (prop != null)
			return prop;
		else
			throw new RuntimeException("property portNumber is not specified in the config.properties file");
	}

}

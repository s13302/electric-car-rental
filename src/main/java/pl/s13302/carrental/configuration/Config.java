package pl.s13302.carrental.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    private static final String CONFIG_PATH = "./target/classes/application.properties";
    private static final Properties properties = new Properties();

    public static void loadConfiguration() throws IOException {
        properties.load(Files.newInputStream(Paths.get(CONFIG_PATH)));
    }

    public static String getStringPropertyValue(String propertyName) {
        if (properties.contains(propertyName)) {
            return properties.getProperty(propertyName);
        }
        return null;
    }

    public static Integer getIntegerPropertyValue(String propertyName) {
        String property = getStringPropertyValue(propertyName);
        if (property != null) {
            return Integer.parseInt(property);
        }
        return null;
    }

}

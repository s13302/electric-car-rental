package pl.s13302.carrental.configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Config {

    private static final String CONFIG_FILE = "application.properties";
    private static final Properties properties = new Properties();

    public static void loadConfiguration() throws IOException {
        properties.load(Files.newInputStream(Paths.get(getResourceFile(CONFIG_FILE))));
    }

    public static String getStringPropertyValue(String propertyName) {
        if (properties.containsKey(propertyName)) {
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

    /**
     * Finds absolute path to resource file.
     * @param fileName resource file name
     * @return absolute path to resource
     */
    public static String getResourceFile(String fileName) {
        return Config.class.getClassLoader().getResource(fileName).getPath();
    }

}

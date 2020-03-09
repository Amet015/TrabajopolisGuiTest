package core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverConfig {

    private static DriverConfig instance;
    private static Properties properties;
    private final String INPUT_PATH = "gradle.properties";
    private FileInputStream fileInputStream;
    private static final String BROWSER = "browser";
    private static final String IMPLICIT_WAIT = "implicitWait";
    private static final String EXPLICIT_WAIT = "explicitWait";

    private DriverConfig() {
        initialize();
    }

    public static DriverConfig getInstance() {
        if (instance == null) {
            instance = new DriverConfig();
        }
        return instance;
    }

    private void initialize() {
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream(INPUT_PATH);
            properties.load(fileInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDriver() {
        return properties.getProperty(BROWSER);
    }

    public Long getImplicitWait() {
        return Long.parseLong(properties.getProperty(IMPLICIT_WAIT));
    }

    public Long getExplicitWait() {
        return Long.parseLong(properties.getProperty(EXPLICIT_WAIT));
    }

}

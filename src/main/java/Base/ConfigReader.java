package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/main/resources/config/config.properties");
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL(String newUrl) {
        return properties.getProperty(newUrl);
    }
}

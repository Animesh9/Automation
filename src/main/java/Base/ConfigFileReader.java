package Base;

import Enums.FileEnum;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public final String systemDir = System.getProperty("user.dir");
    public final String resourcesDir = "/src/main/resources/documents/";

    public Properties loadPropertyFiles() {

        Properties prop = new Properties();

        try {
            prop.load(new FileReader(
                    new File(FileEnum.SELENIUM_PROPERTIES_FILE.getFilename())));
            prop.load(new FileReader(
                    new File(FileEnum.ENV_PROPERTIES.getFilename())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public String getAbsoluteFilePath(String fileName) {
        return systemDir.concat(resourcesDir).concat(fileName);
    }
}
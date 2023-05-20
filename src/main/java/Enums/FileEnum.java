package Enums;

public enum FileEnum {

    SELENIUM_PROPERTIES_FILE(
            "src/main/resources/config/selenium.properties"),
    ENV_PROPERTIES(
            "src/main/resources/config/database.properties");

    private final String filename;

    FileEnum(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
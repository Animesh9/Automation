package Enums;

public enum Platform {

    DESKTOP("Desktop"),

    ANDROID("Android"),

    IOS("Ios"),

    MSITE("M-site");

    private final String platformName;

    Platform(String platformName) {

        this.platformName = platformName;
    }

    public String getPlatformName() {

        return platformName;
    }
}

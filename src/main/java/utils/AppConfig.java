package utils;

import java.util.ResourceBundle;

public class AppConfig {
    private static final String APP_PROPERTIES = "app";
    private static final String LOGIN_URL = "login.url";
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(APP_PROPERTIES);

    public static String getAppLoginUrl(){
        return resourceBundle.getString(LOGIN_URL);
    }
}

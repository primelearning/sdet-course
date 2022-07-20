package Utilities;

import java.util.Properties;

public final class LoadConfig {
    private LoadConfig(){

    }
    public static Properties FRAMEWORK_PROPERTIES;
    public static  Properties ENVIRONMENT_PROPERTIES;

    static {
        FRAMEWORK_PROPERTIES=ReadFiles.readProperties("src/main/resources/FrameworkProperties.properties");
        ENVIRONMENT_PROPERTIES=ReadFiles.readProperties("src/main/resources/EnvironmentVariables.Properties");
    }


}

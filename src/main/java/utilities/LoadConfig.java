package utilities;

import java.util.Properties;

public class LoadConfig {
    private LoadConfig(){}
    public static Properties FRAMEWORK_PROPERTIES;
    public static Properties ENV_PROPERTIES;

    static {
        System.out.println("**** Loading properties files");
        FRAMEWORK_PROPERTIES = ReadFiles.readProperties("src/main/resources/frameworkconfig.properties");
        ENV_PROPERTIES = ReadFiles.readProperties("src/main/resources/qa.properties");
    }



}

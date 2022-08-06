package configurations;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.ReadFiles;

import java.util.Objects;
import java.util.Properties;

public final class ConfigManager {
    private static Logger LOG = LogManager.getLogger(ConfigManager.class);
    private ConfigManager(){}
    public static Properties FRAMEWORK_PROPERTIES;
    public static Properties ENV_PROPERTIES;
    public static String ENV;
    public static String BROWSER_NAME;
    public static boolean IS_HEADLESS;

    static {

        FRAMEWORK_PROPERTIES = ReadFiles.readProperties("src/main/resources/frameworkconfig.properties");
        LOG.info("Framework properties loaded.");

        getSystemVariables();
        setEnvProperties();

        if(ConfigManager.FRAMEWORK_PROPERTIES.getProperty("REQUEST_RESPONSE_LOG").equals("true")){
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
    }

    private static void getSystemVariables(){
        if(Objects.nonNull(System.getProperty("ENV"))){
            ENV=System.getProperty("ENV");
            LOG.info("ENV value is set from Environment Variables.");
        }else {
            ENV=FRAMEWORK_PROPERTIES.getProperty("ENV");
            LOG.info("ENV value is set from frameworkconfig.properties.");
        }

        if(Objects.nonNull(System.getProperty("BROWSER_NAME"))){
            BROWSER_NAME=System.getProperty("BROWSER_NAME");
            LOG.info("BROWSER_NAME value is set from Environment Variables.");
        }else {
            BROWSER_NAME=FRAMEWORK_PROPERTIES.getProperty("BROWSER_NAME");
            LOG.info("BROWSER_NAME value is set from frameworkconfig.properties.");
        }

        if(Objects.nonNull(System.getProperty("IS_HEADLESS"))){
            IS_HEADLESS=Boolean.parseBoolean(System.getProperty("IS_HEADLESS"));
            LOG.info("IS_HEADLESS value is set from Environment Variables.");
        }else {
            IS_HEADLESS=Boolean.parseBoolean(FRAMEWORK_PROPERTIES.getProperty("IS_HEADLESS"));
            LOG.info("IS_HEADLESS value is set from frameworkconfig.properties.");
        }
    }

    private static void setEnvProperties(){
        if (ENV.equalsIgnoreCase("QA")){
            ENV_PROPERTIES = ReadFiles.readProperties("src/main/resources/qa.properties");
            LOG.info("QA Environment properties loaded");
        } else if (ENV.equalsIgnoreCase("DEV")) {
            ENV_PROPERTIES = ReadFiles.readProperties("src/main/resources/dev.properties");
            LOG.info("DEV Environment properties loaded");
        } else if (ENV.equalsIgnoreCase("PROD")) {
            ENV_PROPERTIES = ReadFiles.readProperties("src/main/resources/prod.properties");
            LOG.info("PROD Environment properties loaded");
        }else {
            throw new RuntimeException("Invalid Environment selected. Check frameworkconfig.properties");
        }

    }


}

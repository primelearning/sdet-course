package utilities;

import factory.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public final class ConfigManager {
    private static Logger LOG = LogManager.getLogger(BrowserFactory.class);
    private ConfigManager(){}
    public static Properties FRAMEWORK_PROPERTIES;
    public static Properties ENV_PROPERTIES;

    static {

        LOG.info("**** Loading framework properties files");
        FRAMEWORK_PROPERTIES = ReadFiles.readProperties("src/main/resources/frameworkconfig.properties");
        LOG.info("**** Loading environment properties files");
        ENV_PROPERTIES = ReadFiles.readProperties("src/main/resources/qa.properties");
    }



}

package utilities;

import factory.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

public class ReadFiles {

    private static Logger LOG = LogManager.getLogger(BrowserFactory.class);
    private ReadFiles(){}

    public static Properties readProperties(String filepath)  {

        Properties properties = new Properties();
        FileReader fileReader;
        try {
             fileReader = new FileReader(filepath);
            LOG.info("Reading properties file.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader reader = new BufferedReader(fileReader);

        try {
            properties.load(reader);
            LOG.info("Loading properties file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;

    }

}

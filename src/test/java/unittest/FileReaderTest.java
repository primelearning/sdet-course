package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.LoadConfig;
import utilities.ReadFiles;


import java.io.FileReader;
import java.util.Properties;

public class FileReaderTest {

    @Test
    public void testPropertiesFile(){
        System.out.println(LoadConfig.FRAMEWORK_PROPERTIES.get("BASE_URL"));
//        Assert.assertNotNull(properties);
    }
    @Test
    public void testPropertiesFileForEnv(){
        System.out.println(LoadConfig.ENV_PROPERTIES.get("USERNAME"));
//        Assert.assertNotNull(properties);
    }



}

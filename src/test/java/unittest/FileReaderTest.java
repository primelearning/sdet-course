package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigManager;

public class FileReaderTest {

    @Test
    public void testPropertiesFile(){
        Assert.assertEquals(ConfigManager.FRAMEWORK_PROPERTIES.get("BASE_URL"),"https://www.saucedemo.com/");
    }
    @Test
    public void testPropertiesFileForEnv(){
        Assert.assertNotNull(ConfigManager.ENV_PROPERTIES.get("USERNAME"),"standard_user");
    }



}

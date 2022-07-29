package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import configurations.ConfigManager;

public class FileReaderTest {

    @Test
    public void testPropertiesFile(){
        Assert.assertNotNull(ConfigManager.FRAMEWORK_PROPERTIES.get("ENV"));
    }
    @Test
    public void testPropertiesFileForEnv(){
        Assert.assertNotNull(ConfigManager.ENV_PROPERTIES.get("USERNAME"));
    }



}

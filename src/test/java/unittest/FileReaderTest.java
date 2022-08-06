package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import configurations.ConfigManager;
import utilities.JsonUtil;
import utilities.ReadFiles;

import java.io.IOException;

public class FileReaderTest {

    @Test
    public void testPropertiesFile(){
        Assert.assertNotNull(ConfigManager.FRAMEWORK_PROPERTIES.get("ENV"));
    }
    @Test
    public void testPropertiesFileForEnv(){
        Assert.assertNotNull(ConfigManager.ENV_PROPERTIES.get("USERNAME"));
    }

    @Test
    public void testJsonReader()  {
        JsonUtil.updateValue("src/test/resources/booking/createBookingRequest.json","_firstname_","Avishek_updated");
    }

}

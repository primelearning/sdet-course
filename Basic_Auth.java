//import static org.testng.Assert.assertEquals;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;






public class Basic_Auth {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/magizh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		// handling page loading alert:
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        
        WebElement el = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p"));
        
        
      //get test from element and stored in text variable
      String text = el.getText();

      //assert text from expected
      //Assert.assertEquals("Element Text", text);
	
		
	}

}

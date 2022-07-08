import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Broken_Images {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/magizh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/broken_images");
		List<WebElement> image_list = driver.findElements(By.tagName("img"));
		
		 Integer BrokenImageCount = 0;
		 BrokenImageCount = 0;
        
         /* Print the total number of images on the page */
         System.out.println("The page under test has " + image_list.size() + " images");
         for (WebElement img : image_list)
         {
             if (img != null)
             {
            	 if (img.getAttribute("naturalWidth").equals("0"))
                 {
                    // System.out.println(img.getAttribute("outerHTML") + " is broken.");
                     BrokenImageCount++;
                 }
            	/* else {
            		 System.out.println("failed");
            	 }*/           	 
         }
            
         }
         System.out.println("The page has " + BrokenImageCount + " broken images");
	
	}
}


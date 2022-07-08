import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/magizh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/checkboxes");
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]")).click();
		List<WebElement> checkboxElements = driver.findElements(By.cssSelector("#checkboxes input[type='checkbox']"));
		System.out.println("no of checkboxes are : "+checkboxElements.size());
		for(WebElement checkbox:checkboxElements) {
			System.out.println("is Checkboxes selected : "+checkbox.isSelected());
			if(!checkbox.isSelected()) {
				checkbox.click();
			}
	}

}
}
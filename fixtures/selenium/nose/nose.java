package nose;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;


public class nose {
	
	public void selectElements() {
		WebDriver driver = new FirefoxDriver();
		driver.get("../page.html");
		
		((JavascriptExecutor) driver).executeScript("alert('hello world');");
		
		driver.quit();	
	}
}
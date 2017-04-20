package selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Selectors {
	
	public void selectElements() {
		WebDriver driver = new FirefoxDriver();
		driver.get("selectors.html");
		
		WebElement nameInput1 = driver.findElement(By.id("name"));
		WebElement nameInput2 = driver.findElement(By.className("email"));
		WebElement form1 = driver.findElement(By.name("subscribe"));
		WebElement form2 = driver.findElement(By.tagName("form"));
		WebElement emailInput = driver.findElement(By.cssSelector("input.email"));
		WebElement link = driver.findElement(By.linkText("Example 1"));
		WebElement nameInput3 = driver.findElement(By.xpath("html/body/div/form/input"));
		
		driver.quit();	
	}
}
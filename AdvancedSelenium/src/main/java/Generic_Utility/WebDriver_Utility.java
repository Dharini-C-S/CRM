package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility {

	public void maximizeBrowser(WebDriver driver) {
		/**
		 * This method maximizes the browser
		 * @author Dharini C S
		 */
		driver.manage().window().maximize();
	}
	
	public void waitElementsToLoad(WebDriver driver) {
		/**
		 * This method waits for web elements to load 
		 * @author Dharini C S
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	}
	
	public void switchingDriverContol(WebDriver driver, String partialURL) {
		/**
		 * This method is used to switch the driver control
		 * @author Dharini C S
		 */
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext()) {
			String win = it.next();
			
			driver.switchTo().window(win);
			
			String actualTitle = driver.getTitle();
			
			if(actualTitle.contains(partialURL)) {
				break;
			}
		}
	}
	
	public void selectingDropDown ( WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void moveToElementMouseAction(WebDriver driver , WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
	}
	
	public void switchingDriverControlToAlertandAccept(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void dynamicXpath(WebDriver driver,String text)
	{
		driver.findElement(By.xpath("//a[text()='" + text + "']")).click();

	}

}

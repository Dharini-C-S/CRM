package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerContact {
	 
	public VtigerContact(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[alt='Create Contact...']")
	private WebElement createContactIcon;
	
	/**
	 * This method clicks create Contact icon
	 * @param driver
	 */
	public void clickCreateContactIcon(WebDriver driver) {
		createContactIcon.click();
	}	

}

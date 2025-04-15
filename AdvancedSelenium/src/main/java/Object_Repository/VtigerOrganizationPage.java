package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerOrganizationPage {
	 public VtigerOrganizationPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(css  ="img[alt='Create Organization...']")
	 private WebElement createOrganization;
	 
	 public void createOrganization(WebDriver driver) {
		 createOrganization.click();
	 }
	 
	 
	 
	 
}

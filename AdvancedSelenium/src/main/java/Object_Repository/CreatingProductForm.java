package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingProductForm {

	public CreatingProductForm( WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name  = "productname")
	private WebElement productNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(id = "dtlview_Product Name")
	private WebElement verficationMsg;

	public WebElement getProductNameTextField() {
		return productNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getVerficationMsg() {
		return verficationMsg;
	}

	/**
	 * This method is used to create product 
	 * @param productName
	 * @author dharini c s
	 */
	public void createProduct(String productName) {
		productNameTextField.sendKeys(productName);
//		saveButton.click();
	}
	
	/**
	 * This method will click save button
	 * @param driver
	 */
	public void clickSaveButton(WebDriver driver) {
		saveButton.click();
	}
	
	/**
	 * This method will verify the creation of product
	 * @param driver
	 * @param productName
	 */
	public String verifyCreationOfProduct(WebDriver driver, String productName) {
		
		String verProduct = verficationMsg.getText();
//		if(verProduct.contains(productName)) {
//			System.out.println("Product "+productName+" inserted successfully");
//		}
//		else {
//			System.out.println("Product not added...failed");
//		}
		return verProduct;

	}
}

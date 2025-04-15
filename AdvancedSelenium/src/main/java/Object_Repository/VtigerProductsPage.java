package Object_Repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.WebDriver_Utility;

public class VtigerProductsPage {
	
	public VtigerProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="img[alt='Create Product...']")
	private WebElement createProductButton;
	
	@FindBy(id = "bas_searchfield")
	private WebElement dropDown;
	
	@FindBy(name ="submit")
	private WebElement searchNowButton;
	
	
	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//a[@title='Products']")
	private List<WebElement> productList;
	
	@FindBy(name ="search_text")
	private WebElement searchTextField;
	
	public WebElement getSearchText() {
		return searchTextField;
	}


	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public List<WebElement> getProductList() {
		return productList;
	}

	public WebElement getSubmitButton() {
		return searchNowButton;
	}

	public WebElement getCreateProductButton() {
		return createProductButton;
	}
	
	public WebElement getSearchTextField() {
		return dropDown;
	}
	/**
	 * This method is used to search the product and delete the product
	 * @param productName
	 * @author dharini c s
	 */
	public void deleteTheProduct( WebDriver driver) {
		
	deleteButton.click();
		
	}
	
	/**
	 * This method will click create product icon
	 * @param driver
	 */
	public void clickCreateProductIcon(WebDriver driver) {
		createProductButton.click();

	}
	
	/**
	 * This method provides dynamic xpath for checking the check box
	 * @param driver
	 * @param productName
	 */
	public void dynamicXpathToClickCheckBox(WebDriver driver , String productName) {
		driver.findElement(By.xpath("//a[text()='"+productName+"' and @title='Products']/../..//input[@name='selected_id']")).click();
	}
	
	/**
	 * This method will search for the product
	 * @param driver
	 * @param productName
	 */
	public void searchForProduct(WebDriver driver, String productName) {
		
		WebDriver_Utility wUtility = new WebDriver_Utility();
		wUtility.selectingDropDown(dropDown, "productname");
		
		searchTextField.sendKeys(productName);
		searchNowButton.click();
	}
	
	/**
	 * This method will verify deletion of Product
	 * @param driver
	 * @param productName
	 */
	public void verifyDeletionOfProduct(WebDriver driver, String productName) {
		boolean productFound =false ;
		
		for(int i=0; i<productList.size();i++) {
			
			if((productList.get(i).getText()).equals(productName)) {
			System.out.println("Product is not deleted");
				productFound=true;
				break;
			}
		}
		
		if(!productFound)
		{
			System.out.println("Product " + productName + " deleted successfully");
		}
		
	}
	
}

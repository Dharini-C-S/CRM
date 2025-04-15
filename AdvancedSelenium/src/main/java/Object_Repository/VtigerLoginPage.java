package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerLoginPage {

	public VtigerLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="user_name")
	private WebElement UsernameTextField;
	
	@FindBy(name ="user_password")
	private WebElement PasswordTextField;
	
	@FindBy (id="submitButton")
	private WebElement LoginButton;

	public WebElement getUsernameTextField() {
		return UsernameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}

	 public void loginToVTigerApplication(String username , String password) {
		 UsernameTextField.sendKeys(username);
		 PasswordTextField.sendKeys(password);
		 LoginButton.click();
	 }

	
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginPage extends basePage {
	
	public loginPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	@FindBy(id="username") WebElement username;
	@FindBy(how=How.NAME,using="password") WebElement password;
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Log In']") WebElement login_button;
	
	public void enterUserName(String uname) {
			username.sendKeys(uname);
	}
	public void enterpassword(String usrpass) {
		password.sendKeys(usrpass);
	}
	public void clickLoginButton() {
		login_button.click();
	}
}
	



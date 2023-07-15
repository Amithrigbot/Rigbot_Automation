package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class homePage extends basePage{
	
	public homePage(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@FindBy(xpath = "//a[contains(@aria-label,'Loads')]") WebElement Load_button;
	@FindBy(how=How.XPATH,using= "//button[@class='btn btn-consolidation-view']") WebElement new_Load_button;

	
	
	public void clickLoadButton() {
		Load_button.click();
	}
	
	public void clickNewLoadbutton() {
		new_Load_button.click();
	}
	
}


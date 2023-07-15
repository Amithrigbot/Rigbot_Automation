package testCases;

import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loadCreationPage;
import testBase.BaseClass;

public class RB_Testing extends BaseClass {
	
	@Test
	public void justTest() throws InterruptedException {
		homePage hp=new homePage(driver);
		logger.info("Clicked Load button");
		hp.clickLoadButton();
		logger.info("Clicked Newload button");
		hp.clickNewLoadbutton();
		
		loadCreationPage lc= new loadCreationPage(driver);
		lc.setShipperDetails("Dwhite pastures");
		String setPickupDateType="Between";
		if(setPickupDateType.equals("On")) {
			lc.setPickupOnDate("07/03/2023");
		}
		else{
			lc.setPickupBetweeenDate("07/03/2023", "07/04/2023");
		}
	}
	
	

}

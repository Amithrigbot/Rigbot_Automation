package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loadCreationPage;
import testBase.BaseClass;

public class RB_loadcreationtest_001 extends BaseClass {
	
	@Test
	public void test_loadCreation() throws InterruptedException {
		
		logger.info("******Starting RB_loadcreationtest_001 Test*******");
		try {
			
		homePage hp=new homePage(driver);
		logger.info("Clicked Load button");
		hp.clickLoadButton();
		logger.info("Clicked Newload button");
		hp.clickNewLoadbutton();
		
		loadCreationPage lc= new loadCreationPage(driver);
		logger.info("Providing load details");
		String orderNum="3799cmd1";
		lc.setOrderNumber(orderNum);
		lc.selectC_Bdropdown("customerB");
		lc.selectEquipmentType("48' Reefer");
		lc.selectTagNmae("Fragile");
		lc.selectLoadType("Palle");
		
		lc.setRateValue("30");
		lc.setUnitValue("4");
		lc.setPDValue("15");
		lc.setFSCValue("49");
		
		lc.setShipperDetails("Dwhite pastures");
		String setPickupDateType="On";
		if(setPickupDateType.equals("On")) {
			lc.setPickupOnDate("07/03/2023");
		}
		else{
			lc.setPickupBetweeenDate("07/03/2023", "07/04/2023");
		}
		String PickupTimeType="AT";
		if(PickupTimeType.equals("Between")) {
			lc.setPickupBetweeenTime("", "");
		}
		else {
			lc.setPickupTime(PickupTimeType, "12:00 P");
		}
		
		lc.setConsigneeDetails("Adam Shipper");
		String setDropoffDateType="On";
		if(setDropoffDateType=="On") {
			lc.setDropoffOnDate("07/05/2023");
		}
		else {
			lc.setDropoffBetweeenDate("", "");
		}
		String DropoffTimeType="Between";
		if(DropoffTimeType=="Between") {
			lc.setDropoffBetweeenTime("12:00 P", "01:00 P");
		}
		else {
			lc.setDropoffTime(DropoffTimeType,"");
		}
		
		logger.info("Clicked Save button");
		lc.clickSaveButton();
		
		lc.clickRefreshButton();
		
		String confNum=lc.getcomformationNum();
		Assert.assertEquals(confNum, orderNum,"Test Failed");
		
		}catch(Exception e) {
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("******Finished RB_loadcreationtest_001 Test*******");

}
}

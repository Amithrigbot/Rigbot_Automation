package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loadCreationPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class RB_loadcreationDDT_002 extends BaseClass {
	
	
	
	
	@Test(dataProvider="LoadData",dataProviderClass=DataProviders.class)
	public void test_loadDDT(String ordernum,String C_D,String Etype,String Tagname,String loadtype,String Rate,String Unit,String PD,String FCS,String Shipper,String Pdatetype,String Pondate,String PBdate1,String PBdate2,String Ptimetype,String Ptime,String PBtime1,String PBtime2,String Consignee,String Ddatetype,String Dondate,String DBdate1,String DBdate2,String Dtimetype,String Dtime,String DBtime1,String DBtime2,String Status) throws InterruptedException, IOException 
	{

		logger.info("**** Starting RB_loadcreationDDT_002 ****");
		try {
		homePage hp=new homePage(driver);
		logger.info("Clicked Load button");
		hp.clickLoadButton();
		logger.info("Clicked Newload button");
		hp.clickNewLoadbutton();
		
		loadCreationPage lc= new loadCreationPage(driver);
		logger.info("Providing load details");
		
		String orderNum=ordernum;
		lc.setOrderNumber(orderNum);
		lc.selectC_Bdropdown(C_D);
		lc.selectEquipmentType(Etype);
		lc.selectTagNmae(Tagname);
		lc.selectLoadType(loadtype);
		
		lc.setRateValue(Rate);
		lc.setUnitValue(Unit);
		lc.setPDValue(PD);
		lc.setFSCValue(FCS);
		
		lc.setShipperDetails(Shipper);
		String PickupDateType=Pdatetype;
		if(PickupDateType.equals("On")) 
		{
			lc.setPickupOnDate(Pondate);
		}
		else{
			lc.setPickupBetweeenDate(PBdate1, PBdate2);
		}
		String PickupTimeType=Ptimetype;
		if(PickupTimeType.equals("Between")) {
			lc.setPickupBetweeenTime(PBtime1, PBtime2);
		}
		else {
			lc.setPickupTime(PickupTimeType, Ptime);
		}
		
		lc.setConsigneeDetails(Consignee);
		String setDropoffDateType=Ddatetype;
		if(setDropoffDateType.equals("On")) {
			lc.setDropoffOnDate(Dondate);
		}
		else {
			lc.setDropoffBetweeenDate(DBdate1, DBdate2);
		}
		String DropoffTimeType=Dtimetype;
		if(DropoffTimeType=="Between") {
			lc.setDropoffBetweeenTime(DBtime1, DBtime2);
		}
		else {
			lc.setDropoffTime(DropoffTimeType,Dtime);
		}
		
		logger.info("Clicked Save button");
		lc.clickSaveButton();
		
		lc.clickRefreshButton();
		
		boolean result=lc.isOrdernumExists();
		
		if(Status.equals("Valid")) 
		{
			if(result==true) 
			{
				Assert.assertTrue(true);
			}
			else 
			{
				Assert.assertTrue(false);
			}
		}
		if(Status.equals("Invalid")) 
		{
			if(result==true) 
			{
				Assert.assertTrue(false);
			}
			else 
			{
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("**** Finished RB_loadcreationDDT_002 ****");
		
	}

}

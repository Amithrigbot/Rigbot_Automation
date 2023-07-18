package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class loadCreationPage extends basePage {
	
	public loadCreationPage(WebDriver driver) {
		super(driver);
		
	}
	Actions actions = new Actions(driver);
	JavascriptExecutor js=(JavascriptExecutor)driver;
    @FindBy(id = "orderNumber") WebElement orderNumber_Input;
    @FindBy(xpath = "//span[normalize-space()='Select']") WebElement C_B_dropDown_Button;
    @FindBy(xpath = "//input[@class='p-dropdown-filter p-inputtext p-component']") WebElement C_B_dropdown_input;
    @FindBy(xpath = "//ul[@role='listbox']//li") WebElement C_B_dropdown_List;
    @FindBy(xpath = "//div[@aria-label='Equipment Type']") WebElement equipmentType_Button;
    @FindBy(xpath = "//ul[@role='listbox']//li") List<WebElement> equipmentType_List;
    @FindBy(xpath = "//input[@id='tagName']") WebElement addTag_Input;
   //Rates
    @FindBy(xpath = "//div[@aria-label='Type']") WebElement typeDropdown_Button;
   @FindBy(xpath = "//ul[@role='listbox']//li") List<WebElement> typeDropdown_List;
    @FindBy(xpath = "//input[@placeholder='Rate']") WebElement Rate_Input;
    @FindBy(xpath = "//input[@placeholder='Unit']") WebElement Unit_Input;
    @FindBy(xpath = "//input[@placeholder='P/D s']") WebElement PD_Input;
    @FindBy(xpath = "//span[@id='fsc']//input[@placeholder='Enter']") WebElement FSC_input;
    
    //Pickup Details.
    @FindBy(xpath = "//input[@placeholder='Shipper Name']") WebElement shipperName_input;
    @FindBy(xpath = "//div[contains(@class,' pickup-card')]//div[contains(@class,'shipper-commodity-info')]//div[@aria-label='Select']") WebElement pickUpDateDropDown_button;
    @FindBy(xpath = "//li[@aria-label='On']") WebElement pickUPDateOn_Button;
    @FindBy(xpath = "//input[contains(@placeholder,'Pickup On')]") WebElement PickUpON_Input;
    @FindBy(xpath = "//li[@aria-label='Between']") WebElement pickUpDateBetween_Button;
    @FindBy(xpath = "//input[@placeholder='Pickup From']") WebElement pickUpFrom_Input;
    @FindBy(xpath = "(//input[@placeholder='Pickup To'])[1]") WebElement pickUpTo_Input;
    @FindBy(xpath = "//div[@class='shipper-consignee-details-info pickup-card']//div[@class='form-group mb-5 col-xs-3 col-lg-3 col-md-6 col-sm-12 ']//div[@aria-label='Select']") WebElement pickUpTimeDropDown_button;
    @FindBy(xpath = "//ul[@role='listbox']//li") List<WebElement> pickUpTime_List;
    @FindBy(xpath = "//input[contains(@placeholder,'Pickup At')]") WebElement PickUpTime_Input;
    @FindBy(xpath = "//li[@aria-label='Between']") WebElement PickUpTimeBetween_Button;
    @FindBy(xpath = "//input[@placeholder='Pickup From']") WebElement PickUpTimeFrom_Input;
    @FindBy(xpath = "(//input[@placeholder='Pickup To'])[2]") WebElement PickUpTimeTo_Input;
    @FindBy(xpath = "//div[@class='shipper-consignee-details-info pickup-card']") WebElement pickupCardClick;
    


    //DropOff Details.
    @FindBy(xpath = "//input[@placeholder='Consignee Name']") WebElement consigneeName_Input;
    @FindBy(xpath = "//div[@class='form-group mb-5 col-xs-3 col-lg-3 col-md-6 col-sm-12 shipper-commodity-info']//div[@aria-label='Select']") WebElement dropOffDateDropDown_Button;
    @FindBy(xpath = "//li[@aria-label='On']") WebElement dropOffDateOn_Button;
    @FindBy(xpath = "//input[@placeholder='Delivery On']") WebElement dropOffDateOn_Input;
    @FindBy(xpath = "//li[@aria-label='Between']") WebElement dropOffDateBtwn_Button;
    @FindBy(xpath = "//input[@placeholder='Delivery From']") WebElement dropOffDatebtwnDeliveryFrom_Input;
    @FindBy(xpath = "(//input[contains(@placeholder,'Delivery To')])[1]") WebElement dropOffDatebtwnDeliveryTo_Input;
    @FindBy(xpath = "//div[contains(@class,'dropoff-card')]//div[@class='p-dropdown p-component p-inputwrapper p-inputwrapper-filled w-full md:w-14rem']//div[@aria-label='Select']") WebElement dropOffTimeDropDown_Button;
    @FindBy(xpath = "//ul[@role='listbox']//li") List<WebElement> dropOffTime_List;
    @FindBy(xpath = "//input[@placeholder='Delivery At']") WebElement dropOffTime_Input;
    @FindBy(xpath = "//li[@aria-label='Between']") WebElement dropOffTimeBtwn_Button;
    @FindBy(xpath = "//input[@placeholder='Delivery From']") WebElement dropOffTimebtwnDeliveryFrom_Input;
    @FindBy(xpath = "(//input[@placeholder='Delivery To'])[2]") WebElement dropOffTimebtwnDeliveryTo_Input;
    @FindBy(xpath = "//div[@class='shipper-consignee-details-info  dropoff-card']") WebElement dropoffCardClick;
    @FindBy(xpath="//button[normalize-space()='Save']") WebElement Save_Button;
    
    @FindBy(xpath="//span[@class='textfeild-icon-info']") WebElement refresh_Button;
    @FindBy(xpath="//tbody/tr[1]/td[3]") WebElement orderNum_Text;
    
    
    
    public void setOrderNumber(String onum) throws InterruptedException {
    	actions.sendKeys(orderNumber_Input, onum).perform();
    	Thread.sleep(1000);
    }
	
    public void selectC_Bdropdown(String cb_name) throws InterruptedException {
    	 actions.click(C_B_dropDown_Button).perform();
    	 actions.sendKeys(C_B_dropdown_input,cb_name).perform();
    	 actions.click(C_B_dropdown_List).perform();
    	 Thread.sleep(1000);
    }
    public void selectEquipmentType(String et_name) throws InterruptedException {
    	actions.click(equipmentType_Button).perform();
    	List<WebElement> Equipment_Type_option=equipmentType_List;
        for(WebElement op:Equipment_Type_option)
    		{
    			if(op.getText().equals(et_name))
    			{
    				op.click();
    				break;
    			}
    		}
        Thread.sleep(1000);
    }

    public void selectTagNmae(String tagname) throws InterruptedException {
//    	List<WebElement> tagnamelist = driver.findElements(By.xpath("(//span[contains(@class,'p-tag p-component')])"));
//		for (WebElement op : tagnamelist) {
//			if (op.getText().equals(tagname)) {
//				actions.click(op).perform();
//				break;	
//				}
//			else{
				actions.sendKeys(addTag_Input, tagname).perform();
				actions.sendKeys(Keys.ENTER).perform();
			
			//}
		//}
		Thread.sleep(1000);
    }
    public void selectLoadType(String loadtype) throws InterruptedException {
    	actions.click(typeDropdown_Button).perform();
    	 List<WebElement> loadType_List=typeDropdown_List;
         for(WebElement op:loadType_List)
     		{
     			if(op.getText().equals(loadtype))
     			{
     				actions.click(op).perform();
     				break;
     			}
     		}
         Thread.sleep(1000);
    }
    public void setRateValue(String rate) throws InterruptedException {
    	actions.sendKeys(Rate_Input, rate).perform();
    	Thread.sleep(1000);
    }
    public void setUnitValue(String unit) throws InterruptedException {
    	actions.sendKeys(Unit_Input, unit).perform();
    	Thread.sleep(1000);
    }
    public void setPDValue(String PD) throws InterruptedException {
    	actions.sendKeys(PD_Input, PD).perform();
    	Thread.sleep(1000);
    }
    public void setFSCValue(String FSC) throws InterruptedException {
    	actions.sendKeys(FSC_input, FSC).perform();
    	Thread.sleep(1000);
    }
    public void setShipperDetails(String shippername) throws InterruptedException {
    	 actions.sendKeys(shipperName_input, shippername).perform();
         actions.sendKeys(Keys.ENTER).perform();
         Thread.sleep(1000);
    }
    
   
    public void setPickupOnDate(String date) throws InterruptedException {
    	
    		actions.click(pickUpDateDropDown_button).perform();
    		Thread.sleep(1000);
        	actions.click(pickUPDateOn_Button).perform();
        	actions.sendKeys(PickUpON_Input, date).perform();	
    	
        	Thread.sleep(1000);
    	
    }
    public void setPickupBetweeenDate(String dateFrom, String dateTo) throws InterruptedException {
    	actions.click(pickUpDateDropDown_button).perform();
    	Thread.sleep(1000);
    	actions.click(pickUpDateBetween_Button).perform();
    	actions.sendKeys(pickUpFrom_Input, dateFrom).perform();
    	actions.click(pickupCardClick).perform();
    	actions.sendKeys(pickUpTo_Input, dateTo).perform();
    	Thread.sleep(1000);
    }
    
    public void setPickupTime(String Timelabel, String Time) throws InterruptedException {
    	actions.click(pickUpTimeDropDown_button).perform();
    	List<WebElement> optionsList=pickUpTime_List;
    	for (int index = 0; index < optionsList.size(); index++) {
            WebElement option = optionsList.get(index);
            String optionText = option.getText();
            if (optionText.equals(Timelabel)) {
                if (Timelabel.equals("BEFORE")) {
                    break; // Break the loop immediately
                } 
                else {
                    actions.moveToElement(option).click().perform();
                    actions.sendKeys(PickUpTime_Input, Time).perform();
                    
                }
            }
                    optionsList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        }
    	
    	Thread.sleep(1000);
    }
    
    public void setPickupBetweeenTime(String timeFrom, String timeTo) throws InterruptedException {
    	actions.click(pickUpTimeDropDown_button).perform();
    	actions.click(PickUpTimeBetween_Button).perform();
    	actions.sendKeys(PickUpTimeFrom_Input, timeFrom).perform();
    	actions.click(pickupCardClick).perform();
    	actions.sendKeys(PickUpTimeTo_Input, timeTo).perform();
    	Thread.sleep(1000);
    	   	
    }
    
    //Dropoff
    public void setConsigneeDetails(String consigneename) {
   	 actions.sendKeys(consigneeName_Input, consigneename).perform();
        actions.sendKeys(Keys.ENTER).perform();
   }
  
   public void setDropoffOnDate(String date) throws InterruptedException {
   	actions.click(dropOffDateDropDown_Button).perform();
   	Thread.sleep(1000);
   	actions.click(dropOffDateOn_Button).perform();
   	Thread.sleep(1000);
   	actions.sendKeys(dropOffDateOn_Input, date).perform();
   	
   }
   public void setDropoffBetweeenDate(String dateFrom, String dateTo) throws InterruptedException {
   	actions.click(dropOffDateDropDown_Button).perform();
   	Thread.sleep(1000);
   	actions.click(dropOffDateBtwn_Button).perform();
   	actions.sendKeys(dropOffDatebtwnDeliveryFrom_Input, dateFrom).perform();
   	actions.click(pickupCardClick).perform();
   	actions.sendKeys(dropOffDatebtwnDeliveryTo_Input, dateTo).perform();
   	   	
   }
   
   public void setDropoffTime(String Timelabel, String Time) throws InterruptedException {
   	actions.click(dropOffTimeDropDown_Button).perform();
   	List<WebElement> optionsList=dropOffTime_List;
   	for (int index = 0; index < optionsList.size(); index++) {
           WebElement option = optionsList.get(index);
           String optionText = option.getText();
           if (optionText.equals(Timelabel)) {
               if (Timelabel.equals("BEFORE")) {
                   break; // Break the loop immediately
               } 
               else {
                   actions.moveToElement(option).click().perform();
                   Thread.sleep(1000);
                   actions.sendKeys(dropOffTime_Input, Time).perform();
                   
               }
           }
                   optionsList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
       }
   	
   }
   public void setDropoffBetweeenTime(String timeFrom, String timeTo) {
   	actions.click(dropOffTimeDropDown_Button).perform();
   	actions.click(dropOffTimeBtwn_Button).perform();
   	actions.sendKeys(dropOffTimebtwnDeliveryFrom_Input, timeFrom).perform();
   	actions.click(dropoffCardClick).perform();
   	actions.sendKeys(dropOffTimebtwnDeliveryTo_Input, timeTo).perform();
   	
   	   	
   }
   
   public void clickSaveButton() throws InterruptedException {
	   actions.click(Save_Button).perform();
	   Thread.sleep(3000);
   }
   
   public void clickRefreshButton() {
	   actions.click(refresh_Button).perform();
   }
   
   public String getcomformationNum() {
	   try {
		   return (orderNum_Text.getText());
	   }catch (Exception e) {
		   return (e.getMessage());
	   }
   }
    public boolean isOrdernumExists() {
    	try {
    		return(orderNum_Text.isDisplayed());
    	}catch(Exception e) {
    		return(false);
    	}
    }
    
  
    
    
    
    

    



    

	
	

}

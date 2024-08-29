package org.fitPeo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.Revenue_Calculator_Page;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.utility.LaunchBrowser;

public class TestCase {
	
	static WebDriver driver;
	static WebElement textBox,slider;
	static Revenue_Calculator_Page rcp;
	
	@BeforeMethod
	public static void startup()
	{
		LaunchBrowser lb=new LaunchBrowser();
		driver=lb.driverSetup("ch", "https://www.fitpeo.com/");
		rcp=new Revenue_Calculator_Page(driver);
		rcp.click_On_revenue_Calculator_Tab();
		rcp.wait_for_element_visibility();
	    rcp.scroll_To_The_Element();	
	}
	
	@Test(priority=1,enabled=true)
	public static void updatingTheTextField()
	{
	    Assert.assertTrue(rcp.sending_the_value_in_the_text_field("560"),"Value is not send.");
	}
	
	@Test(priority=2,enabled=true)
	public static void validating_Text_value_and_slider_value()
	{ 
	    Assert.assertEquals(rcp.actualTexValue(), rcp.actualSliderValue(),"Text field and slider validation is not matching.");	
	}
	
	@Test(priority=3)
	public static void validate_Total_Recurring_Reimbursement()
	{  
		Assert.assertTrue(rcp.sending_the_value_in_the_text_field("560"),"Value is not send.");
		
	    rcp.click_on_cpt_99091();
	    rcp.click_on_cpt_99453();
	    rcp.click_on_cpt_99454();
	    rcp.click_on_cpt_99474();
	    
	    String expectedRecurringReimbursement="$75600";
	    
	    Assert.assertEquals(rcp.actualRecurringReimbursement(), expectedRecurringReimbursement,"Recurring Reimbursement validation not matching.");
      
	}
	
	@AfterMethod
	public static void quitBrowser()
	{
		driver.quit();
	}

}

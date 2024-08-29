package org.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Revenue_Calculator_Page 
{

	private WebDriver driver;

	
	@FindBy(xpath="//div[text()='Revenue Calculator']")
	private WebElement revenue_Calculator_Tab;
	
	@FindBy(xpath="(//span[contains(@class,'MuiSlider')])[4]/*")
	private WebElement slider;
	
	@FindBy(id=":r0:")
	private WebElement textBox;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")
	private WebElement cpt_99091;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]")
	private WebElement cpt_99453;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[3]")
	private WebElement cpt_99454;
	
	@FindBy(xpath="(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[8]")
	private WebElement cpt_99474;
	
	@FindBy(xpath="(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]")
	private WebElement recurringReimbursementElement;
	
	

	
	public Revenue_Calculator_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		this.driver=driver;
	}
	
	

	public void click_On_revenue_Calculator_Tab()
	{
		revenue_Calculator_Tab.click();
	}
	
	public void wait_for_element_visibility()
	{
		WebDriverWait wt=new WebDriverWait(driver,Duration.ofSeconds(5));
		wt.until(ExpectedConditions.visibilityOf(slider));
		
	}
	public void scroll_To_The_Element()
	{
		textBox.sendKeys(Keys.ARROW_DOWN);
		
	}
	public boolean sending_the_value_in_the_text_field(String value)
	{
	    textBox.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	    textBox.sendKeys(Keys.DELETE);
	    textBox.sendKeys(value);
	    return textBox.isDisplayed();
	    
	}	
	public String actualTexValue()
	{
		String actualTexValue=textBox.getAttribute("value");
		return actualTexValue;
	}
	public String actualSliderValue()
	{
		   String actualSliderValue=slider.getAttribute("aria-valuenow"); 
		   return actualSliderValue;
	}
	
	public void click_on_cpt_99091()
	{
		cpt_99091.sendKeys(Keys.ARROW_DOWN);
		cpt_99091.click();
	}
	
	public void click_on_cpt_99453()
	{
		cpt_99453.click();
	}
	
	public void click_on_cpt_99454()
	{
		cpt_99454.click();
	}
	
	public void click_on_cpt_99474()
	{
		cpt_99474.sendKeys(Keys.ARROW_DOWN);
		cpt_99474.click();
	}
	
	public String actualRecurringReimbursement()
	{
		String actualRecurringReimbursement=recurringReimbursementElement.getText();
		return actualRecurringReimbursement;
	}
}

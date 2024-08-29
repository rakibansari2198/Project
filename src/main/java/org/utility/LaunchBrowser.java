package org.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class LaunchBrowser {

	public static  WebDriver driverSetup(String bName,String url)
	{
		
		WebDriver driver=null;
		if(bName.equalsIgnoreCase("ch")||bName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Acceleration\\workspace\\Learning_Selenium\\drivers\\chromedriver.exe");
			ChromeOptions Options=new ChromeOptions();
			Options.addArguments("--remote-allow-origins=*");
			Options.addArguments("--disable-notifications");
			Options.addArguments("start-maximized");
		    driver=new ChromeDriver(Options);
		}
		else if(bName.equalsIgnoreCase("ed")||bName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","E:\\Acceleration\\workspace\\Learning_Selenium\\drivers\\msedgedriver.exe");
			EdgeOptions Options=new EdgeOptions();
			Options.addArguments("--remote-allow-origins=*");	
			Options.addArguments("--disable-notifications");
			Options.addArguments("start-maximized");
			driver=new EdgeDriver(Options);
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
		driver.get(url);
		driver.manage().window().maximize(); 
		return driver;
		
	}

}

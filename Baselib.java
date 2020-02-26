package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Baselib {
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser","baseURL"})
	public void precondition(String browserName,String URL)
	{
		driver=BrowserFactory.LaunchBrowser(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		Reporter.log(browserName+ " Launched and URL navigated ", true);
		
	}
	
	@AfterMethod
	public void postcondition()
	{
		driver.close();
		Reporter.log("browser closed");
	}

}

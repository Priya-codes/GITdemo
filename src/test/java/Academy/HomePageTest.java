package Academy;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObject.HomePage;
import pageObject.LandingPage;
import resources.base;

public class HomePageTest extends base
{
	WebDriver driver;
public static Logger log= LogManager.getLogger(base.class.getName());
@BeforeTest
	
	public void initailiseBrowser() throws IOException
	{
		driver= initialiseBrowser();
		log.info("Browser is initailised");
		}
	@Test(dataProvider="getData")
	public void homePageNavigation(String username, String Password) throws IOException
	{
		
		 driver.get(property.getProperty("url"));
         log.info("URL is opened ");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		LandingPage firstPage= new LandingPage(driver);
		firstPage.SignIn().click();
		HomePage loginpage=new HomePage(driver);
		loginpage.email().sendKeys(username);
		loginpage.password().sendKeys(Password);
		loginpage.login().click();
		log.info("We have entered in to the login page");
		
		
	
	
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="abc@gmail.com";
		data[0][1]="123445";
		
		
		data[1][0]="priya0903bisht@gmail.com";
		data[1][1]="23456677";
		return data;
		
		
	}
	
	@AfterTest
	
	public void closeBrowser()
	{
		driver.close();	
		log.info("Broswer is closed ");
	}
}

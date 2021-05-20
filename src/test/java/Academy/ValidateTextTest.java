package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class ValidateTextTest extends base

{
	WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
@BeforeTest
	
	public void initailiseBrowser() throws IOException
	{
		driver= initialiseBrowser();
		 driver.get(property.getProperty("url"));
	}

	@Test
	public void ValidateText() throws IOException
	{
	
		 LandingPage text=new LandingPage(driver);
		 //text.getTitle().getText()
		 Assert.assertEquals(text.getTitle().getText(), "FEATURED COURSES");
		 log.info("Text is matching hence its correct");
	}
@AfterTest
	
	public void closeBrowser()
	{
		driver.close();
		log.info("second test case broswer is closing ");
	}
	
}

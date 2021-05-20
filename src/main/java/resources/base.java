package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base 
{
	
	
	public WebDriver driver;
	public Properties property;

		public WebDriver initialiseBrowser() throws IOException 
		{
				 property=new Properties();
				FileInputStream file= new FileInputStream("G:\\Eclipse_Codes\\E2EProject2\\src\\main\\java\\resources\\data.properties");
				property.load(file);
				String browserName= property.getProperty("browser"); //connecting direct to maven
				System.out.println(browserName);
				if(browserName.equals("Chrome")) 
				{
					System.setProperty("webdriver.chrome.driver","G:\\work\\chromedriver_win32\\chromedriver.exe");
				 driver=new ChromeDriver();
				System.out.println("hello");
				}
				else if(browserName.equals("Firefox"))
				{
					//execute the firefox driver 
					System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
					WebDriver driver = new FirefoxDriver();
					
				}
				else if(browserName.equals("IE"))
				{
					// System Property for IEDriver   
					System.setProperty("webdriver.ie.driver", "D:\\IE Driver Server\\IEDriverServer.exe");  
					          
				   // Instantiate a IEDriver class.     
					WebDriver driver=new InternetExplorerDriver();  
				}
				//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				return driver;
				
		}
		
		
		public String getScreenshot(String testcaseName, WebDriver driver) throws IOException
		{
			 TakesScreenshot screenshot= (TakesScreenshot) driver;
			File source= screenshot.getScreenshotAs(OutputType.FILE );
			String destination=System.getProperty("user.dir")+"\\reports\\"+testcaseName+ ".png";
			FileUtils.copyFile(source,new File(destination));
			return destination;
		}
		
		
}

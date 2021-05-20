package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{

	WebDriver driver;
	
	By signIn=By.cssSelector("a[href*='sign_in']");
	By getTitle=By.xpath("//h2[contains(text(),'Featured Courses')]");
			
			public LandingPage(WebDriver driver) 
			{
		this.driver=driver;
			}

			public WebElement SignIn()
			{
		return driver.findElement(signIn);
			}
	
			public WebElement getTitle()	
			{
		return driver.findElement(getTitle);
			}
}

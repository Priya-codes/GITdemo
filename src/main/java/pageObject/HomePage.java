package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage 
{
	WebDriver driver;
	By EmailAddress= By.id("user_email");
	By Password= By.cssSelector("[type='password']");
	By Login=By.xpath("//input[@type='submit']");
	public HomePage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement email()
	{
		return driver.findElement(EmailAddress);
	}
	
	public WebElement password()
	{
		return driver.findElement(Password);
	}
	public WebElement login()
	{
		return driver.findElement(Login);
	
	}
	
	
}

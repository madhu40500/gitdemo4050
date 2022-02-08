package positivetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Locators.Addlocators;
import baseclasses.Baseclass;

public class Registeraccount extends Baseclass {
	public WebDriver driver;
	Addlocators  add; 
	@Test(priority = 0)
	void registersetup() throws IOException
	{
		driver= setup();
	driver.get("http://live.techpanda.org/index.php/customer/account/create/");
	add= new Addlocators(driver, object);
	}
	@Test(priority = 1)
	void register()
	{
		add.type("firstname_Xpath", "random");
		add.type("lastname_Xpath", "nothing");
		add.type("email_Xpath", "randomnothing123@gmail.com");
	add.type("password_Xpath", "nothing");
	add.type("confirmation_Xpath", "nothing");
	add.click("register_Xpath");
	
	Assert.assertTrue(add.element("success_Xpath").getText().contains(object.getProperty("expectedsuccess")), "no match sucess message" ); 
	}
	
	@Test(priority = 2)
	void addtowishlist()
	{
		add.click("tvmenu_Xpath");
		add.click("addtowishlist_Xpath");
		add.click("share_Xpath");
		add.type("shareemail_Xpath", "madhuvanapalli4050@gmail.com");
		add.type("sharemess_Xpath", "automation project");
		add.click("share_Xpath");
		
	Assert.assertTrue(add.element("sharesucess_Xpath").getText().contains(object.getProperty("expectedsucess")), "no match share");
	
		
	}

}

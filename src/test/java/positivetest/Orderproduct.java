package positivetest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Locators.Addlocators;
import baseclasses.Baseclass;

public class Orderproduct extends Baseclass {
	public WebDriver driver;
	Addlocators  add;
@Test(priority = 0)
void orderSetup() throws IOException
{
	driver=setup();
	driver.get(url);
	add= new Addlocators(driver,object);
	add.click("account_Xpath");
	add.click("myaccount_Xpath");
	
	
	//add.element("email_Xpath").clear();
	//driver.findElement(By.xpath("(//input[@id='email'])[1]")).sendKeys("randomnothin@gmail.com");
	add.type("emaillogin_Xpath", "randomnothing123@gmail.com");
//driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("nothing");
	add.type("passwordlogin_Xpath", "nothing");
add.click("login_Xpath");
}

@Test(priority = 1)
void checkout()
{
	
	add.click("addwhislist_Xpath");
	add.click("addtocart_Xpath");
add.click("proceedtocheckout_Xpath");

}

@Test(priority = 2)
void addadress()
{
	add.type("address_Xpath", "random");
	add.type("city_Xpath", "Newypkr");
add.select("region_Xpath", "New York");
add.type("zipcode_Xpath", "542896");
add.type("telephone_Xpath", "123456789");
add.click("continue_Xpath");
String cost= add.element("shippingcost_Xpath").getText();
Assert.assertTrue(cost.contains("$5.00"), "it semms no mathc cost shipping");
add.click("shippingcontiue_Xpath");
add.click("money_Xpath");
add.click("paymentcontinue_Xpath");
add.click("placeorder_Xpath");
}
@Test(priority = 3)
void orderverification()
{

	String expected=add.element("orderplaces_Xpath").getText();
	Assert.assertTrue(expected.contains(object.getProperty("actualtext")), "no order message match");
String orderno=add.element("orderno_Xpath").getText();
System.out.println(orderno);

}

}

package positivetest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Locators.Addlocators;
import baseclasses.Baseclass;
import baseclasses.Listeners;

public class Sortedproductlist extends Baseclass{
public WebDriver driver;
	Addlocators add;
	@Test(priority = 0)
	void verifymainpage() throws IOException
	{
		driver=setup();
		driver.get(url);
		add= new Addlocators(driver, object);
	String expectedtext=add.element("pagetitle_Xpath").getText();
	Assert.assertTrue(expectedtext.contains(object.getProperty("actualtext")), "it seems not match");
	}
	@Test(priority = 1)
	void verifymobilepage()
	{
		add.click("mobile_Xpath");
		String expectedtext= add.element("mobiletitle_Xpath").getText();
		Assert.assertTrue(expectedtext.contains(object.getProperty("actualtextmobiletext")), "it seems not match for mobile page");
	}
	@Test(priority = 2)
	void sort()
	{
		add.select("select_Xpath", "Name");
		List<WebElement> products= add.elements("products_Xpath");
		
	List<String> expectedlist= products.stream().map(s->s.getText()).collect(Collectors.toList());
	List<String> actuallist= expectedlist.stream().sorted().collect(Collectors.toList());
	Listeners.parallel.get().log(Status.INFO, "Expectedlist :"+ expectedlist+ "     Actuallist :" +actuallist);
	Assert.assertTrue(expectedlist.equals(actuallist), "it seems not sorted");
	}
}

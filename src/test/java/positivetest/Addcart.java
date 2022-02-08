package positivetest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Locators.Addlocators;
import baseclasses.Baseclass;

public class Addcart extends Baseclass {

	public WebDriver driver;
	Addlocators add;

	@Test(priority = 0)
	void Addcartsetup() throws IOException {
		driver =setup();
		driver.get(url);
		add = new Addlocators(driver, object);
		add.click("mobile_Xpath");
		List<WebElement> products = add.elements("products_Xpath");
		products.stream().filter(s -> s.getText().contains("SONY XPERIA")).map(s -> addtocart(s)).findAny().orElse(null)
				.click();

	}

	public WebElement addtocart(WebElement s) {
		return s.findElement(By.xpath("following-sibling::div//button"));
	}
	@Test(priority = 1)
	void Addtocart()
	{
		add.element("qty_Xpath").clear();
		add.type("qty_Xpath", "1000");
		add.click("update_Xpath");
		String expectederror= add.element("error-mess_Xpath").getText();
		Assert.assertTrue(expectederror.contains(object.getProperty("actualerror")), "it seems o match");
	add.click("emptycart_Xpath");
	String expectedtitle=add.element("pagetitle_Xpath").getText();
	Assert.assertTrue(expectedtitle.contains(object.getProperty("actualpagetitle")), "it seems o match");
	}
}

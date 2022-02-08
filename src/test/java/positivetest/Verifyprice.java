package positivetest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Locators.Addlocators;
import baseclasses.Baseclass;
import baseclasses.Listeners;

public class Verifyprice extends Baseclass {
	public WebDriver driver;
	Addlocators add; 

	@Test
void price() throws IOException
{ 
		driver=setup();
		
	add	= new Addlocators(driver, object);
		driver.get("http://live.techpanda.org/index.php/mobile.html");
List<WebElement> products= add.elements("products_Xpath");
List<String> price = products.stream().filter(s->s.getText().contains("SONY XPERIA")).map(s->getprice(s)).collect(Collectors.toList());
String productprice=price.get(0);

products.stream().filter(s->s.getText().contains("SONY XPERIA")).findFirst().orElse(null).click();
Assert.assertTrue(add.element("price_Xpath").getText().contains(productprice),"not mathcing price"); 
Listeners.parallel.get().log(Status.INFO, "The price product is :" +productprice);

}

	private String getprice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::div//span[@class='price']")).getText();
	}

	
}

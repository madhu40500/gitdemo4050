package positivetest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Locators.Addlocators;
import baseclasses.Baseclass;

public class Compareproducts extends Baseclass {

	public WebDriver driver;
	Addlocators add;

	@Test(priority = 0)
	void compareproductssetup() throws IOException {
		driver = setup();
		driver.get(url);
		add = new Addlocators(driver, object);
		add.click("mobile_Xpath");
		List<WebElement> products = add.elements("products_Xpath");
List<WebElement> list = products.stream().filter(s -> s.getText().contains("SONY XPERIA")||s.getText().contains("IPHONE")).collect(Collectors.toList());
		//.map(s -> addtocompare(s)).forEach(s -> s.click());
List<String> list1 = products.stream().filter(s -> s.getText().contains("SONY XPERIA")||s.getText().contains("IPHONE")).map(s->s.getText()).collect(Collectors.toList());

//List<String> lists1 = products.stream().filter(s -> s.getText().contains("ON")).map(s -> s.getText()).collect(Collectors.toList());

list.get(0).findElement(By.xpath("following-sibling::div//ul//li//a[.='Add to Compare']")).click();
//list.get(1).findElement(By.xpath("following-sibling::div//ul//li//a[.='Add to Compare']")).click();

//lists.get(1).click();
//map(s -> addtocompare(s)).forEach(s1->s1.click());
		// products.stream().filter(s -> s.getText().contains("IPHONE")).map(s ->
		// addtocompare(s)).findFirst().orElse(null).click();

	}

//	public WebElement addtocompare(WebElement s) {
//		return s.findElement(By.xpath("following-sibling::div//ul//li[2]"));
//	}

	@Test(priority = 1)
	void comparewindow() {

		add.click("compare_Xpath");
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		Assert.assertTrue(add.element("compare-title_Xpath").getText().contains("COMPARE PRODUCTS"),
				"no match compare");
		driver.close();
		driver.switchTo().window(parentid);
//add.elements("products_Xpath").stream().filter(s->s.getText().contains("SONY XPERIA IPHONE"));
	}
}
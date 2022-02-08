package corejavapractice;

import org.testng.annotations.Test;

public class Test1  extends Base{
@Test
void Test1method()
{
	driver.get("https://the-internet.herokuapp.com/");
	locators l = new locators(driver);
	l.click("a[href='/abtest']");
	System.out.println("Test1executed");
	
}
}

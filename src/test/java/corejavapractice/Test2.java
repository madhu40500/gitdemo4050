package corejavapractice;

import org.testng.annotations.Test;

public class Test2 extends Base{

	
@Test
void Test2method()
{
	driver.get("https://the-internet.herokuapp.com/checkboxes");
	locators l = new locators(driver);
	l.click("body div input:nth-child(1)");

	System.out.println("Test2executed");
	
}
	
}


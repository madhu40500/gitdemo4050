package corejavapractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class locators extends Base {
	WebDriver driver;
public locators(WebDriver driver) {

this.driver =driver;
}

void click(String locator)
{
	driver.findElement(By.cssSelector(locator)).click();
}

}

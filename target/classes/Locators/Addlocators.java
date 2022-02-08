package Locators;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import baseclasses.Baseclass;
import baseclasses.Listeners;

public class Addlocators extends Baseclass {
	public WebDriver driver;
	public  Properties object;


	public Addlocators(WebDriver driver, Properties object)  {
this.driver =driver;
this.object=object;
	}

	public void type(String locatorkey, String value) {
		try {
			if (locatorkey.endsWith("_Xpath")) {
				driver.findElement(By.xpath(object.getProperty(locatorkey))).sendKeys(value);
			} else if (locatorkey.endsWith("_Css")) {
				driver.findElement(By.cssSelector(object.getProperty(locatorkey))).sendKeys(value);
			} else if (locatorkey.endsWith("_Id")) {
				driver.findElement(By.id(object.getProperty(locatorkey))).sendKeys(value);
			}
			log.info("cliked on elemnet :" + locatorkey + " value typed is :" + value);
			Listeners.parallel.get().log(Status.INFO, "cliked on elemnet :" + locatorkey + " value typed is :" + value);
		} catch (Throwable t) {
			log.error("Error on clicking elemnet :" + locatorkey + " and typing value  :" + value);
			Listeners.parallel.get().log(Status.INFO,
					"Error on clicking elemnet :" + locatorkey + " Error log is :" + t.getMessage());
		}
	}

	public void click(String locatorkey) {

		try {
			if (locatorkey.endsWith("_Xpath")) {
				driver.findElement(By.xpath(object.getProperty(locatorkey))).click();
			} else if (locatorkey.endsWith("Css")) {
				driver.findElement(By.cssSelector(object.getProperty(locatorkey))).click();
			} else if (locatorkey.endsWith("_Id")) {
				driver.findElement(By.id(object.getProperty(locatorkey))).click();
			}
			log.info("cliked on elemnet :" + locatorkey);
			Listeners.parallel.get().log(Status.INFO, "cliked on elemnet :" + locatorkey);
		} catch (Throwable t) {
			log.error("Error on clicking elemnet :" + locatorkey);
			Listeners.parallel.get().log(Status.INFO,
					"Error on clicking elemnet :" + locatorkey + " Error log is :" + t.getMessage());
		}

	}

	public void select(String locatorkey, String value) {

		try {

			if (locatorkey.endsWith("_Xpath")) {
				Select customer = new Select(driver.findElement(By.xpath(object.getProperty(locatorkey))));
				customer.selectByVisibleText(value);
			} else if (locatorkey.endsWith("Css")) {
				Select customer = new Select(driver.findElement(By.xpath(object.getProperty(locatorkey))));
				customer.selectByVisibleText(value);
			} else if (locatorkey.endsWith("_Id")) {
				Select customer = new Select(driver.findElement(By.xpath(object.getProperty(locatorkey))));
				customer.selectByVisibleText(value);

			}
			log.info("performed a select action on :" + locatorkey);
			Listeners.parallel.get().log(Status.INFO, "performed a select action on :" + locatorkey);
		} catch (Throwable t) {
			log.error("Failed to performed a select action on :" + locatorkey);
			Listeners.parallel.get().log(Status.INFO,
					"Failed to performed a select action on :" + locatorkey + " Error log is :" + t.getMessage());
		}

	}

	public WebElement element(String locatorkey) {

		if (locatorkey.endsWith("_Xpath")) {
			return driver.findElement(By.xpath(object.getProperty(locatorkey)));
		} else if (locatorkey.endsWith("Css")) {
			return driver.findElement(By.cssSelector(object.getProperty(locatorkey)));
		} else if (locatorkey.endsWith("_Id")) {
			return	driver.findElement(By.id(object.getProperty(locatorkey)));
		}
return null;
	}
	
	public List<WebElement> elements(String locatorkey) {

		if (locatorkey.endsWith("_Xpath")) {
			return driver.findElements(By.xpath(object.getProperty(locatorkey)));
		} else if (locatorkey.endsWith("Css")) {
			return driver.findElements(By.cssSelector(object.getProperty(locatorkey)));
		} else if (locatorkey.endsWith("_Id")) {
			return	driver.findElements(By.id(object.getProperty(locatorkey)));
		}
return null;
	}

}
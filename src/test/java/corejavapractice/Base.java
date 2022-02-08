package corejavapractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
@BeforeTest
	void basemethod()
{
	WebDriverManager.chromedriver().setup();
	driver= new ChromeDriver();
	System.out.println("Base class got executed");
}
@AfterTest
void teardownbase()
{
	driver.close();
}
}

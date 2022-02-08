package baseclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Extentinstance;

public class Baseclass {

public WebDriver driver; 
public static Properties config;
public   Properties object;

public ExtentTest test;
public static Logger log = LogManager.getLogger(Baseclass.class.getName());
public ExtentReports ex = Extentinstance.createinstance();

public String url;


public WebDriver setup() throws IOException
{
	config = new Properties();
	String pathconfig = System.getProperty("user.dir")+"/src/main/java/properties/config.properties";
	FileInputStream fisc= new FileInputStream(pathconfig);
	config.load(fisc);
	log.info("loaded config file");
	object = new Properties();
	String pathobject = System.getProperty("user.dir")+"/src/main/java/properties/object.properties";
	FileInputStream fiso= new FileInputStream(pathobject);
	object.load(fiso);
	log.info("loaded object file");
	String browsername= config.getProperty("browser"); 
url = config.getProperty("url");
	if(browsername.contains("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	log.info("driver intilised");
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
return driver;
}

public String getscreeshot(String methodname, WebDriver driver) throws IOException
{
	Date d = new Date();
	
	String filename= d.toString().replace(" ","_").replace(":","_");
//	TakesScreenshot take = (TakesScreenshot)driver;
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	String destpath = System.getProperty("user.dir")+"/Reports/screenshots/"+methodname+filename+".png";

FileUtils.copyFile(screenshotFile, new File(destpath)); 
return destpath;
}

@AfterClass
public void teardown()
{
	driver.quit();
}


}

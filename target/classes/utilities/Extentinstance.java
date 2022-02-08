package utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentinstance {

	
public static	ExtentReports createinstance()
	{
		Date d = new Date();
		
		String filename= d.toString().replace(" ", "_").replace(":", "_");
	
		String path= System.getProperty("user.dir")+ "/Reports/Extentreports/"+filename+".html";
		
		ExtentSparkReporter esap = new ExtentSparkReporter(path);
		esap.config().setDocumentTitle("login demo");
ExtentReports ex = new ExtentReports();
ex.attachReporter(esap);
	return ex;
	}
	
}

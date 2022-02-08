package corejavapractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class Dpclass {

@DataProvider(name="bankmanager")
public Object[][] dpClass(Method m) throws FileNotFoundException
{
	String testname= m.getName();
	String excelpath=Constants.excelpath;

	return Excelldemo.getdata(testname, new FileInputStream(excelpath));
}
}

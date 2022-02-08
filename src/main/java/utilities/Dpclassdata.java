package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Dpclassdata {
	@DataProvider(name="addcustomer")
	Object[][] addcustomer() throws IOException
	{
		
		Excel e = new Excel();
	Object[][] data = e.getdata();
	return data;
	}
}

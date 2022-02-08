package corejavapractice;

import java.util.Hashtable;

import org.testng.annotations.Test;

public class Stringvalueof {

@Test(dataProvider = "bankmanager", dataProviderClass = Dpclass.class)
void customerdata(Hashtable<String,String> data)
{
	System.out.println(data.get("firstname"));
}
@Test(dataProvider = "bankmanager", dataProviderClass = Dpclass.class)
void openaccount(Hashtable<String,String> data)
{
	System.out.println(data.get("customernames"));
}
	
	
	}
	

	

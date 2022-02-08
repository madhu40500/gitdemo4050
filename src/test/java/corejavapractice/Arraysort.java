package corejavapractice;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class Arraysort {
	
@Test
void sort()
{

	Hashtable table = new Hashtable();
	table.put("first", 20);
	table.put("second", 20);
	table.put("third", 2010);
	table.put("fourth", 2047);

	Object[] arr = new Object[1];
	arr[0]=table;
	System.out.println(arr[0]);
	System.out.println(table);
}

}

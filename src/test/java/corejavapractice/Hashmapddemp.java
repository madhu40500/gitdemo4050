package corejavapractice;

import java.util.HashMap;
import java.util.Hashtable;

import org.testng.annotations.Test;

public class Hashmapddemp {

@Test
void dummy()
{
	
	HashMap<String,Integer> map = new HashMap<>();
	map.put("first", 20);
	map.put("second", 20);
	map.put("third", 30);
	map.put("first", 200);
	map.put("fourth", 60);
	map.put("fifth", 70);
	
	System.out.println(map);
	Hashtable<String,Integer> table = new Hashtable<>();
	table.put("first", 20);
	table.put("second", 20);
	table.put("third", 30);
	table.put("first", 200);
	table.put("fourth", 60);
	table.put("fifth", 70);
	
	System.out.println(table);
	
	
	
}
}

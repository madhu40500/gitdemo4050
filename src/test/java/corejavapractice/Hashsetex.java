package corejavapractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Hashsetex {
	
	public static void main(String[] args) {
		
		String[] s1 = {"madhu","hema","satya","madhu"};
		HashSet<String> set = new HashSet<String>();
		
		Set<String> a = Arrays.stream(s1).collect(Collectors.toSet());
	for(int i=0;i<s1.length;i++)		
	{
		set.add(s1[i]);
	}
	System.out.println(set);
	}

}

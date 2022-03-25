package org.wipro;

import java.util.ArrayList;
import java.util.List;

public class PasswordChecker {

	public static void main(String[] args) {

		
		String[] str={"P@sswORD1", "20passWORD20", "PASS6word", "PASS6word"};
		String[] str1={"theBestpassword", "myPassword#3"};
		
		PasswordChecker pwch=new PasswordChecker();
		
		System.out.println(pwch.checkPasswords(str, "4dro6"));
		System.out.println(pwch.checkPasswords(str1, "1dro0"));
		
	}
	
	public List<String> checkPasswords(String[] passwords, String checkString) {
		
		List<String> list= new ArrayList<>();
		int first=checkString.charAt(0);
		int last=checkString.charAt(checkString.length()-1);
		for(String str:passwords) {
			
			int count=(int) str.chars().filter(e->Character.isUpperCase(e)).count();
			if(count==Character.getNumericValue(first)) {
				
				StringBuilder stringbuilder = new StringBuilder(str);
				if(checkString.substring(1, 3).equals(stringbuilder.reverse().substring(0, 2).toString())) {
					
					int sum=str.chars().filter(e->Character.isDigit(e)).map(e->Character.getNumericValue(e)).sum();
					if(Character.getNumericValue(last)==sum) {
						list.add(str);
					}
				}				
			}
		}
		return list;
		
	}
	
}

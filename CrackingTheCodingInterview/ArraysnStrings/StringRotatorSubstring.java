package ArraysnStrings;
/*
 * 1.8 Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
 *  call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 */
public class StringRotatorSubstring {

	public boolean check(String s1, String s2) {
		
		String s3 = s1+s1;
		
		if(s3.contains(s2))
			return true;
		
		return false;
	}
}

class StringRotatorSubstringMainClass{
	public static void main(String[] args) {
		StringRotatorSubstring strrot = new StringRotatorSubstring();
		
		boolean flag=strrot.check("AppleBottom","BottomApple");
		System.out.println("Ansewer :" + flag);
		
		flag=strrot.check("undertaker","kerunderta");
		System.out.println("Ansewer :" + flag);
		
		flag=strrot.check("rotatebysixty","sixtybyrotate");
		System.out.println("Ansewer :" + flag);
	}
}

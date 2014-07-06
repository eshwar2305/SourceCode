package ArraysnStrings;
/*
 * 1.4 Write a method to decide if two strings are anagrams or not.
 */
public class Anagram {

	public boolean check(String s1, String s2) {
	
		s1 = s1.replaceAll(" ", "").toLowerCase();
		s2 = s2.replaceAll(" ", "").toLowerCase();
		
		if(s1.length() != s2.length()){
			System.out.println("Length Mismatch");
			return false;
		}
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int[] visitedCount = new int[256];
		
		for(int i=0;i<s1.length();i++){
			visitedCount[c1[i]]++;
		}
		
		for(int j=0;j<s2.length();j++){
			if(visitedCount[c2[j]] == 0){
				System.out.println("Second String contains extra character: " + c2[j]);
				return false;
			}
			visitedCount[c2[j]]--;
		}
		
		for(int k=0;k<visitedCount.length;k++){
			if(visitedCount[k] != 0){
				System.out.println("Charater Mismatch: ");
				return false;
			}
		}
		return true;
	}
}

class AnagramMainclass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagram an = new Anagram();
		boolean flag = an.check("William Shakespeare", "I am a weakish speller");
		flag = an.check("stationer", "into tears");
		System.out.println("Anagram: " + flag);
	}
}

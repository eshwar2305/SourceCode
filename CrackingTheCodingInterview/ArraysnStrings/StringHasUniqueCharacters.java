package ArraysnStrings;
/*1.1 Implement an algorithm to determine if a string has all unique characters. 
 * What if you can not use additional data structures?
 * 
 */

public class StringHasUniqueCharacters {

	public void check256(String str) {
		boolean[] c = new boolean[256]; // Total number of ASCII characters is 256
		
		for(int i =0 ; i<str.length();i++){
			if(c[str.charAt(i)] == true){
				System.out.println("The String has repeated characters:" + str.charAt(i));
				return;
			}
			c[str.charAt(i)] = true;
		}
		System.out.println("The String does not have any repeated characters.");
	}

	public void checka2z(String str) {
		int bitVector = 0;
		//We are assuming that the characters are only between a-z(48-73) == (0-25). 
		//So only 26 characters.An integer has 4 bytes = 32 bits.
		//So it hold 36 bit positions. So we use a int bit vector.
		
		int valOfChar;
		int charPosInBitVector;
		for(int i=0;i<str.length();i++){
			valOfChar = str.charAt(i) - 96; // because 'a' = 48 . You need to store only 0-25
										// in the bit vector.
			charPosInBitVector = 1<<valOfChar;
			if( (bitVector & charPosInBitVector) > 0){ // Move 1 by no of positions(value of char) & it with bit vector.
				System.out.println("The String has repeated characters:" + str.charAt(i));
				return;
			}
			
			bitVector = bitVector | charPosInBitVector;
		}
		System.out.println("The String does not have any repeated characters.");
	}



}

class StringHasUniqueCharactersMainClass{
	public static void main(String[] args) {
		StringHasUniqueCharacters sg = new StringHasUniqueCharacters();
		sg.check256("AmulBaby");
		sg.checka2z("AmulBaby".toLowerCase());
	}
}
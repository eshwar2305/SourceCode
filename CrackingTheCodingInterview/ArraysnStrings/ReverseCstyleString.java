package ArraysnStrings;
/*
 * 1.2 Write code to reverse a C-Style String. (C-String means that “abcd” is 
 * represented as five characters, including the null character.)
 */
public class ReverseCstyleString {

	public void reverseUsinCharArray(String str) {
		
		int head = 0;
		int tail = str.length()-1;
		
		if(tail < 2){
			System.out.println("Reversed Stirng:"+str);
		}
		
		//StringBuilder strBld = new StringBuilder();
		char[] strCharArray = str.toCharArray();
		char temp;
		while(head<tail){
			temp = strCharArray[head];
			strCharArray[head] = strCharArray[tail];
			strCharArray[tail] = temp;
			head++;
			tail--;
		}
		System.out.println("Reversed String:" + new String(strCharArray));
	}

	public void reverseUsingStringBuilder(String str) {
		int len =  str.length()-1;
		if(len < 2){
			System.out.println("Reversed Stirng:"+str);
		}
		StringBuilder strBld = new StringBuilder();
		char c;
		while(len > -1){
			c = str.charAt(len--);
			strBld.append(c);
		}
		System.out.println("Reversed String:" + strBld.toString());
	}

}

class ReverseCstyleStringMainClass {
	public static void main(String[] args) {
		ReverseCstyleString rs = new ReverseCstyleString();
		
		rs.reverseUsinCharArray("DingDong");
		rs.reverseUsingStringBuilder("DingDong");
	}
}
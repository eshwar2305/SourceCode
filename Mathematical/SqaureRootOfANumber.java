/**To round to the nearest integer, just compute t = floor(sqrt(4N)) using the algorithm above. 
 * If the least significant bit of t is set, then choose x = (t+1)/2; otherwise choose t/2.
 *  Note that this rounds up on a tie; you could also round down (or round to even) by looking at 
 *  whether the remainder is nonzero (i.e. whether t^2 == 4N).
 * 
 */


/**
 * @author 
 *
 */
public class SqaureRootOfANumber {

	public int getSqaureRootByNewtons(int N) {
		// TODO Auto-generated method stub
		int x,y;
		x = (int) Math.pow(2, Math.ceil(numOfBits(N)/2));
		while(true){
			y = (int) Math.floor((x + Math.floor(N/x))/2);// For integer (x+(N/x))/2
			if( y >= x) return x;
			x = y;
		}
		
		
	}

	private float numOfBits(int n) {
		//Find the log base 2 of a number N.
		int[] b = {0x2,0xC,0xF0,0xFF00,0xFFFF0000};
		int[] S = {1,2,4,8,16};
		int result=0;
		
		for(int i=4;i>=0;i--){
			if((n & b[i]) >= 1){
				n = n >> S[i];
				result = result | S[i];
			}
		}
		return (float)result + 1;
	}

	public int getSqaureRootByBabylonian(int N) {
		// Binary Search method
		if(N < 0) return -1;
		
		int a,b;
		
		a=1;
		b=N;
		while( Math.abs(a-b) > 1){
			a = (a+b)/2;
			b = N/a;
		}
		return a;
 		
	}



}

class SquareRootOfANumberMainClass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SqaureRootOfANumber sq = new SqaureRootOfANumber();
		
		System.out.println(sq.getSqaureRootByNewtons(500));
		System.out.println(sq.getSqaureRootByBabylonian(500));
	}
}
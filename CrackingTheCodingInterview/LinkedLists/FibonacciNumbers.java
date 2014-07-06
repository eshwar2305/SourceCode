package LinkedLists;


public class FibonacciNumbers {
	public int iterativeFibonacci(int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int recursiveFibonacci(int n) {
		// TODO Auto-generated method stub
		int x = 0;
		int y = 1;
		int z;
		while(n!=0){
			z = x+y;
			x = y;
			y = z;
			
			n--;
		}
		return n;
	}
}

class FibonacciNumbersMainClass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FibonacciNumbers fc = new FibonacciNumbers();
		int y = 5;
		int x = fc.recursiveFibonacci(y);
		System.out.println("Recursive Fibonacci of " + y +" = " + x);
		x = fc.iterativeFibonacci(y);
		System.out.println("Iterative Fibonacci of " + y + " = " + x);
	}
}

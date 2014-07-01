/*
 * Question : Given number N , find the smallest 3 digit number(xyz) such that x*y*z=N ?
 * 
 *  Solution:
 *  Idea 1 : Find all the factors of N - find only single digit factors, so your forloop will be only between 0 to 9
 *  Idea 2 : Now divide the number N from the largest factor. Store this largestFactor - This forms one digit of XYZ. 
 *  		Assign the quotient to number N. N = N/largestFactor
 *  Idea 3 : Now divide N again by the NEXT POSSIBLE largest factor. Store this largestFacctor - This forms the second digit of XYZ .
 *  		And the quotient forms 3rd digit of XYZ . Quotient = N/NextPossiblelargestFactor 
 *  Idea 4 : You can do the above steps by while looping 2 times for 2 divisions.
 *  		A forloop across all factors inside the while loop
 */



import java.util.ArrayList;
import java.util.Collections;


public class XYZequalsN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XYZequalsN nm = new XYZequalsN();
		
		nm.getxyz(11);
	}

	private void getxyz(int n) {

			ArrayList<Integer> factors = new ArrayList<Integer>();
			ArrayList<Integer> xyz = new ArrayList<Integer>();
			System.out.println("Number N = " + n);
			
			System.out.print("Factors : ");
			if(n==1 || n==0){
				System.out.println(n);
				return;
			}else{
				//System.out.println(1+",");
				for (int i=1;i<=9;i++){
					if(n%i==0){
						factors.add(i);
						System.out.print("," + i);
					}
				}
			}	
			
			System.out.println();
			int largestFactor = factors.get(factors.size()-1);
			
			if( Math.pow(largestFactor,3) < n){
				System.out.println("Not possible to get a 3 digit XYZ number- Max reachable number = " + Math.pow(largestFactor, 3) );
			}
			
			
			xyz.add(largestFactor);
			n = n/largestFactor;
			
			for(int j=factors.size()-1;j>=0;j--){
				int nextPossiblelargestfactor = factors.get(j);
				if(n%nextPossiblelargestfactor == 0){
					xyz.add(nextPossiblelargestfactor);
					n = n/nextPossiblelargestfactor;
					xyz.add(n);
					break;
				}
			}
			
			/*int count = 2;
			while(count !=0 ){
				for(int j=factors.size()-1;j>=0;j--){
					int f = factors.get(j);
					if(n%f == 0){
						xyz.add(f);
						n = n/f;
						count--;
						if(count == 0){
							xyz.add(n);
						}
						break;
					}
				}
				
			}*/
			Collections.sort(xyz);
			System.out.println(xyz.toString());
			
	}

}

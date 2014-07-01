import java.util.ArrayList;
import java.util.Collections;


public class FactorsOfaNumber {

	public void getFactors(int n) {
		// TODO Auto-generated method stub
		ArrayList<Integer> factors = new ArrayList<Integer>();
		
		if(n==1 || n==0){
			System.out.println(n);
			return;
		}else{
			//System.out.println(1+",");
			for (int i=1;i<=n/2;i++){
				if(n%i==0){
					factors.add(i);
					System.out.print("," + i);
				}
			}
			System.out.println(","+n);
		}	
	}



}

class FactorsMainclass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	FactorsOfaNumber fc = new FactorsOfaNumber();
	fc.getFactors(53);

	}
}
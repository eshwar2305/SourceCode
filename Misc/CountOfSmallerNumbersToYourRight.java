
public class CountOfSmallerNumbersToYourRight {

	public void calculate(int[] arr) {
		
		numberNode nr[] = new numberNode[arr.length];
		
		int effcount = 0;
		int max = arr[arr.length-1];
		int min = max;
		int n;
		for(int i = arr.length-1 ; i>=0 ; i--){
			n = arr[i];
			numberNode number = new numberNode();
			nr[i] = number;
			if(n > max ){
				number.count = (arr.length-i-1);
				number.max = n;
				max = n;
			}else{
				for(int j=i+1 ; j<arr.length ;j++){
					effcount++;
					if(n > arr[j]){
						number.count++;
						if(n > nr[j].max){
							number.count = number.count + (arr.length-j-1);
							number.max = max;
							break;
						}
					}else if(n < min){
						min = n;
						break;
					}
				}
			}
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i] + " = " + nr[i].count);
		}
		System.out.println(effcount);
	}



}

class CountOfSmallerNumbersToYourRightMainClass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountOfSmallerNumbersToYourRight cn = new CountOfSmallerNumbersToYourRight();
		
		int arr[] = {0,42,8,48,24,15,7,32,6,1,3};
		//int arr[] = {1,2,3,4,5,6,7,8,9,10};
		//int arr[] = {10,9,8,7,6,5,4,3,2,1};
		cn.calculate(arr);
		
	}
}

class numberNode {
	int max;
	int count = 0;
}

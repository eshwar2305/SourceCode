
public class ArrayPivotIndexLeftsumEqualRightsum {

	public int getPivotEasy(int[] arr) {
		int completeSum = 0;
		int leftSum = 0;
		
		for(int i=0;i<arr.length;i++){
			completeSum = completeSum + arr[i];
		}
		
		for(int j=0;j<arr.length;j++){
			completeSum = completeSum - arr[j];
			
			if(completeSum == leftSum){
				return j;
			}
			
			leftSum = leftSum + arr[j];
		}
		return -1;
	}

	public int getPivotByNtraversal(int[] arr) {
		int leftSum =0;
		int rightSum = 0;
		int head=0;
		int tail = arr.length-1;
		int len = arr.length;
		
		leftSum = arr[head];
		rightSum = arr[tail];
		
		while(head < tail){
			while(leftSum > rightSum){
				tail--;
				rightSum = rightSum + arr[tail];
			}
			
			while(rightSum > leftSum){
				head ++;
				leftSum = leftSum + arr[head];
			}
			
			if((head < tail) && ((tail-head)==2)){
				return head+1;
			}
			
			if(leftSum == rightSum){
				head++;
				leftSum = leftSum + arr[head];
			}
		}
		
		return -1;
	}



}

class ArrayPivotIndexLeftsumEqualsRightSumMainClass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayPivotIndexLeftsumEqualRightsum arp = new ArrayPivotIndexLeftsumEqualRightsum();
		
		int[] arr = {1,1,2,4,3,-1,2,8,9,10,9,1};
		
		
		int pivotIndex = arp.getPivotEasy(arr);
		System.out.println("Pivot Index : " + pivotIndex);
		
		pivotIndex = arp.getPivotByNtraversal(arr);
		System.out.println("Pivot Index : " + pivotIndex);
	}
}

public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BubbleSort s_Obj = new BubbleSort();
		int[] arr = { 23,42,4,16,8,15};
		s_Obj.sort(arr);
		s_Obj.display(arr);
	}

	private void sort(int[] arr) {
		// TODO Auto-generated method stub
		int swapPos = arr.length-1;
		int lastSwapIndex;
		int temp;
		boolean swap = true;
		
		while(swap){
			swap = false;
			lastSwapIndex = swapPos;
			for( int i=0 ; i<lastSwapIndex; i++){
				if(arr[i] > arr[i+1]){
					temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swap = true;
					swapPos = i;
				}
			}
		}
	}
	
	public void display(int[] arr) {
		// TODO Auto-generated method stub
		System.out.print("{");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			if(i < arr.length -1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

}

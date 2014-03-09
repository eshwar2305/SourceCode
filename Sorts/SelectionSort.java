/**
 * 
 */

/**
 * @author eshwar2305
 *
 */
public class SelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSort s_Obj = new SelectionSort();
		int[] arr = { 23,42,4,16,8,15};
		s_Obj.sort(arr);
		s_Obj.display(arr);
	}
	
	private void sort(int[] arr) {
		// TODO Auto-generated method stub
		int minimumIndex=0;
		int temp;
		int n=arr.length;
		
		for(int i=0;i<n;i++){
			minimumIndex = i;
			for(int j=i+1;j<n;j++){
				if(arr[j] < arr[minimumIndex]){
					minimumIndex = j;
				}
			}
			
			if(minimumIndex != i){
				temp = arr[i];
				arr[i] = arr[minimumIndex];
				arr[minimumIndex] = temp;
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

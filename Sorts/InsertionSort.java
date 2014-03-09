
public class InsertionSort {

	public int[] sort(int[] a) {
		
		int number;
		int insert_pos;
		int n  = a.length;
		
		for(int p=1;p<n;p++) {
			number = a[p];
			insert_pos = p;
			for(int j=p-1; j>-1; j--) {
				
				if(number < a[j]){
					a[j+1] = a[j];
					insert_pos = j;
				}
				
				a[insert_pos] = number;
			}
		}
		
		return a;
		
	}

	private int compareTo(int i, int j) {
		// TODO Auto-generated method stub
		if(i < j) return 1;
		else return -1;
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

 class MainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSort is = new InsertionSort();
		int[] myarray = {0,56,4,54,23};
		is.display(is.sort(myarray));

	}
}

/*
 * 1.7 Write an algorithm such that if an element 
 * in an MxN matrix is 0, its entire row and column is set to 0.
 */
public class ZeroMatrix {

	public void constructZeroMatrix(int[][] arr) {
		int[] rowToBeZero = new int[arr.length];
		int[] colToBeZero = new int[arr[0].length];
		
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				if(arr[i][j] == 0){
					rowToBeZero[i] = 1;
					colToBeZero[j] = 1;
				}
			}
		}
		
		for(int i = 0 ; i<arr.length ; i++){
			for(int j=0;j<arr[0].length;j++){
				if((rowToBeZero[i] | colToBeZero[j]) == 1){
					arr[i][j] = 0;
				}
			}
		}
	}

	 void display(int[][] a) {
		int rowc = a.length;
		int colc = a[0].length;
		for(int i=0;i<rowc;i++){
			for (int j=0;j<colc;j++){
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}


}

class ZeroMatrixMainClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] arr = { {1,2,3,4},
						{5,6,0,7},
						{8,9,10,2} };
		
		ZeroMatrix zm = new ZeroMatrix();
		
		zm.display(arr);
		
		zm.constructZeroMatrix(arr);
		
		zm.display(arr);
		
	}
}
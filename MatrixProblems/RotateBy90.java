
public class RotateBy90 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = { {11,12,13,14,15},
				  {16,17,18,19,20},
				  {21,22,23,24,25},
				  {31,32,33,34,35},
				  {36,37,38,39,40},
				};
		
		RotateBy90 rtr = new RotateBy90();
		System.out.println("Original Matrix");
		 rtr.display(a);
		 rtr.transposer(a);
		 //rtr.rotate90ByRight(a);
		 rtr.rotate90ByLeft(a);
	}

	private void display(int[][] a) {
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

	private void transposer(int[][] a) {
		int rowc = a.length;
		int colc = a[0].length;
		for(int r=0;r<rowc;r++){
			for(int c=r+1;c<colc;c++){
				swap(a,r,c,c,r);
			}
		}
		System.out.println("Transpose Matrix");
		display(a);
	}
	
	private void rotate90ByRight(int[][] a) {
		int colc = a[0].length;

		//If you want to rotate by right, then change the columns
		for(int c=0;c<colc/2;c++){
			columnSwap(a,c,(colc-1)-c);
		}
		System.out.println("Rotate 90 By Right");
		display(a);
	}

	private void rotate90ByLeft(int[][] a) {
		int rowc = a.length;
		
		//if you want to rotate by left, then change the rows
		for(int r=0;r<rowc/2;r++){
			rowSwap(a,r,(rowc-1)-r);
		}
		System.out.println("Rotate 90 By Left");
		display(a);
	}
	
	private void columnSwap(int[][]a,int c1, int c2) {
		int rowc = a.length;

		for(int r=0;r<rowc;r++){
			swap(a,r,c1,r,c2);
		}
	}
	
	private void rowSwap(int[][] a, int r1, int r2) {
		int colc = a[0].length;
		
		for(int c=0;c<colc;c++){
			swap(a,r1,c,r2,c);
		}
	}

	private void swap(int[][] a,int x,int y, int p, int q){
		a[x][y]^=a[p][q];
		a[p][q]^=a[x][y];
		a[x][y]^=a[p][q];
		
		/*int temp = a[x][y];
		a[x][y]=a[p][q];
		a[p][q]=temp;
		
		a[x][y] = a[x][y] + a[p][q];
		a[p][q] = a[x][y] - a[p][q];
		a[x][y] = a[x][y] - a[p][q];*/
	}

}

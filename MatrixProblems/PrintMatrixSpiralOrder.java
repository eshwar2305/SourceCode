
public class PrintMatrixSpiralOrder {

	public void printSprialOrderRecursive(int[][] a) {
		int rowc = a.length;
		int colc = a[0].length;
		
		printUpperRightTopLayer(a,0,0,rowc-1,colc-1);
	}

	private void printUpperRightTopLayer(int[][] a, int x1, int y1, int x2,int y2) {
		
		//print the rows first of the top layer
		for(int i=y1;i<=y2;i++){
			System.out.print(a[x1][i]+",");
		}
		
		//print the columns of the top right layer
		for(int j=x1+1;j<=x2;j++){
			System.out.print(a[j][y2]+",");
		}
		
		//check if there are more layers
		if(x2-x1 > 0){
			printBottomLeftLayer(a,x1+1,y1,x2,y2-1);
		}
		
	}

	private void printBottomLeftLayer(int[][] a, int x1, int y1, int x2, int y2) {
		
		//print the rows first from left to right of the bottom layer
		for(int i=y2;i >= y1;i--){
			System.out.print(a[x2][i]+",");
		}
		
		//print the columns from bottom to up of the left layer
		for(int j=x2-1;j >=x1 ; j-- ){
			System.out.print(a[j][y1]+",");
		}
		
		//check if there are more layers
		if(x2-x1 > 0){
			printUpperRightTopLayer(a, x1, y1+1, x2-1, y2);
		}
	}

	public void display(int[][] a) {
		System.out.println();
		for( int i = 0; i< a.length; i++){
			for(int j=0;j<a[0].length; j++){
				System.out.print(a[i][j] + ",");
			}
			System.out.println();
		}
		System.out.println();
	}

	public void printSpiralOrderIterative(int[][] a) {
		int rowc=a.length;
		int colc=a[0].length;
		
		int x1=0;
		int y1=0;
		int x2=rowc-1;
		int y2=colc-1;
		
		while(x2>=x1 && y2>=y1){
			
			//loop through this for every rectangle in NxN matrix
			// and lastly there will a horizontal or vertical line leftover for NxM matrix
			print(a,x1,y1,x2,y2);
			
			//this is enter the new inner rectangle after orinting the outer one.
			x1++;
			y1++;
			x2--;
			y2--;
		}
		
	}
	
	void print(int[][] a,int x1,int y1,int x2,int y2){
		
		//print horizontal lines and return -> do not proceed further as these are the last elements left in the matrix
		if( (x1==x2) && (y1!=y2)){
			for(int i=y1;i<=y2;i++){
				System.out.print(a[x1][i] + ",");
			}
			return;
		}
		
		//print vertical lines and return -> do not proceed further as these are the last elements left in the matrix
		if( (x1!=x2) && (y1==y2)){
			for(int i=x1;i<=x2;i++){
				System.out.print(a[i][y1] + ",");
			}
			return;
		}
		
		//Print the Rcctangles
		
		//print top line of rectangle
		for(int i=y1;i<=y2;i++)
			System.out.print(a[x1][i] + ",");

		
		//print right line of rectangle
		for(int i=x1+1;i<=x2;i++)
			System.out.print(a[i][y2] + ",");
		
		//print the bottom line of rectangle
		for(int i=y2-1;i>=y1;i--)
			System.out.print(a[x2][i] + ",");
		
		//print the left line of rectangle
		for(int i=x2-1;i>x1;i--)
			System.out.print(a[i][y1] + ",");
	}

}

 class MainClass{
	public static void main(String []args){
		
		int[][] a = { {1,2,3,0},
					  {4,5,6,0},
					  {7,8,9,0},
					  {4,4,4,4},
					  {8,8,8,8}};
		
		PrintMatrixSpiralOrder pmx= new PrintMatrixSpiralOrder();
		pmx.display(a);
		pmx.printSprialOrderRecursive(a);
		System.out.println();
		pmx.printSpiralOrderIterative(a);
	}
}

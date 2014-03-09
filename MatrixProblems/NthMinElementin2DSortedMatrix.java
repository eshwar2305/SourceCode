
/*
 * Question : There is an array - All Elements in row are sorted and elements in column are sorted. 
 * 				You need to find the nth minimum element in the 2D array.
 * Egs : { 	{10,20,30,40}
 * 		 	{15,25,35,45}
 * 			{27,29,37,50}
 * 			{31,34,41,55}
 * 		 }
 *   4th minimum element in this array is 25.
 *   
 * Solution:
 * Idea 1 : The minimum element in this array is always a[0,0] - so start from here
 * Idea 2 : For the next minimum element , you need to check the neighbours of the a[0,0] and compare them.
 * Idea 3: Since you need the value to compare , and determine the neighbours of the minimum element- you need rowIndex and colIndex
 * 			of each element. So you need to create a node class containing the value,rowIndex and column Index for each element you traverse.
 * Idea 4: Mantian a Priority Q and keep adding the neighbours to this list. PQ sorts the ekements in ascending order
 * Idea 5: Use a WHILE loop and pop out the 0th element in PQ - This  will be the next minimum element. Get the neighbours of this element and 
 * 			add them to PQ.
 * Idea 6: Make sure you dont add duplicate/repeated entries in PQ. Also check row and col bounds while accessing the neighbours.
 * Idea 7: Override the equals method in the node class for comparing the element value rather than object itself - While PQ sorts 
 * 			the objects it uses equals method of node class.
 * Idea 8: PQ always maintains a sorted list
 * Idea 9: Hashset doesn't duplicate elements.
 * Idea 10: If using a Arraylist then write comparator class -> override compare to compare value of node and not object itself.
 * 
 */




import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class NthMinElementin2DSortedMatrix {

	public void findNthMinEle(int[][] a) {

		ArrayList<node> neighbourList = new ArrayList<node>();
		int posCount = 10;
		int row=0,col=0;
		node root = new node(a[row][col],row,col);
		neighbourList.add(root);
		while(true){
			node popleastn1 = neighbourList.remove(0);
			posCount--;
			if(posCount == 0){
				System.out.println(posCount +"th minimum element in the matrix is: " + popleastn1.getValue());
				return;
			}
			row = popleastn1.getRowIndex();
			col = popleastn1.getColIndex();
			if(row+1 < a.length){
				node neighbour1 = new node(a[row+1][col],row+1,col);
				if(!neighbourList.contains(neighbour1)){
					neighbourList.add(neighbour1);
				}
			}
			if(col+1 < a[0].length){
				node neighbour2 = new node(a[row][col+1],row,col+1);
				if(!neighbourList.contains(neighbour2)){
					neighbourList.add(neighbour2);
				}
			}	
			Collections.sort(neighbourList,new ValueComparator());
		}	
		
	}



}

class node{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		node other = (node) obj;
		if (value != other.value)
			return false;
		return true;
	}
	int value;
	int rowIndex;
	int colIndex;
	public node(int val, int row, int col) {
		this.value = val;
		this.rowIndex = row;
		this.colIndex = col;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getRowIndex() {
		return rowIndex;
	}
	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}
	public int getColIndex() {
		return colIndex;
	}
	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}
}

class ValueComparator implements Comparator<node>{

    public int compare(node n1, node n2) {
        return (n1.value < n2.value ) ? -1: (n1.value > n2.value) ? 1:0 ;
    }
  
}

	
class MainClassNthMinElementin2DSortedMatrix {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[][] a = { {1,2,3,4},
				  {5,6,7,8},
				  {9,10,11,12},
				  {13,14,15,16},
				  {17,18,19,20}};
		
		NthMinElementin2DSortedMatrix nm = new NthMinElementin2DSortedMatrix();
		nm.findNthMinEle(a);
		

	}
}

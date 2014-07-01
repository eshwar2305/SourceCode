/*
 * Explanation : http://www.sourcecodesworld.com/articles/java/java-data-structures/Radix_sort.asp
 * 
 * Counting Sort : Animation : http://www.cs.miami.edu/~burt/learning/Csc517.101/workbook/countingsort.html
 * Explanation : http://www.geeksforgeeks.org/counting-sort/
 */



import SinglyLinkedList.SinglyLinkedList;


public class RadixSort {

	public void print(int[] arr) {
		// TODO Auto-generated method stub
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + ",");
		}
	}

	public void sort(int[] arr) {
		QBucket[] qBuckets = new QBucket[10];
		
		for(int j=0;j<10;j++){
			qBuckets[j] =  new QBucket();
		}
		boolean flag = true;
		int divisor = 1;
		int hashIndex, count;
		
		while(flag){
			flag = false;
			for(int i=0;i<arr.length;i++){
				hashIndex = (arr[i]/divisor) % 10;

				if(hashIndex > 0) 
					flag = true;
				
				SinglyLinkedList s = qBuckets[hashIndex].sl;
				int k = arr[i];
				s.addLast(k);
				//(qBuckets[hashIndex]).sl.addLast(arr[i]);
			} 
			
			divisor = divisor * 10;
			count = 0;
			for(int j=0;j<10;j++){
				while(!qBuckets[j].sl.isEmpty()){
					arr[count++] = qBuckets[j].sl.removeFirst();
				} 
			}
		}
		
	}



}

class QBucket {
	SinglyLinkedList sl = new SinglyLinkedList();
	int index;
}

class RadixSortMainClass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RadixSort rs = new RadixSort();
		
		int[] arr = {2,34,65,7,43,23,87,56,321,4};
		
		rs.print(arr);
		rs.sort(arr);
		rs.print(arr);
	}
}

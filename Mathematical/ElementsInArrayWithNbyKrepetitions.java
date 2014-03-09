
/*
 * geeksforgeeks
 * 
 * Given an array of of size n and a number k, find all elements that appear more than n/k times?
 * 
 * http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
 * 
 */
public class ElementsInArrayWithNbyKrepetitions {



	public void printElements(int[] arr, int k) {
		// Prints elements with more than n/k occurrences in arr[] of
		// size n. If there are no such elements, then it prints nothing.
		
		// k must be greater than 1 to get some output
	    if (k < 2)
	       return;
	    
	    /* Step 1: Create a temporary array (contains element
	       and count) of size k-1. Initialize count of all
	       elements as 0 */
		Kelement[] temp =  new Kelement[k-1];
		
		for(int i = 0 ; i < k-1 ; i++){
			temp[i] = new Kelement();
			temp[i].value = 0;
		}
		
		/* Step 2: Process all elements of input array */
		for(int i=0;i<arr.length;i++){
			
			int j;
			/* If arr[i] is already present in
	           the element count array, then increment its count */
			for(j=0;j<k-1;j++){
				if(temp[j].value == arr[i]){
					temp[j].count ++;
					break;
				}
			}
			
			/* If arr[i] is not present in temp[] */
			if(j==k-1){
				 int l;
				 /* If there is position available in temp[], then place
	              arr[i] in the first available position and set count as 1*/
				 for(l=0;l<k-1;l++){
					 if(temp[l].count == 0){
						 temp[l].value = arr[i];
						 temp[l].count++;
						 break;
					 }
				 }
				 
				 /* If all the position in the temp[] are filled, then
	               decrease count of every element by 1 */
				 if(l == k-1){
					 for(int f=0;f<k-1;f++){
						 temp[f].count--;
					 }
				 }
			}
		}
		
		int count;
		/*Step 3: Check actual counts of potential candidates in temp[]*/
		for(int i=0;i<k-1;i++){
			count = 0;
			// Calculate actual count of elements 
			for(int j=0;j<arr.length;j++){
				if(temp[i].value == arr[j]){
					count++;
				}
			}
			
			// If actual count is more than n/k, then print it
			if(count > arr.length/k){
				System.out.println(temp[i].value);
			}
		}
		
		
	}


}

class Kelement{
	int value=0;
	int count=0;
}

class ElementsInArrayWithNbyKrepetitionsMainClass{
	public static void main(String[] args) {
		int[] arr = {3,1,2,2,2,2,1,4,3,3};
		int k = 4;
		ElementsInArrayWithNbyKrepetitions nlk =  new ElementsInArrayWithNbyKrepetitions();
		
		nlk.printElements(arr,k);
	}
}
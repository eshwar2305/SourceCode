/*
 * Question : Given a number N - Using the same digits in this number N print the next smallest number.
 * 
 * For Egs: N=32476
 * Digits : 3,2,4,7,6
 * Answer : 32647
 * 
 * Idea 1: Convert integer to a String, then convert String into a integer array
 * Idea 2: Start from last but one element(tenths element) -> Untill u reach where right element is greater than left element keep going.
 * 			Stop when right element is greater than left element.
 * Idea 3: Split the array virtually across pivot element with pivot element in right side of the array.
 * Idea 4: Store the Pivot_index and Pivot_element in separate variables.
 * Idea 5: Sort the right side of the array in ascending order.
 * Idea 6: Find the element sitting next to pivot_element in the sorted array. Swap it with pivot_index
 * Idea 7: Now sort the right of pivot_index array in ascending order.

 * 
 * Let’s visualize a better solution using an example, the given number is 12543 and the resulting next higher number should be 13245.
 *  We scan the digits of the given number starting from the tenths digit (which is 4 in our case) going towards left. At each iteration
 *  we check the right digit of the current digit we’re at, and if the value of right is greater than current we stop, otherwise we
 *  continue to left. So we start with current digit 4, right digit is 3, and 4>=3 so we continue. Now current digit is 5, right digit is 4,
 *  and 5>= 4, continue. Now current is 2, right is 5, but it’s not 2>=5, so we stop. The digit 2 is our pivot digit. From the digits to 
 *  the right of 2, we find the smallest digit higher than 2, which is 3. This part is important, we should find the smallest higher digit 
 *  for the resulting number to be precisely the next higher than original number. We swap this digit and the pivot digit, so the number 
 *  becomes 13542. Pivot digit is now 3. We sort all the digits to the right of the pivot digit in increasing order, resulting in 13245.
 * 
 * http://www.ardendertat.com/2012/01/02/programming-interview-questions-24-find-next-higher-number-with-same-digits/
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class NextSmallestNumber {

	public void getNextSmallestNumber(String number) {
		// TODO Auto-generated method stub.
		
		int[] digit_arr = new int[number.length()];
		System.out.println(" The number is : " + number);

		for(int i=0;i<number.length();i++)
			digit_arr[i] = number.charAt(i) - 48;
		
		int n = digit_arr.length-1;
		int pivot_index,pivot_element;
		for(int i=n-1;i>0;i--){
			if(digit_arr[i] < digit_arr[i+1]){
				pivot_index = i;
				pivot_element = digit_arr[i];
				ascendingSort(digit_arr,i,n);
				
				for(int k=i;k<n;k++){
					if(digit_arr[k] == pivot_element){
						swap(digit_arr,pivot_index,k+1);
						break;
					}
				}
				ascendingSort(digit_arr,pivot_index+1,n);
				break;
			}
		}
		System.out.println("Next Smallest number is : " + Arrays.toString(digit_arr) );
	}

	private void swap(int[] digit_arr, int pivot_index, int i) {
		/*int temp = digit_arr[j];
		digit_arr[j] = digit_arr[k];
		digit_arr[k] = temp;*/
		digit_arr[pivot_index] = digit_arr[pivot_index] + digit_arr[i];
		digit_arr[i] = digit_arr[pivot_index] - digit_arr[i];
		digit_arr[pivot_index] = digit_arr[pivot_index] - digit_arr[i];
	}

	private void ascendingSort(int[] digit_arr, int minIndex, int n) {
		int minele = 0,jindex=0;
			boolean minswap = false;
			for(int i=minIndex ; i<=n ;i++){
				minele = digit_arr[i];
				minswap =  false;
				for(int j=i+1;j<=n;j++){
					if(digit_arr[j] < minele){
						minele = digit_arr[j];
						minswap = true;
						jindex = j;
					}
				}
				
				if(minswap == true){
					int temp = digit_arr[jindex];
					digit_arr[jindex] = digit_arr[i];
					digit_arr[i] = temp;
				}
			}
	
		}
	
	}


class MainClassNextSmallestNumber{
	public static void main(String []args){
		
		int number = 32476; 
		
		NextSmallestNumber nsn= new NextSmallestNumber();
		nsn.getNextSmallestNumber(number+"");
	}
	
}

package StacksQueues;
import Stack.*;

/*3.6 Write a program to sort a stack in ascending order. You should not make 
 * any assumptions about how the stack is implemented. The following are the only 
 * functions that should be used to write this program: push | pop | peek | isEmpty.*/

/*Hints:
	1. Use one more stack 
	2. pop frm one S1 to temp
	3. compare temp with S2.top
	4. insert temp to S2 only when ascending order satisfies 
	-> till then shift elements from S2 -> S1
	
	Efficiency : O(N^2) -> 2 while loops
*/

public class SortAStackInAscendingOrder {

	public void sort(StackArray stArr) {
		StackArray s2 = new StackArray();
		int temp;
		while(!stArr.isEmpty()){
			temp = stArr.pop(); 			
			while(s2.peek() < temp && !s2.isEmpty()){
					stArr.push(s2.pop());
			}
			s2.push(temp);					
		}
		s2.printStack();
	}
}

class SortAStackInAscendingOrderMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackArray stArr = new StackArray();
				stArr.push(23);
				stArr.push(33);
				stArr.push(43);
				stArr.push(53);
				stArr.push(63);
				stArr.push(13);
				stArr.push(24);
				stArr.push(58);
		stArr.printStack();
		System.out.println();
		
		SortAStackInAscendingOrder sc = new SortAStackInAscendingOrder();
		
		sc.sort(stArr);
		
		stArr.printStack();
				
	}
}

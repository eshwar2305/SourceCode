package Stack;

public class StackArray {
	int[] array;
	int top;
	final int STACK_SIZE = 100;
	
	public StackArray(){
		array = new int[STACK_SIZE];
		top = -1;
	}
	
	public void push(int i){
		if(top < STACK_SIZE-1){
			array[++top] = i;
		}else{
			System.out.println("Stack Full");
		}
	}
	
	public int pop(){
		if(top == -1){
			System.out.println("Stack Empty");
			return top;
		}else{
			return array[top--];
		}
	}
	
	public int peek(){
		if(top == -1){
			System.out.println("Stack Empty");
			return top;
		}else{
			return array[top];
		}
	}

	public boolean isEmpty(){
		if(top == -1) return true;
		else return false;
	}
	
	public int getTop(){
		return array[top];
	}
	
	public void printStack(){
		for(int i=top;i>=0;i--){
			System.out.println(array[i]);
		}
	}
	
	public int size(){
		return top;
	}
	
	public void sort() {
		StackArray newStArr = new StackArray();
		int temp;
		while(!this.isEmpty()){
			temp = this.pop();
			while(!newStArr.isEmpty() && newStArr.getTop() > temp){
				this.push(newStArr.pop());
			}	
			newStArr.push(temp);
		}
	}
}

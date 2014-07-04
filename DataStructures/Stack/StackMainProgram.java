
public class StackMainProgram {
	
	public static void main(String []args){
		StackArray stArr = new StackArray();
		
		System.out.println(stArr.pop());
		stArr.push(23);
		stArr.push(33);
		stArr.push(43);
		stArr.push(53);
		stArr.push(63);
		stArr.push(13);
		stArr.push(24);
		stArr.push(58);
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		System.out.println(stArr.pop());
		stArr.push(23);
		stArr.push(33);
		stArr.push(43);
		stArr.push(53);
		stArr.push(63);
		stArr.push(13);
		stArr.push(24);
		stArr.push(58);
		System.out.println();	
		
		stArr.sort();
	}

}

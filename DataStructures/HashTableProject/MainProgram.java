
public class MainProgram {

	public static void main(String []arg){
		HashTable ht = new HashTable();
		int sum = 0;

		for(int i=0;i<300;i++){
			sum =+ i;
			ht.put(i, sum);
		}
		
		for(int j=0;j<300;j++){
			if(j%2==0)
				ht.remove(j);
		}
		
		for(int j=0;j<300;j++){
			System.out.println(ht.get(j));
		}
	}
}

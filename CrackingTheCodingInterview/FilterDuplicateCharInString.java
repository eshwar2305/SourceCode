
public class FilterDuplicateCharInString {

	public void invoke(String str) {
		boolean[] visited = new boolean[256];
		int len = str.length();
		
		if(len < 2) {
			System.out.println("Final String : " + str);
		}
		
		int tail = 0;
		char[] c = str.toCharArray();
		for(int i = 0 ; i<len-1 ; i++){
			if(visited[c[i]] == false){
				visited[c[i]] = true;
				c[tail] = c[i];
				tail++;
			}
		}
		
		System.out.println("Final String: " + new String(c).substring(0, tail));
	}



}

class FilterDuplicateCharInStringMainClass{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilterDuplicateCharInString fl = new FilterDuplicateCharInString();
		fl.invoke("abcabfg");
	}
}
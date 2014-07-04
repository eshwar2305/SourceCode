
public class LongestNRCS {

	public static void main(String []args){
		String inputString;
		if(args!= null && args.length != 0){
			inputString = args[0];
		}else{
			inputString = "abhilasabhilasxyuhhhh";
			//inputString = "ab";

		}	
		findLongestNRCS(inputString);
	}

	private static void findLongestNRCS(String inputString) {
		int[] visited = new int[256];
		int prev_index;
		int cur_len = 1;
		int max_len = 1;
		int first_index=0;
		int last_index=1;
		
		
		for(int i=0;i<256;i++) visited[i] = -1;
		
		visited[0] = 0;
		
		for(int i =1 ;i < inputString.length() ; i++){
			prev_index = visited[inputString.charAt(i)];
			
			if(prev_index == -1 || i-cur_len > prev_index){
				cur_len++;
				if(i==inputString.length()-1){
					if(cur_len > max_len){
						max_len = cur_len;
						first_index = i-max_len+1;
						last_index = i+1;
					}
				}
			}else{
				if(cur_len > max_len){
					max_len = cur_len;
					first_index = i-max_len;
					last_index = i;
				}
				cur_len = i-prev_index;
			}
			visited[inputString.charAt(i)] = i;	
		}
		/*if(cur_len > max_len)
			max_len = cur_len;*/
		
		System.out.println("Maximum length = " + max_len);
		System.out.println("Substring = " + inputString.substring(first_index, last_index));
		
	}
}

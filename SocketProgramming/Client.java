import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub		

		
		try {

			
				Socket soc = new Socket("10.0.0.9",1234);
				//System.out.println(soc.getInetAddress());
	            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
	            BufferedReader stdIn =
	                new BufferedReader(
	                    new InputStreamReader(System.in));

	            /*//out.write("duDeTemp.local");
	                out.println("www.facebook.com");
	                String ipaddress;
	    	       // while ((ipaddress = in.readLine()) != null) {
		                ipaddress = in.readLine();
		                System.out.println("echo: " + ipaddress);
	    	       // }
		                System.out.println("echo: " );*/
	            
	            String inputLine,user_input;
	            boolean bye = false;
	            
	            while(!bye){
	            	while( !(user_input = stdIn.readLine()).equalsIgnoreCase(".")){
	            		System.out.println("Client: " + user_input);
	            		out.println(user_input);
	            		if(user_input.equalsIgnoreCase("bye")){
	            			bye = true;
	            			break;
	            		}
	            	}
	            	while(!(inputLine = in.readLine()).equalsIgnoreCase(".")){
	            		System.out.println("Server: " + inputLine);
	            		if(inputLine.equalsIgnoreCase("bye")){
	            			bye = true;
	            			break;
	            		}
	            	}
	            }
	                soc.close();

	        }  catch (IOException e) {
	        	e.printStackTrace();
	        } 

		
	}

}

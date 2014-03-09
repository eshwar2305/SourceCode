import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Server {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server_socket = new ServerSocket(1234);
			Socket client_socket = server_socket.accept();
			PrintWriter out_stream = new PrintWriter(client_socket.getOutputStream(),true);
			BufferedReader in_stream = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
		
			String inputLine,outputLine;
	        //while ((inputLine = in_stream.readLine()) != null) {
			inputLine = in_stream.readLine();
	        	outputLine = hostnameToipAddress(inputLine);
	        	//out_stream.println(inputLine);
	            out_stream.println(outputLine);
client_socket.close();
	        //}
	    } catch (IOException e) {
	       // System.out.println(e.getMessage());
	    }
    
		
		
	}

       public static String hostnameToipAddress(String hostname) {
		// TODO Auto-generated method stub
    		String ipAddr = "";
try {
			
			InetAddress inetAddr = InetAddress.getByName(hostname);
			
			byte[] addr = inetAddr.getAddress();

			// Convert to dot representation
		
			for (int i = 0; i < addr.length; i++) {
				if (i > 0) {
					ipAddr += ".";
				}
				ipAddr += addr[i] & 0xFF;
			}
			
			//System.out.println("IP Address: " + ipAddr);
		    
		}
		catch (UnknownHostException e) {
			System.out.println("Host not found: " + e.getMessage());
		}
return ipAddr;
	}
}

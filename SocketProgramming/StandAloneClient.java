import java.net.InetAddress;
import java.net.UnknownHostException;


public class StandAloneClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
try {
			
			InetAddress inetAddr = InetAddress.getByName("www.facebook.com");
			
			byte[] addr = inetAddr.getAddress();

			// Convert to dot representation
			String ipAddr = "";
			for (int i = 0; i < addr.length; i++) {
				if (i > 0) {
					ipAddr += ".";
				}
				ipAddr += addr[i] & 0xFF;
			}
			
			System.out.println("IP Address: " + ipAddr);
		    
		}
		catch (UnknownHostException e) {
			System.out.println("Host not found: " + e.getMessage());
		}
	}

}

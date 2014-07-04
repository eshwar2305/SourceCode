package Database;
import java.util.ArrayList;


public class Contact {
	String address;
	ArrayList<String> phoneNumberList;
	String timingInfo;
	
	public String getTimingInfo() {
		return timingInfo;
	}
	public void setTimingInfo(String timingInfo) {
		this.timingInfo = timingInfo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<String> getPhoneNumberList() {
		return phoneNumberList;
	}
	public void setPhoneNumberList(ArrayList<String> phoneNumberList) {
		this.phoneNumberList = phoneNumberList;
	}
	
	
}

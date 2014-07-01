import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MoneySplitMediator implements Mediator{

	private List<Friend> frndList;
	private HashMap<String,Integer> nameAmntSpentmap ;
	
	private int totalExpenditure = 0;
	private int amntBilledperPerson = 0;

	public MoneySplitMediator(){
		frndList = new ArrayList<Friend>();
		nameAmntSpentmap = new HashMap<String,Integer>();
	}
	
	public int expediture(String frndName, int newAmnt) {
		int totalAmntSpentByFrnd = 0;
		if(nameAmntSpentmap.containsKey(frndName)){
			int moneySpentAlready = nameAmntSpentmap.get(frndName);
			nameAmntSpentmap.remove(frndName);
			totalAmntSpentByFrnd= moneySpentAlready + newAmnt;
			nameAmntSpentmap.put(frndName, totalAmntSpentByFrnd);
		}else{
			nameAmntSpentmap.put(frndName, newAmnt);
			totalAmntSpentByFrnd = newAmnt;
		}
		totalExpenditure = totalExpenditure + newAmnt;
		return totalAmntSpentByFrnd;
	}

	public void addFriend(Friend frnd) {
		frndList.add(frnd);
	}

	public int receivable(String frndName) {
		calculate();
		return (nameAmntSpentmap.get(frndName) - amntBilledperPerson);
	
	}

	public void calculate() {
		amntBilledperPerson = totalExpenditure/nameAmntSpentmap.size();	
	}

}

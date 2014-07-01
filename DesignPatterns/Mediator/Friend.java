
public abstract class Friend {
	private int amountSpent = 0;
	private int amountRecievable = 0;
	private String name;
	private Mediator mediator;
	
	public Friend(Mediator newMediator){
		mediator = newMediator;
		mediator.addFriend(this);
	}
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = mediator.expediture(this.name, amountSpent);
		System.out.println(name + " has spent = $" + this.amountSpent);
	}
	public int getAmountRecievable() {
		amountRecievable = mediator.receivable(this.name);
		System.out.println(name + " should recieve = $" + this.amountRecievable);
		return amountRecievable;
	}
	public void setName(String name) {
		this.name = name;
	}
}

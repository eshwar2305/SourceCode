
public class testMoneySpliter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoneySplitMediator monMediator = new MoneySplitMediator();
		Jack jack = new Jack(monMediator);
		jack.setName("Jack");
		Jill jill = new Jill(monMediator);
		jill.setName("Jill");
		
		jack.setAmountSpent(1000);
		jill.setAmountSpent(300);
		
		jack.getAmountRecievable();
		jill.getAmountRecievable();
	}

}

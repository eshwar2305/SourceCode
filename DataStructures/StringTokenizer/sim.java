import java.util.StringTokenizer;


public class sim {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=2;int j=0;
		j=(i++ + i++) * --i;
		System.out.println(j);
		
		int x =3;
		
		boolean b1 = true;
		boolean b2 = false;
		
		if((b1|b2) || (x++>4))
			System.out.println("X1: " + x++);
		if((!b1 & b2) && (++x<4))
			System.out.println("x2: " + x);
		
		StringTokenizer stk1  = new StringTokenizer(",a,b",",");
		StringTokenizer stk2 = new StringTokenizer(",,ab",",");
		StringTokenizer stk3 = new StringTokenizer("ab,,,","b");
		StringTokenizer stk4 = new StringTokenizer(",ab,,a",",");
		
		
		System.out.println(stk1.countTokens() + " " + stk2.countTokens() + " " + stk3.countTokens() + " " + stk4.countTokens());
	}

}

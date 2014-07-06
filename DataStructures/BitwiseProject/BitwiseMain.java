package BitwiseProject;


public class BitwiseMain {

	public static void main(String []args){
		
		int x = 40;
		int y = 3;
		
		int result;
		
	
		BitwiseOperations bop = new BitwiseOperations();
		
		bop.swapVariables(x,y);
		
		result = bop.add(x,y);
		System.out.println("x+y = "+ x +"+" +y + " = "+ result);
		
		result = bop.sub(x,y);
		System.out.println("x-y = "+ x +"-" +y + " = "+ result);
		
		result = bop.mul(x,y);
		System.out.println("x*y = "+ x +"*" +y + " = "+ result);
		
		//result = bop.div(x,y);
		//System.out.println("x/y = "+ x +"/" +y + " = "+ result);
		
		result = bop.mod(x,16);
		System.out.println("xmody = "+ x +" mod 16 = "+ result);
		
		result = bop.exp(x,y);
		System.out.println("xPOWy = "+ x +" POW " +y + " = "+ result);
		
		result = bop.mulByExp2(x,32);
		System.out.println("x*32 = "+ x +"*32 = " + result);
		
		result = bop.divByExp(x,32);
		System.out.println("x/32 = "+ x +"/32 = " + result);
	
		System.out.println("x is exponential = "+ bop.CheckifNoExpOf2(x));
	}


}

package BitwiseProject;


public class BitwiseOperations {

	

	public void swapVariables(int x, int y) {
		
		System.out.println("Original Variables: " + "x = " + x + " and y = " + y);
		x = x^y;
		y = x^y;
		x = x^y;
		
		System.out.println("Swapped Variables: " + "x = " + x + " and y = " + y);
	}
	
	public int add(int a, int b) {
		//int g = a+b;
		//System.out.println("Add = x+y =" + g);
		int x = 0;
        x = a^b; // this is equivalent to addition when there is no carry bits.

        //if there are carry bits then u need to check this condition which determines if there is any carry bits?
        while((a&b)!=0) {
        	//a&b separates out all the carry bits and right shifting them will move the carry bits to left by one position(suitable for end result)
            b=(a&b)<<1;
            
            //take the previous sum x = a^b
            a=x;
            
            //form the new sum with previous sum and shifted carry bits
            x=a^b;
            //System.out.println("Add = x+y =" + x);
        }
        
        //System.out.println("Add = x+y =" + x);
		return x;
	}

	public int sub(int x, int y) {
		return add(x,negate(y));
		
	}
	
	public int negate(int x) {
	    return add(~x, 1);
	}

	public int mul(int x, int y) {
		int answer;
		if(x==0 || y==0) return 0;
		if(x == 1) return y;
		if(y == 1) return x;
		
		return add(x,mul(x,sub(y,1)));
	}

	
	public int mod(int x, int y) {
		// TODO Auto-generated method stub
		return x&(y-1);
	}

	public int exp(int x, int y) {
		int answer;
		if(y<0) System.exit(0);
		if(x==0) return 0;
		if(x==1) return 1;
		if(y==0) return 1;
		if(y==1) return x;
		
		return mul(x,exp(x,sub(y,1)));
	}

	/*public int div(int x, int y) {
		// TODO Auto-generated method stub
		if(greater(x, y) == y) return 0;
		
		
	}*/

	public int mulByExp2(int x, int i) {
		
		if(i==0){
			return 0;
		}
		if(CheckifNoExpOf2(i)){
			if(i==2){
				return (x<< 1);
			}else{
				return mulByExp2(x << 1, divByExp(i,2));
			}
		}else{
			return -1;
		}
		
	}

	public int divByExp(int x, int i) {
		if(i==0){
			return -1;
		}
		
		if(CheckifNoExpOf2(i)){
			if(i==2){
				return ( x >> 1);
			}else{
				return divByExp(x >> 1, divByExp(i, 2));
			}
		}else{
			return -1;
		}
		// TODO Auto-generated method stub
		
	}

	public boolean CheckifNoExpOf2(int x) {
		if( (x & (x-1)) == 0 ){
			return true;
		}else{
			return false;
		}
		
	}
	
	public boolean isPositive(int x){
		if(x == 0){
			return false;
		}else if( (x>>31) == 1){
			return false;
		}else{
			return true;
		}
	}
	
	public int greater(int x,int y){
		if(isPositive(add(x,y))){
			return x;
		}else{
			return y;
		}
	}

}

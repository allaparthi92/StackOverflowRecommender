package programcreek;

public class ReverseInteger {

	public boolean isPalindrome(int x) {
	      int result = reverse(x);
	      
	      return (result == x) ? true :false;
	   
	    }
	    
	      public int reverse(int a) {
	        	if(a < 0){
				a= a*-1;
				return -1*reverseInteger(a);//negative numbers cannot be considered as palindromes.
			}
			else
				return reverseInteger(a);
		
	    }
	    
	    
		public int reverseInteger(int a) {
			int result =0;
			while(a>0){
			    if(result > (Integer.MAX_VALUE/10))
				return 0;
				result = result*10+(a%10);
				a= a/10;
			}
			return result;
			
		}
	public static void main(String[] args) {
		ReverseInteger x = new ReverseInteger();
	System.out.println(x.reverseInteger(1534236469));

	}

}

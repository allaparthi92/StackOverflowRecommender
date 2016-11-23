
public class Strings {

	public static int isPalindrome(String A) {
		
		 if(A == null || A.length() == 1)
	            return 0;
	        
	        A = A.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
	        int n = A.length();
	       
	        for(int i = 0; i < n/2; i++){
	            if(A.charAt(i) != A.charAt(n-1-i))
	                return 0;
	        }
	        
	        return 1;
		   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

}

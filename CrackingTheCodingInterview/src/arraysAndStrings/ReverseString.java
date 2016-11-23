package arraysAndStrings;

public class ReverseString {

	public static String Reverse(String input) {
		int start = 0;
		int end = input.length() - 1;
		char[] charArray = input.toCharArray();
		while (start < end) {
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			start++;
			end--;
		}
		return String.valueOf(charArray).toLowerCase().substring(0, 1)
				.toUpperCase()
				+ String.valueOf(charArray).toLowerCase().toString()
						.substring(1);
	}

	public static String solution(String s) {

		String[] strinArray = s.split(" ");

		for (int i = 0; i < strinArray.length; i++) {
			strinArray[i] = Reverse(strinArray[i]);
		}
		StringBuilder result = new StringBuilder();
		for (int i = strinArray.length - 1; i > 0; i--) {
			result.append(strinArray[i] + " ");
		}
		result.append(strinArray[0]);
		return result.toString();
	}
	
	 public static char findTheDifference(String s, String t) {
	        
	        if((s==null  ||s.length()==0 )&& t!=null){
	            return t.charAt(0);
	        }
	     
	        
	         char sArray[] = s.toCharArray();
		         
		         char tArray[] = t.toCharArray();
		         
		         char x = sArray[0];
		         
		         
		        
		        for(int i=1;i< sArray.length;i++){
		            
		            x = (char) (x ^ sArray[i]);
		        }
		        
		         for(int i=0;i< tArray.length;i++){
		            
		            x = (char) (x ^ tArray[i]);
		        }
		        
		        return x;
		    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("Thou art thyself though not a Montague - from Romeo and Juliet"));
		System.out.println(findTheDifference("","t"));
	}
}

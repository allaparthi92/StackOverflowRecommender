package arraysAndStrings;

public class ReplaceSpaceWith20 {

	public static String replacespacewith20(String input){
		
		String array[] = input.split(" ");
		int spacecount = array.length-1;
		char[] charArray = new char[input.length()+spacecount*2];
		int k=input.length()+(spacecount*2)-1;
		for(int i=input.length()-1;i>=0;i--){
			if(input.charAt(i)==' '){
				charArray[k--] = '0';
				charArray[k--] = '2';
				charArray[k--] = '%';
			}
			else{
				charArray[k--] = input.charAt(i);
			}
		}
		return String.valueOf(charArray);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replacespacewith20("Bhanu is good key"));
	}

}

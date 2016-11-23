package arraysAndStrings;

public class StringRotation {
	
	public static boolean isRottaion(){
		String s = "erbottlewat";
		String s1 = "waterbottle";
		String s11 = s+ s;
		return s11.contains(s1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRottaion());
	}

}

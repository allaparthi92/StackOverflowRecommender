package programcreek;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		int n = 2;
		System.out.println(IsHappyNumber(n));
	}

	private static boolean IsHappyNumber(int n) {
		boolean flag = true;
		Set<Integer> s = new HashSet<>();
		s.add(n);
		int result =0;
		while(flag){
			result = 0;
			while(n>0){
				result = (int) (result + Math.pow((n%10),2));
				n=n/10;
			}
			if(result == 1)
				return true;
			if(s.contains(result))
				return false;
			s.add(result);
			n = result;
		}
		return flag;
	}

}
